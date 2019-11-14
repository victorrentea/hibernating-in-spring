package victor.training.jpa.app.repo;

import lombok.RequiredArgsConstructor;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.web.dto.ContactDto;
import victor.training.jpa.app.web.dto.ContactSearchCriteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ContactRepoImpl implements ContactRepoCustom {
    private final EntityManager em;
    @Override
    public List<ContactDto> search(ContactSearchCriteria criteria) {
        Map<String, Object> params = new HashMap<>();
        String jpql = "SELECT new victor.training.jpa.app.web.dto.ContactDto(x.id, x.firstName, x.lastName, x.company) FROM Contact x WHERE 1=1 ";

        if (criteria.firstName != null) {
            jpql += " AND x.firstName = :firstName";
            params.put("firstName", criteria.firstName);
        }
        TypedQuery<ContactDto> query = em.createQuery(jpql, ContactDto.class);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query.getResultList();
    }
}
