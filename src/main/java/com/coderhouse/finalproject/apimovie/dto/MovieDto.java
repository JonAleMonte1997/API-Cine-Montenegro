package com.coderhouse.finalproject.apimovie.dto;

import com.coderhouse.finalproject.apimovie.model.Classified;

public class MovieDto {
	
	private Integer id;
    

	private String  title;
    private Integer year;
    private String  director;
    private String[]  gender;
    private String  plot;
    private String  poster;
    private Classified  classified;
    private Integer rate;
    private Double  duration; 	//En minutos
    private Double price;
    
	public MovieDto() {
	}

	public MovieDto(Integer id, String title, Integer year, String director, String[] gender, String plot, String poster,
			Classified classified, Integer rate, Double duration, Double price) {
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
		this.price = price;
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

	public String[] getGender() {
		return gender;
	}

	public void setGender(String[] gender) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
