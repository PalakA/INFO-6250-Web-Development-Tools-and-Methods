/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.pojo.Movies;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palak
 */
public class MovieController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            String errorMessage;

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/movieView.jsp");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root", "mysql");

            if (con != null) {
                Statement statement = con.createStatement();

                if (action.equals("add")) {
                    String sql;
                    String title = request.getParameter("title");
                    String actor = request.getParameter("actor");
                    String actress = request.getParameter("actress");
                    String genre = request.getParameter("genre");
                    int yr = Integer.parseInt(request.getParameter("year"));

                    sql = "Select * from movies where title ='" + title + "'";
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next() == true) {
                        errorMessage = "SQL exception! Duplicate Enteries of title not allowed";
                        request.setAttribute("errorMessage", errorMessage);
                        rd = request.getRequestDispatcher("/WEB-INF/jsp/ErrorView.jsp");
                        rd.forward(request, response);
                    } else {
                        sql = "INSERT INTO movies VALUES('" + title + "','" + actor + "','" + actress + "','" + genre + "','" + yr + "')";
                        int rs = statement.executeUpdate(sql);
                        if (rs <= 0) {
                            errorMessage = "SQL exception! Error Occured while inserting data";
                            request.setAttribute("errorMessage", errorMessage);
                            rd = request.getRequestDispatcher("/WEB-INF/jsp/ErrorView.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("type", "addMovie");
                            rd = request.getRequestDispatcher("/WEB-INF/jsp/SuccessView.jsp");
                            rd.forward(request, response);
                        }
                    }
                } else if (action.equals("search")) {
                    String searchBy = request.getParameter("radio");
                    String keyword = request.getParameter("keyword");
                    String sql = "";
                    sql += "SELECT * FROM movies where " + searchBy + " like '%" + keyword + "%'";

                    List<Movies> listMovies = new ArrayList<>();

                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next() == false) {
                        errorMessage = "No data found in library";
                        request.setAttribute("errorMessage", errorMessage);
                        rd = request.getRequestDispatcher("/WEB-INF/jsp/ErrorView.jsp");
                        rd.forward(request, response);
                    } else {
                        while (resultSet.next()) {
                            Movies movies = new Movies(resultSet.getString("title"), resultSet.getString("actor"), resultSet.getString("actress"),
                                    resultSet.getString("genre"), resultSet.getInt("year"));
                            listMovies.add(movies);
                        }
                        request.setAttribute("type", "searchMovie");
                        if (keyword.isEmpty()) {
                            keyword = "All movies in library";
                        } else if (keyword.equals("%")) {
                            keyword = "All " + searchBy;
                        }
                        request.setAttribute("keyword", keyword);
                        request.setAttribute("list", listMovies);
                        rd.forward(request, response);
                    }
                } else {
                    if (request.getParameter("selection").equals("browse")) {
                        rd = request.getRequestDispatcher("searchMovie.html");
                    } else {
                        rd = request.getRequestDispatcher("insertMovie.html");
                    }
                    rd.forward(request, response);
                }
            } else {
                System.out.println("Error Occured: Unable to establish connection");
            }
        } catch (ClassNotFoundException e) {
            System.err.print("Class not Found! " + e.getMessage());
        } catch (SQLException e) {
            System.err.print("SQL exception!" + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
