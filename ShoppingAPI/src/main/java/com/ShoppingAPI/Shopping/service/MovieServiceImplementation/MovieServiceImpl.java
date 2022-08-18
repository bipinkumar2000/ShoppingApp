package com.ShoppingAPI.Shopping.service.MovieServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ShoppingAPI.Shopping.dao.MoviesDao;
import com.ShoppingAPI.Shopping.entity.Movie;
import com.ShoppingAPI.Shopping.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MoviesDao moviesDao;

	@Override
	public ResponseEntity<List<Movie>> getMovies() {
		List<Movie> movies=moviesDao.findAll();
		if(movies!=null && movies.size()>0) {
			return new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Optional<Movie>> getMovie(long id) {
		Optional<Movie> movie=moviesDao.findById(id);
		if(movie!=null && !(movie.isEmpty())) {
			
			return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Optional<Movie>>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Boolean> addMovie(Movie movie) {
		if(movie!=null) {
			try{
				moviesDao.save(movie);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<Boolean> updateMovie(Movie _movie) {
		Optional<Movie> movie=moviesDao.findById(_movie.getId());
		if(movie!=null) {
			try {
				moviesDao.save(_movie);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Boolean> deleteMovie(long id) {
		if(id!=0) {
			try {
				moviesDao.deleteById(id);
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.NO_CONTENT);
		}
		
	}

}
