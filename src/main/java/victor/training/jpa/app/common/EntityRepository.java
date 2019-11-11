package victor.training.jpa.app.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    
    T getExactlyOne(ID id);

}
