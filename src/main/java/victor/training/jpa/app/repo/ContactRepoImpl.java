package victor.training.jpa.app.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import victor.training.jpa.app.entity.Contact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ContactRepoImpl implements ContactRepoCustom {
	private final EntityManager em;

	public List<Contact> searchContact(ContactSearchCriteria criteria) {
		Map<String, Object> params = new HashMap<>();
		String jpql = "SELECT c FROM Contact c WHERE 1=1 ";

//		if (criteria.day != null) {
//			jpql += " AND a.day = :day";
//			params.put("day", criteria.day);
//		}
		
		TypedQuery<Contact> query = em.createQuery(jpql, Contact.class);
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		return query.getResultList();
	}

}
