package in.user.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.user.entities.StateMasterEntity;

public interface StatesRepo extends JpaRepository<StateMasterEntity, Serializable> {
	
	
	

	public List<StateMasterEntity> findByCountryId(Integer countryId);

}
