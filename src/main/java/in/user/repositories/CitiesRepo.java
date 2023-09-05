package in.user.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.user.entities.CitiesMasterEntity;

public interface CitiesRepo extends JpaRepository<CitiesMasterEntity, Serializable> {

	public List<CitiesMasterEntity> findByStateId(Integer stateId);
}
