package com.example.user_management_system.model;

import java.util.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Users {

    @Id
    private int id;
    @NonNull
    private String name;
    private String email;
    @DBRef
    private Set<Role> roles = new HashSet<>();


    public Users (String name, String email){
        this.name = name;
        this.email = email;
    
    }

    public void addRole(Role role){
    if(this.roles == null){
        this.roles = new HashSet<>();
    }
    this.roles.add(role);
}

    public static Optional<Users> findById(String id2) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public Users createUsers(Users users) {
        throw new UnsupportedOperationException("Unimplemented method 'createUsers'");
    }
    
}
