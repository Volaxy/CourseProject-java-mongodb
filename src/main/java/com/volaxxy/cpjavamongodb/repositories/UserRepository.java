package com.volaxxy.cpjavamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.volaxxy.cpjavamongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
