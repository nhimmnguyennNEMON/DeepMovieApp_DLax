package com.vn.nguyenvansy.deepmovieapp.models;

public class Movie {

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImageMovie() {
        return urlImageMovie;
    }

    public void setUrlImageMovie(String urlImageMovie) {
        this.urlImageMovie = urlImageMovie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie(int id, String title, String urlImageMovie, String genre, String director, String releaseDate, String description) {
        this.id = id;
        this.title = title;
        this.urlImageMovie = urlImageMovie;
        this.genre = genre;
        this.director = director;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    private int id;
    private String title;
    private String urlImageMovie;
    private String genre;
    private String director;
    private String releaseDate;
    private String description;

}
