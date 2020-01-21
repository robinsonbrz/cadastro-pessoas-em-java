package curso.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import curso.springboot.model.Role;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long>{
	

}


