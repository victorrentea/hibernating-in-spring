package victor.training.jpa.app.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import victor.training.jpa.app.service.ContactService;
import victor.training.jpa.app.web.dto.ContactPhoneDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

//	public List<ContactDto> getAll() {

//	public List<ContactDto> byFirstName(String firstName) {

//	public ContactDetailsDto getDetails(long id) {

//  ==== also insert a ChangeLog ====

	private final ContactService contactService;

//	public void addPhone(long contactId, ContactPhoneDto phoneDto) {

//	public void delete(long id) {

//	public void setCompany(long id, String company) {

}
