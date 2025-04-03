package com.example.user_management_system.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.example.user_management_system.model.Role;

@Repository
public interface RoleRepo extends MongoRepository<Role, String>  {
    Optional<Role> findByName(String name);
    
}
