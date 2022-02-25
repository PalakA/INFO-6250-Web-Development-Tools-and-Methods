/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author palak
 */
public class Book {
    List<base> book;

    public Book() {
        this.book = new ArrayList<>();
        book.add(new base("Java Servlet Programming", 29.95f));
        book.add(new base("Oracle Database Programming", 48.95f));
        book.add(new base("System Analysis and Design With UML", 14.95f));
        book.add(new base("Object Oriented Software Engineering", 35.99f));
        book.add(new base("Java Web Services", 27.99f));
    }

    public List<base> getBook() {
        return book;
    }

    public void setBook(List<base> book) {
        this.book = book;
    }
}