package serviceimpl;

import models.User;
import repo.UserRepository;
import service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;
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
    public void deleteUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not fund exception"));
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user, String userId) {
      User repoUser=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found exception"));
      repoUser.setUsername(user.getUsername());
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
