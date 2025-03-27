package com.example.user_management_system.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.user_management_system.model.User;
import java.util.List;



@Repository
public interface UserRepo extends MongoRepository <User, Integer> {
    List<User>  findById(int id);
    
      
}
