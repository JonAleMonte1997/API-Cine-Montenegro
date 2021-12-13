package com.coderhouse.finalproject.apimovie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coderhouse.finalproject.apimovie.model.Classified;
import com.coderhouse.finalproject.apimovie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query("SELECT m FROM Movie m WHERE m.title LIKE :title")
	List<Movie> findByTitle(@Param("title") String title);
	
	@Query("SELECT m FROM Movie m WHERE m.classified LIKE :classified")
	List<Movie> findByClassified(@Param("classified") Classified classified);

	@Query(value = "SELECT * FROM bd_movie.movie ORDER BY rate DESC LIMIT 3", nativeQuery = true)
	List<Movie> topMoviesByRate();
}
