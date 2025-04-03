package com.example.user_management_system.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_management_system.model.Role;
import com.example.user_management_system.model.Users;
import com.example.user_management_system.repo.UserRepo;
import com.example.user_management_system.repo.RoleRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    
    public Optional<Users> getByUserId(int id){
        return userRepo.findById(id);
    }

    public Users createUserWithRole(String name, String email, String roleName){
        Users user = new Users (name,email);

        Role role = roleRepo.findByName(roleName).orElseThrow(()-> new RuntimeException("Role not found"));
        user.addRole(role);

        return userRepo.save(user);
    }

    public Users createUsers( Users users){
        return userRepo.save(users);
    }

    public Users updateUser (String id, Users newUsers){
		return userRepo.findById(id).map(user -> {
		user.setName(newUsers.getName());
		user.setEmail(newUsers.getEmail());
		return userRepo.save(user);
		}).orElseThrow(() -> new RuntimeException("User not found"));
	}

    public void deletUsers(String id){
        userRepo.deleteById(id);
    }

}
