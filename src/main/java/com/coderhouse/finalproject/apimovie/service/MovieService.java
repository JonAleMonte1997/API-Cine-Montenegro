package com.coderhouse.finalproject.apimovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.finalproject.apimovie.model.Classified;
import com.coderhouse.finalproject.apimovie.model.Movie;
import com.coderhouse.finalproject.apimovie.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	
	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}
	
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Optional<Movie> updateMovie(Movie movie, Integer id) {
		Optional<Movie> optionalMovieToUpdate = movieRepository.findById(id);
		
		if (optionalMovieToUpdate.isPresent()) {
			
			Movie movieToUpdate = optionalMovieToUpdate.get();
			
			movieToUpdate.setTitle(movie.getTitle());
			movieToUpdate.setYear(movie.getYear());
			movieToUpdate.setDirector(movie.getDirector());
			movieToUpdate.setGender(movie.getGender());
			movieToUpdate.setPlot(movie.getPlot());
			movieToUpdate.setPoster(movie.getPoster());
			movieToUpdate.setClassified(movie.getClassified());
			movieToUpdate.setRate(movie.getRate());
			movieToUpdate.setDuration(movie.getDuration());
			
			movieRepository.save(movieToUpdate);
			
			return Optional.ofNullable(movieToUpdate);
		}
		
		return Optional.ofNullable(null);
	}
	
	public boolean deleteMovie(Integer id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if (movie.isPresent()) {
			movieRepository.delete(movie.get());
			return true;
		}
		return false;
	}

	public Optional<Movie> findById(Integer id) {
		return movieRepository.findById(id);
	}

	public List<Movie> findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}

	public List<Movie> getMoviesByClassified(Classified classified) {
		return movieRepository.findByClassified(classified);
	}

	public List<Movie> topMoviesByRate() {
		return movieRepository.topMoviesByRate();
	}
}
