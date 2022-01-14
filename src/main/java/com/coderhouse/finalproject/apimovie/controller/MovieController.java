package com.coderhouse.finalproject.apimovie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.finalproject.apimovie.dto.MovieDto;
import com.coderhouse.finalproject.apimovie.model.Classified;
import com.coderhouse.finalproject.apimovie.model.Movie;
import com.coderhouse.finalproject.apimovie.service.MovieService;

@RestController
@RequestMapping("apiMovie/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

	private final MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/movies")
	public List<MovieDto> getMovies() {
		return movieService.getMovies();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/createMovie")
	public Movie createMovie(@RequestBody MovieDto movieDto) {
		return movieService.createMovie(movieDto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/updateMovie/{id}")
	public Optional<MovieDto> updateMovie(@RequestBody MovieDto movieDto, @PathVariable Integer id) {
		return movieService.updateMovie(movieDto, id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteMovie/{id}")
	public boolean deleteMovie(@PathVariable Integer id) {
		return movieService.deleteMovie(id);
	}
	
	@GetMapping("findById/{id}")
	public Optional<MovieDto> findById(@PathVariable Integer id) {
		return movieService.findById(id);
	}
	
	@GetMapping("findByTitle/{title}")
	public List<Movie> findByTitle(@PathVariable String title) {
		return movieService.findByTitle(title);
	}
	
	@GetMapping("moviesByClassified/{classified}")
	public List<Movie> getMoviesByClassified(@PathVariable Classified classified) {
		return movieService.getMoviesByClassified(classified);
	}
	
	@GetMapping("topMoviesByRate")
	public List<Movie> topMoviesByRate() {
		return movieService.topMoviesByRate();
	}
}
