package com.ShoppingAPI.Shopping.service.MovieServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingAPI.Shopping.dao.MoviesDao;
import com.ShoppingAPI.Shopping.entity.Movie;
import com.ShoppingAPI.Shopping.service.MovieService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MoviesDao moviesDao;

	@Override
	public ResponseEntity<List<Movie>> getMovies() {
		List<Movie> movies = moviesDao.findAll();
		if (movies != null && movies.size() > 0) {
			return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	@Cacheable(value = "moviesbooking", key = "#movieId")
	public ResponseEntity<Optional<Movie>> getMovie(long movieId) {
		Optional<Movie> movie = moviesDao.findById(movieId);
		if (movie != null && !(movie.isEmpty())) {

			return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
		} else {
			return new ResponseEntity<Optional<Movie>>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Cacheable(value="moviesbooking",key="#movie")
	public ResponseEntity<Boolean> addMovie(Movie movie) {
		if (movie != null) {
			try {
				moviesDao.save(movie);
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CachePut(value = "moviesbooking", key = "#movie.movieId")
	public ResponseEntity<Boolean> updateMovie(Movie movie) {
		Optional<Movie> _movie = moviesDao.findById(movie.getMovieId());
		if (_movie != null) {
			try {
				moviesDao.save(movie);
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@CacheEvict(value = "moviesbooking", key = "#movieId")
	public ResponseEntity<Boolean> deleteMovie(long movieId) {
		if (movieId != 0) {
			try {
				moviesDao.deleteById(movieId);
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
		}

	}

	@Override
	@CacheEvict(value = "moviesbooking", allEntries = true)
	public void EvictCache() {

	}

}
