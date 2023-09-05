package in.user.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.user.bindings.LoginForm;
import in.user.service.UserService;

@RestController

public class LoginRestController {
	
	
	private UserService userService;
	
	public LoginRestController(UserService userService) {
		this.userService=userService;
	}
	
	
	//this method used to handle login functionality
	@PostMapping("/login")
	public String login(@RequestBody LoginForm form)
	{
		String status = userService.loginCheck(form);
		return status;
	}
}
