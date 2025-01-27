package com.hotelms.Service;

import com.hotelms.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User findUserById(int id);
    public User updateUser(User user,int id);
    public String deleteUser(int id);
    public List<User> findAll();

}
