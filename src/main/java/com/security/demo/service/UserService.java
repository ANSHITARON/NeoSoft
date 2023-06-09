package com.security.demo.service;


import com.security.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {

	User signUp(User user);
    List<User> searchUser(String keywords);

	User getUserByEmail(String email);

	User getUserById(String userId);

	void deleteUser(String userId);

	User updateUser(User user, String userId);

	List<User> getAllUser();
}
