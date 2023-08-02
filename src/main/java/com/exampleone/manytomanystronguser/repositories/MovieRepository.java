package com.exampleone.manytomanystronguser.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exampleone.manytomanystronguser.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
