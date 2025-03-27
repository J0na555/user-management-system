package com.example.user_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.user_management_system.service.UserService;
import com.example.user_management_system.model.User;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/id"})
    public List<User> getByUserId(@PathVariable int id){
        return userService.getByUserId(id);
    }
    @PostMapping 
    public void saveUser(@RequestBody User user){
        userService.SaveUser(user);
    }
    @GetMapping()
    public void deleteUser(@PathVariable  int id){
        userService.DeleteUser(id);
    }
}

