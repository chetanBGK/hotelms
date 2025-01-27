package com.hotelms.ServiceImplementation;

import com.hotelms.Service.UserService;
import com.hotelms.entity.User;
import com.hotelms.exception.ResourceNotFoundException;
import com.hotelms.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserById(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id"+ id));
        return user;
    }

    @Override
    public User updateUser(User user, int id) {
        User user1 = userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id"+ id));
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        user1.setUsername(user.getUsername());
        return userRepo.save(user1);
    }

    @Override
    public String deleteUser(int id) {
        if(userRepo.findById(id).isEmpty()){
            throw new ResourceNotFoundException("User not found with id"+ id);
        }
        else {
            userRepo.deleteById(id);
            return "User deleted";
        }

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
