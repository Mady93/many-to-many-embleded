package com.exampleone.manytomanystronguser.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;



	@Entity
	@Table(name = "join_table")
	public class JoinTable {
		
		//istanza inner class senza argomenti
	  @EmbeddedId
	  private JoinTableId id = new JoinTableId();

	  @ManyToOne
	  @MapsId("userId")
	  private User user;

	  @ManyToOne
	  @MapsId("movieId")
	  private Movie movie;

	  @Column(nullable = false)
	  private int rate;

	  @Lob
	  private String review;

	  @CreationTimestamp
	  @Column(name = "added_at", nullable = false)
	  private Date addedAt;

	  // costruttori + get e set inner class + get e set join table
	  public JoinTable() {}

	  public JoinTable(JoinTableId id, int rate, String review) {
	    this.id = id;
	    this.rate = rate;
	    this.review = review;
	  }

	  public JoinTableId getId() {
	    return id;
	  }

	  public User getUser() {
	    return user;
	  }

	  public Movie getMovie() {
	    return movie;
	  }

	  public int getRate() {
	    return rate;
	  }

	  public String getReview() {
	    return review;
	  }

	  public Date getAddedAt() {
	    return addedAt;
	  }

	  
	  
	  public void setUser(User user) {
		this.user = user;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}



	// inner class
	  @Embeddable
	  public static class JoinTableId implements Serializable {

	    private static final long serialVersionUID = 1L;

	    private Integer userId;
	    private Integer movieId;

	    public JoinTableId() {}

	    public JoinTableId(Integer userId, Integer movieId) {
	      super();
	      this.userId = userId;
	      this.movieId = movieId;
	    }

	    public Integer getUserId() {
	      return userId;
	    }

	    public Integer getMovieId() {
	      return movieId;
	    }

	    public void setUserId(Integer userId) {
	      this.userId = userId;
	    }

	    public void setMovieId(Integer movieId) {
	      this.movieId = movieId;
	    }
	  }
	}
