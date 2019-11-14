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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import victor.training.jpa.app.common.GetCurrentUserUtil;
import victor.training.jpa.app.common.MyTrackingEntityListener.Traceable;

@Slf4j
@Getter
@Setter
@Entity
// TODO @PrePersist
// TODO @EntityListeners( ... + implements Traceable
// TODO LastModifiedBy + AuditingEntityListener.class
@EntityListeners(AuditingEntityListener.class)
public class Contact {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	@Column(length = 20)
	private String company;

	@ElementCollection
	private Set<Tag> tags = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contact")
	private Set<Phone> phones = new HashSet<>();

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	@LastModifiedBy
	private String lastModifiedBy;

//	@PreUpdate
//	@PrePersist
//	public void setTrackingInfo() {
//		lastModifiedDate = LocalDateTime.now();
//		lastModifiedBy = GetCurrentUserUtil.getCurrentUser();
//	}

	protected Contact() { } // Hibernate

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
				", lastModifiedDate=" + lastModifiedDate +
				", lastModifiedBy='" + lastModifiedBy + '\'' +
				'}';
	}

}
	
