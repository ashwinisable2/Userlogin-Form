package in.user.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.user.entities.UserAccountEntity;

public interface UserAccountRepo extends JpaRepository<UserAccountEntity, Serializable> {

	public UserAccountEntity findByEmailAndPassword(String email,String password);
	public UserAccountEntity findByEmail(String email);
}
