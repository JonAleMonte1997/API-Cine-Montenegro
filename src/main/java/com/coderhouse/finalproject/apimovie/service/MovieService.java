package com.coderhouse.finalproject.apimovie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.finalproject.apimovie.dto.MovieDto;
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
	
	public List<MovieDto> getMovies() {
		 List<Movie> movies = movieRepository.findAll();
		 
		 List<MovieDto> moviesDto = new ArrayList<MovieDto>();
		 
		 for (Movie movie : movies) {
			 
			 String[] genders = movie.getGender().split(",");
			 
			 
			 MovieDto movieDto = new MovieDto(movie.getId(), movie.getTitle(), movie.getYear(), movie.getDirector(), genders, movie.getPlot(), movie.getPoster(),
					 movie.getClassified(), movie.getRate(), movie.getDuration(), movie.getPrice());
			 
			 moviesDto.add(movieDto);
		}
		 
		 return moviesDto;
	}
	
	public Movie createMovie(MovieDto movieDto) {
		
		Movie movie;
		
		String genders = concateGenders(movieDto.getGender());
		
		movie = new Movie(movieDto.getTitle(), movieDto.getYear(), movieDto.getDirector(), 
				genders, movieDto.getPlot(), movieDto.getPoster(), movieDto.getClassified(), 
				movieDto.getRate(), movieDto.getDuration(), movieDto.getPrice());
		
		return movieRepository.save(movie);
	}
	
	private String concateGenders(String[] genders) {
		
		String gendersConcate = "";
		
		
		for (String gender : genders) {
			gendersConcate += gender + ",";
		}
		
		return gendersConcate;
	}
	
	public Optional<MovieDto> updateMovie(MovieDto movieDto, Integer id) {
		Optional<Movie> optionalMovieToUpdate = movieRepository.findById(id);
		
		if (optionalMovieToUpdate.isPresent()) {
			
			Movie movieToUpdate = optionalMovieToUpdate.get();
			
			String genders = concateGenders(movieDto.getGender());
			
			movieToUpdate.setTitle(movieDto.getTitle());
			movieToUpdate.setYear(movieDto.getYear());
			movieToUpdate.setDirector(movieDto.getDirector());
			movieToUpdate.setGender(genders);
			movieToUpdate.setPlot(movieDto.getPlot());
			movieToUpdate.setPoster(movieDto.getPoster());
			movieToUpdate.setClassified(movieDto.getClassified());
			movieToUpdate.setRate(movieDto.getRate());
			movieToUpdate.setDuration(movieDto.getDuration());
			movieToUpdate.setPrice(movieDto.getPrice());
			
			movieRepository.save(movieToUpdate);
			
			return Optional.ofNullable(movieDto);
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

	public Optional<MovieDto> findById(Integer id) {
		Optional<Movie> optMovie = movieRepository.findById(id);
		
		if (!optMovie.isPresent()) {
			return Optional.empty();
		}
		
		Movie movie = optMovie.get();
		
		String[] genders = movie.getGender().split(",");
		 
		 
		MovieDto movieDto = new MovieDto(movie.getId(), movie.getTitle(), movie.getYear(), movie.getDirector(), genders, movie.getPlot(), movie.getPoster(),
				 movie.getClassified(), movie.getRate(), movie.getDuration(), movie.getPrice());
		
		return Optional.of(movieDto);
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
