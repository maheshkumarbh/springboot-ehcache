package com.mk.eh.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.eh.entity.User;
import com.mk.eh.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(ObjectId id, User user) {
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isPresent()) {
            User entity = dbUser.get();
            BeanUtils.copyProperties(user, entity, new String[] {"id"});
            return userRepository.save(entity);
        } else {
            throw new UnsupportedOperationException("User Not found  for Id : "+ id);
        }
    }

    public User get(ObjectId id) {
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isPresent()) {
            return dbUser.get();
        } else {
            throw new UnsupportedOperationException("User Not found  for Id : "+ id);
        }
    }
    
}
