/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment4_part5.controller;

import com.mycompany.assignment4_part5.pojo.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author palak
 */
public class BookController extends AbstractController {

    public BookController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        int num = Integer.parseInt(request.getParameter("num"));
        ModelAndView mav = new ModelAndView();

        String errorMessage;

        if (action.equals("addbooks")) {
            request.setAttribute("action", "table");
            request.setAttribute("num", num);

            mav.setViewName("BookView");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb", "root", "mysql");

                if (con != null) {
                    for (int i = 1; i <= num; i++) {

                        String sql;
                        String isbn = request.getParameter("isbn" + i);
                        Statement stmt = con.createStatement();

                        sql = "Select * from books where isbn ='" + isbn + "'";
                        ResultSet resultSet = stmt.executeQuery(sql);
                        if (resultSet.next() == true) {
                            errorMessage = "SQL exception! Duplicate Enteries of ISBN not allowed";
                            request.setAttribute("errorMessage", errorMessage);
                            mav.setViewName("ErrorView");
                        } else {
                            sql = "INSERT INTO books VALUES (?, ?, ?, ?)";

                            Book b = new Book(request.getParameter("isbn" + i), request.getParameter("title" + i),
                                    request.getParameter("authors" + i), Float.parseFloat(request.getParameter("price" + i)));
                            PreparedStatement statement = con.prepareStatement(sql);
                            statement.setString(1, b.getIsbn());
                            statement.setString(2, b.getTitle());
                            statement.setString(3, b.getAuthors());
                            statement.setFloat(4, b.getPrice());

                            int rowsInserted = statement.executeUpdate();
                            if (rowsInserted <= 0) {
                                errorMessage = "SQL exception! Error Occured while inserting data";
                                request.setAttribute("errorMessage", errorMessage);
                                mav.setViewName("ErrorView");
                            } else {
                                request.setAttribute("action", "result");
                                request.setAttribute("num", num);
                                mav.setViewName("BookView");
                            }
                        }
                    }
                } else {
                    System.out.println("Error Occured: Unable to establish connection");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not Found! " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("SQL exception!" + e.getMessage());
            }
        }
        return mav;
    }

}
