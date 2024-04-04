package com.mk.eh.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mk.eh.entity.User;
import com.mk.eh.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody@Validated User user) {
        return ResponseEntity.status(201).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ObjectId id, @RequestBody User entity) {
        return ResponseEntity.ok(userService.update(id, entity));
    }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam ObjectId id) {

        return ResponseEntity.ok(userService.get(id));
    }
    
    
    
}
