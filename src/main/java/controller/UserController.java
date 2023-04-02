package controller;


import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payload.ApiResponseMessage;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userservice;

	@PostMapping(value="/signUp")
	public ResponseEntity<User> signUp(@RequestParam String username, @RequestParam String password, @RequestParam String role) {

		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		User savedUser =userservice.signUp(user);

		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	@PutMapping("/{userID}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @RequestBody User user)
	{
		return new ResponseEntity<>(userservice.updateUser(user,userId),HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId){
		userservice.deleteUser(userId);
		ApiResponseMessage message= ApiResponseMessage.builder().message("user not found exception").success(true).Status(HttpStatus.OK).build();
		return new ResponseEntity<>(message,HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<>(userservice.getAllUser(),HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId)
	{
		return new ResponseEntity<>(userservice.getUserById(userId),HttpStatus.OK);
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email)
	{
		return new ResponseEntity<>(userservice.getUserByEmail(email),HttpStatus.OK);
	}

	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<User>> searchUser(@PathVariable String keywords)
	{
		return new ResponseEntity<>(userservice.searchUser(keywords),HttpStatus.OK);
	}


	
	
	
	

}
