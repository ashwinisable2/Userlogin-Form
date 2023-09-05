package in.user.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.user.service.UserService;

@RestController
public class ForgotPwdRestController {
	
	
	private UserService userService;
	
	public ForgotPwdRestController(UserService userService)
	{
		this.userService=userService;
	}
	@GetMapping("/forgotPwd/{email}")
	public String forgotPwd(@PathVariable String email)
	{
		String status= userService.forgotPwd(email);
		return status;
	}
}
