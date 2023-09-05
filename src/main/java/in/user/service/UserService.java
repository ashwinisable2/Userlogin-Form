package in.user.service;

import java.util.Map;

import in.user.bindings.LoginForm;
import in.user.bindings.UserForm;

public interface UserService {
	
	public String loginCheck(LoginForm loginForm);
	
	public Map<Integer,String> getCountries();
	
	public Map<Integer,String> getStates(Integer countryId);
	
	public Map<Integer,String> getCities(Integer stateId);
	
	public boolean emailUnique(String email);
	
	public boolean saveUser(UserForm userForm);

	public String forgotPwd(String emailId);
}
