package com.ShoppingAPI.Shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingAPI.Shopping.entity.Movie;
import com.ShoppingAPI.Shopping.service.MovieService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/user/movie")
@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Movie>> getMovies(){
		return movieservice.getMovies();
	}
	
	@RequestMapping(value="/{movieId}",method=RequestMethod.GET)
	public ResponseEntity<Optional<Movie>> getMovie(@PathVariable long movieId){
		return movieservice.getMovie(movieId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Boolean> addMovie(@RequestBody Movie movie){
		return movieservice.addMovie(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Boolean> updateMovie(@RequestBody Movie movie)
	{
		return movieservice.updateMovie(movie);
	}
	
	@RequestMapping(value="/{movieId}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteMovie(@PathVariable long movieId){
		return movieservice.deleteMovie(movieId);
	}	
}
