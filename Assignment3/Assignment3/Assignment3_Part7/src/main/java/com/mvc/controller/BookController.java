/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.pojo.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palak
 */
public class BookController extends HttpServlet {

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
        String action = request.getParameter("action");
        int num = Integer.parseInt(request.getParameter("num"));
        String errorMessage;
        RequestDispatcher rd;

        if (action.equals("addbooks")) {
            request.setAttribute("action", "table");
            request.setAttribute("num", num);

            rd = request.getRequestDispatcher("/WEB-INF/jsp/BookView.jsp");
            rd.forward(request, response);
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
                            rd = request.getRequestDispatcher("/WEB-INF/jsp/ErrorView.jsp");
                            rd.forward(request, response);
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
                                rd = request.getRequestDispatcher("/WEB-INF/jsp/ErrorView.jsp");
                                rd.forward(request, response);
                            } else {
                                request.setAttribute("action", "result");
                                request.setAttribute("num", num);
                                rd = request.getRequestDispatcher("/WEB-INF/jsp/BookView.jsp");
                                rd.forward(request, response);
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
