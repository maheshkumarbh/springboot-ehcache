package com.mk.eh.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mk.eh.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{


    
}
