package service;


import models.User;

import java.util.List;

public interface UserService {

	void signUp(User user);
	List<User> findAll();


}
