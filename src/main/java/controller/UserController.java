package controller;


import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userservice;
	@GetMapping("/")
	public List<User> getAllUser()
	{
		return this.userservice.findAll();
	}

	@PostMapping(value="/signUp")
	public String signUp(@RequestParam String username, @RequestParam String password, @RequestParam String role) {

		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		userservice.signUp(user);

		return "success";
	}
	
	
	
	

}
