/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.pojo;

/**
 *
 * @author palak
 */
public class Movies {
    String Title;
    String Actor;
    String Actress;
    String genre;
    int year;

    public Movies(String Title, String Actor, String Actress, String genre, int year) {
        this.Title = Title;
        this.Actor = Actor;
        this.Actress = Actress;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String Actor) {
        this.Actor = Actor;
    }

    public String getActress() {
        return Actress;
    }

    public void setActress(String Actress) {
        this.Actress = Actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
