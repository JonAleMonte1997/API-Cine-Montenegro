package com.coderhouse.finalproject.apimovie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	@NotNull
    private String  title;
	
    private Integer year;
    private String  director;
    private String  gender;
    
    @Column(length = 1000)
    private String  plot;
    
    private String  poster;
    
    @Enumerated(EnumType.STRING)
    private Classified  classified;
    
    private Integer rate;
    private Double  duration; 	//En minutos
    
	public Movie() {
	}

	public Movie(Integer id, String title, Integer year, String director, String gender, String plot, String poster,
			Classified classified, Integer rate, Double duration) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.gender = gender;
		this.plot = plot;
		this.poster = poster;
		this.classified = classified;
		this.rate = rate;
		this.duration = duration;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Classified getClassified() {
		return classified;
	}
	public void setClassified(Classified classified) {
		this.classified = classified;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
}
