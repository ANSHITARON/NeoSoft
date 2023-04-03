package com.security.demo.serviceimpl;

import com.security.demo.models.User;
import com.security.demo.repo.UserRepository;
import com.security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User signUp(User user) {
        User savedUser =userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> searchUser(String keywords) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(String userId) {
       User user= userRepository.findById(userId).orElseThrow(()->new RuntimeException("not found"));
        return user;
    }

    @Override
    public void VoidodeleteUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not fund exception"));
        userRepository.delete(user);

    }

    @Override
    public User updateUser(User user, String userId) {
      User repoUser=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found exception"));
     // repoUser.setUsername(user.getUsername());
      repoUser.setPassword(user.getPassword());
      repoUser.setRole(user.getRole());
      User updateduser=userRepository.save(repoUser);
        return updateduser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users=userRepository.findAll();
        return users;
    }
}
