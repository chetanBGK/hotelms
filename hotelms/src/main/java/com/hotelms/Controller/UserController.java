package com.hotelms.Controller;

import com.hotelms.Service.UserService;
import com.hotelms.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("createuser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @PutMapping("updateuser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("deleteuser/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("getall")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
