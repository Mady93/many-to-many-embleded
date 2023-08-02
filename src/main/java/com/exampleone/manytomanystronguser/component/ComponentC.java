package com.exampleone.manytomanystronguser.component;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.exampleone.manytomanystronguser.entities.JoinTable;
import com.exampleone.manytomanystronguser.entities.JoinTable.JoinTableId;
import com.exampleone.manytomanystronguser.entities.Movie;
import com.exampleone.manytomanystronguser.entities.User;
import com.exampleone.manytomanystronguser.repositories.JoinTableRepository;
import com.exampleone.manytomanystronguser.repositories.MovieRepository;
import com.exampleone.manytomanystronguser.repositories.UserRepository;

@Component
public class ComponentC implements ApplicationListener<ContextRefreshedEvent> {
	
	  private final MovieRepository movieRepository;
	  private final JoinTableRepository joinTableRepository;
	  private final UserRepository userRepository;

	  public ComponentC(UserRepository userRepository, MovieRepository movieRepository, JoinTableRepository joinTableRepository) {
	    this.userRepository = userRepository;
	    this.movieRepository = movieRepository;
	    this.joinTableRepository = joinTableRepository;
	  }

	  @Override
	  public void onApplicationEvent(ContextRefreshedEvent event) {
	    Movie movie1 = new Movie("Movie 1", "Movie 1 description", 2020);
	    Movie movie2 = new Movie("Movie 2", "Movie 2 description", 2021);

	    Movie createdMovie1 = movieRepository.save(movie1);
	    Movie createdMovie2 = movieRepository.save(movie2);

	    User user = new User("user@email.com", "John Doe");

	    User createdUser = userRepository.save(user);

	    JoinTable.JoinTableId joinTableId1 = new JoinTableId(createdUser.getId(), createdMovie1.getId());
	    JoinTable joinTable1 = new JoinTable(joinTableId1, 4, "This is a good movie");
	    joinTable1.setUser(createdUser);
	    joinTable1.setMovie(createdMovie1);

	    JoinTable.JoinTableId joinTable1Id2 = new JoinTableId(createdUser.getId(), createdMovie2.getId());
	    JoinTable joinTable2 = new JoinTable(joinTable1Id2, 5, "This is an awesome movie!");
	    joinTable2.setUser(createdUser);
	    joinTable2.setMovie(createdMovie2);

	    joinTableRepository.save(joinTable1);
	    joinTableRepository.save(joinTable2);

	    Iterable<JoinTable> joinTableList = joinTableRepository.findAll();

	    joinTableList.forEach(um -> {
	      System.out.println("The user " + um.getUser().getName() + " gave a rate of " + um.getRate() + " to the movie " + um.getMovie().getName());
	    });
	  }
}
