package com.exampleone.manytomanystronguser.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exampleone.manytomanystronguser.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
