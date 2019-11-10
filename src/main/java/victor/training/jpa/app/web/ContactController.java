package victor.training.jpa.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.repo.ContactFirstAndLastName;
import victor.training.jpa.app.repo.ContactRepo;
import victor.training.jpa.app.service.ChangeLogService;
import victor.training.jpa.app.service.ContactService;
import victor.training.jpa.app.web.dto.ContactDetailsDto;
import victor.training.jpa.app.web.dto.ContactDto;
import victor.training.jpa.app.web.dto.ContactPhoneDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	private final ContactRepo contactRepo;
	private final ContactService contactService;
	private final ChangeLogService changeLogService;

	@GetMapping
	public List<ContactDto> getAll() {
		return contactRepo.findAll().stream().map(ContactDto::new).collect(toList());
	}

	@GetMapping("byFirst/{firstName}")
	public List<ContactDto> byFirstName(@PathVariable String firstName) {
		return contactRepo.findContactByFirstNameIsLike(firstName).stream().map(ContactDto::new).collect(toList());
	}

	// TODO 1 only take out first and last name
	// TODO 2 dynamic projections ,Class<?>)

	@GetMapping("names")
	public List<ContactFirstAndLastName> getAllNames() {
		return contactRepo.findAllNames();
	}

	@GetMapping("{id}")
	public ContactDetailsDto getDetails(@PathVariable long id) {
		Contact contact = contactRepo.getById(id);
		return new ContactDetailsDto(contact);
	}

	@PostMapping("{id}/phone")
	public void addPhone(@PathVariable long id, @RequestBody ContactPhoneDto phoneDto) {
		contactService.addPhone(id, phoneDto.value, phoneDto.type);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		contactService.deleteContact(id);
	}

	@PutMapping("{id}/company")
	public void setCompany(@PathVariable long id,@RequestBody String company) {
		contactService.setCompany(id, company);
	}

}
