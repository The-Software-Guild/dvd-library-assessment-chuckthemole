/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.dvdlibrary.dto;

/**
 *
 * @author Chuck
 */
public class Dvd {
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String userRating;
            
    public Dvd(String movieTitle) {
        this.title = movieTitle;
    }
    
    public Dvd(String movieTitle, String releaseDate, String mpaaRating, String director, String studio, String userRating) {
        this.title = movieTitle;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String date) {
        this.releaseDate = date;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String rating) {
        this.mpaaRating = rating;
    }

    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    public String getStudio() {
        return studio;
    }
    
    public void setStudio(String studio) {
        this.studio = studio;
    } 
    
    public String getUserRating() {
        return userRating;
    }
    
    public void setUserRating(String rating) {
        this.userRating = rating;
    }
}
