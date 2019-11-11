package victor.training.jpa.app.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class EntityRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements EntityRepository<T, ID> {
    protected EntityManager entityManager;
    
    public EntityRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager ;
    }

	@Override
	public T getExactlyOne(ID id) {
		return findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("No " + getDomainClass().getSimpleName() + " with id " + id));
	}
	
}
