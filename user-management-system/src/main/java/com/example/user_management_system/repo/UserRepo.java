package com.example.user_management_system.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.user_management_system.model.Users;
import java.util.*;



@Repository
public interface UserRepo extends MongoRepository <Users, Integer> {
    Optional<Users>  findById(int id);

    void deleteById(String id);

    Optional<Users> findById(String id);
    
      
}
