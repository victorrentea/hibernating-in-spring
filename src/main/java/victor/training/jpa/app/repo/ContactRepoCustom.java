package victor.training.jpa.app.repo;

import victor.training.jpa.app.web.dto.ContactDto;
import victor.training.jpa.app.web.dto.ContactSearchCriteria;

import java.util.List;

public interface ContactRepoCustom {
    List<ContactDto> search(ContactSearchCriteria criteria);
}
