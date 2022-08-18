package com.ShoppingAPI.Shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.entity.Movie;

@Service
public interface MovieService {
	
	public ResponseEntity<List<Movie>> getMovies();
	
	public ResponseEntity<Optional<Movie>> getMovie(long id);
	
	public ResponseEntity<Boolean> addMovie(Movie Movie);
	
	public ResponseEntity<Boolean> updateMovie(Movie Movie);
	
	public ResponseEntity<Boolean> deleteMovie(long id);

}
