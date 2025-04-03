package com.example.user_management_system.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.user_management_system.service.UserService;
import com.example.user_management_system.model.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Users creaUsers(@RequestBody Users users){
        return users.createUsers(users);
    }

    @PostMapping("/create")
    public Users createuser(@RequestParam String name, @RequestParam String email, @RequestParam String role ) {
        
        return userService.createUserWithRole(name, email, role);
    }

    @GetMapping({"/id"})
    public Optional<Users> getByUserId(@PathVariable int id){
        return userService.getByUserId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable String id, @RequestBody Users users) {
        
        return ResponseEntity.ok(userService.updateUser(id, users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable String id){
        userService.deletUsers(id);
        return ResponseEntity.ok("User deleted successfully");
    }
   
}

