package com.mk.eh.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import lombok.Data;

@Data
@Document("users")
public class User {

    @Id
    private ObjectId id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String role;
    private String mobile;
    private String email;

} 
