package com.example.user_management_system.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_management_system.model.User;
import com.example.user_management_system.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    
    public List<User> getByUserId(int id){
        return userRepo.findById(id);
    }
    public void SaveUser(User user){
        userRepo.save(user);
    }
    public void DeleteUser(int id){
        userRepo.deleteById(id);
    }


    }
