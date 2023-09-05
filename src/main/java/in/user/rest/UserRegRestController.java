package in.user.rest;

import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.user.bindings.UserForm;
import in.user.constants.AppConstants;
import in.user.service.UserService;

@RestController
public class UserRegRestController {

	private UserService userService;
	
	public UserRegRestController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/countries")
	public Map<Integer,String> countries()
	{
		return userService.getCountries();
	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer,String> states(@PathVariable Integer countryId)
	{
		return userService.getStates(countryId);
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer,String> cities(@PathVariable Integer stateId)
	{
		return userService.getCities(stateId);
	}
	
	@GetMapping("/emailCheck/{email}")
	public String emailCheck(String email)
	{
		boolean emailUnique = userService.emailUnique(email);
		if(emailUnique)
		{
			return AppConstants.UNIQUE;
		}
			return AppConstants.DUPLICATE;
	}
	
	@PostMapping("/saveuser")
	public String saveuser(@RequestBody UserForm userForm)
	{
		boolean saveUser = userService.saveUser(userForm);
		if(saveUser)
		{
			return AppConstants.SUCCESS;
		}
		return AppConstants.FAIL;
	}
	
}
