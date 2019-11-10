package victor.training.jpa.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.entity.ContactFirstAndLastName;
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


	// TODO 1 only take out first and last name
	// TODO 2 dynamic projections ,Class<?>)

	@GetMapping("names")
	public List<ContactFirstAndLastName> getAllNames() {
		List<ContactFirstAndLastName> list = contactRepo.findAll(ContactFirstAndLastName.class);
		System.out.println(list);
		System.out.println(list.get(0).getClass());
		System.out.println(list.stream().map(ContactFirstAndLastName::getFirstName).collect(Collectors.joining()));
		return list;
	}

	@GetMapping("{id}")
	public ContactDetailsDto getDetails(@PathVariable long id) {
		Optional<Contact> contact = contactRepo.findWithPhones(id);
		return new ContactDetailsDto(contact.get());
	}


	
//	@PutMapping("{id}/phones")
//	public void assignLabTeacher(@PathVariable long id, @RequestBody Long teacherId) {
//		facade.assignTeacherToLab(teacherId, id);
//	}
//
//	@DeleteMapping("{labId}/teacher")
//	public void removeTeacherFromLab(@PathVariable long labId, @RequestBody Long teacherId) {
//		facade.removeTeacherFromLab(teacherId, labId);
//	}
	
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
