package in.user.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;


import in.user.entities.CountryMasterEntity;

public interface CountryRepo extends JpaRepository<CountryMasterEntity, Serializable>{

	}

