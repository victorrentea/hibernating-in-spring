package victor.training.jpa.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.repo.ContactRepo;
import victor.training.jpa.app.service.ContactService;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class TheController {
	private final ContactRepo repo;
	private final ContactService service;

	@GetMapping
	public List<ContactDto> getAll() {
		return repo.findAll().stream().map(ContactDto::new).collect(toList());
	}

	@GetMapping("{id}")
	public ContactDetailsDto getDetails(@PathVariable long id) {
		Optional<Contact> contact = repo.findById(id);
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
		service.addPhone(id, phoneDto.value, phoneDto.type);
	}
	
	@DeleteMapping("{id}")
	public void deleteLab(@PathVariable long id) {
		repo.deleteById(id);
	}
}
