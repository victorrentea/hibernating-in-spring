package victor.training.jpa.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.repo.ContactRepo;
import victor.training.jpa.app.service.ContactService;
import victor.training.jpa.app.web.dto.ContactDetailsDto;
import victor.training.jpa.app.web.dto.ContactDto;
import victor.training.jpa.app.web.dto.ContactPhoneDto;
import victor.training.jpa.app.web.dto.ContactSearchCriteria;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactRepo contactRepo;
    private final ContactService contactService;

    @GetMapping
	public List<ContactDto> getAll() {
        return contactRepo.findAll().stream()
                .map(ContactDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("byName/{firstName}")
	public List<ContactDto> byFirstName(@PathVariable String firstName) {
        List<Contact> contacts = contactRepo.findByFirstNameLike("%" + firstName + "%");
        return contacts.stream().map(ContactDto::new).collect(Collectors.toList());
    }

    @GetMapping("{contactId}")
	public ContactDetailsDto getDetails(@PathVariable long contactId) {
        Contact contact = contactRepo.findWithPhones(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Ntz!!!! there is no sheep with id " + contactId));
        return new ContactDetailsDto(contact);
    }

    @PostMapping("search")
    public List<ContactDto> search(@RequestBody ContactSearchCriteria criteria) {
        return contactRepo.search(criteria);
    }

//  ==== also insert a ChangeLog ====

    @PostMapping("{contactId}/phone")
	public void addPhone(@PathVariable long contactId,@RequestBody ContactPhoneDto phoneDto) {
        contactService.addPhone(contactId, phoneDto.value, phoneDto.type);
    }

    @PutMapping("{contactId}/company")
	public void setCompany(@PathVariable long contactId, @RequestBody String company) {
        contactService.setCompany(contactId, company);
    }

}
