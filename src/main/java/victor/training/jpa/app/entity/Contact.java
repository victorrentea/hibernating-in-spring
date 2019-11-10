package victor.training.jpa.app.entity;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import victor.training.jpa.app.common.MyTrackingEntityListener.Traceable;

@Slf4j
@Getter
@Setter
@Entity
// TODO @EntityListeners( ... + implements Trackable
// TODO LastModifiedBy
public class Contact implements Traceable {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String company;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Tag> tags = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Phone> phones = new HashSet<>();

	@LastModifiedDate // SOLUTION
	private LocalDateTime lastModifiedDate;

	@CreatedBy
	@LastModifiedBy // SOLUTION
	private String lastModifiedBy;

	private Contact() { } // Hibernate

	public Contact(String firstName, String lastName, String company, Tag... tags) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.tags = new HashSet<>(Arrays.asList(tags));
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
//				", phones=" + phones +
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
	
