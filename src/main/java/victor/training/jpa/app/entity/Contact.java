package victor.training.jpa.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import victor.training.jpa.app.common.MyTrackingEntityListener.Traceable;

@Slf4j
@Data
@Entity
// TODO @EntityListeners( ... + implements Trackable
// TODO LastModifiedBy
public class Contact implements Traceable, ContactFirstAndLastName {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String company;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Phone> phones = new ArrayList<>();

	@LastModifiedDate // SOLUTION
	private LocalDateTime lastModifiedDate;

	@CreatedBy
	@LastModifiedBy // SOLUTION
	private String lastModifiedBy;

	private Contact() { } // Hibernate

	public Contact(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	public Contact addPhone(Phone phone) {
		phones.add(phone);
		phone.setContact(this);
		return this;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", company='" + company + '\'' +
				", phones=" + phones +
				", lastModifiedDate=" + lastModifiedDate +
				", lastModifiedBy='" + lastModifiedBy + '\'' +
				'}';
	}

	//	@PrePersist
//	@PreUpdate
//	public void automaticUpdateTrackingColumns() {
//		log.debug("Before persist/update Contact");
//		lastModifiedDate = LocalDateTime.now();
//		lastModifiedBy = GetCurrentUserUtil.getCurrentUser();
//	}
}
	
