/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author palak
 */
public class XlsDriver extends HttpServlet {

    public List<List<String>> row = new ArrayList<>();
    public List<String> head = new ArrayList<>();
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            // Load the driver.
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            String fileName = request.getParameter("inputFile");
            
            String path = "D:\\HW2";
            String url = "jdbc:relique:csv:";
            
            // Create a connection. CSV file is in D:
            Connection conn = DriverManager.getConnection(url+path);
            
            // Create a Statement object to execute the query with.
            Statement stmt = conn.createStatement();
            // Select columns from parking_facilities.csv
            ResultSet results = stmt.executeQuery("SELECT * FROM " + fileName);
            ResultSetMetaData rsmd = results.getMetaData();
            head.clear();
            int i = 1;
            while (i <= 12)
                head.add(rsmd.getColumnName(i++));
            row.clear();
            while (results.next()) {
                i = 1;
                List<String> col = new ArrayList<>();
                while (i <= 12)
                    col.add(results.getString(i++));
                row.add(col);
            }
            // Clean up
            conn.close();

            request.setAttribute("list", row);
            request.setAttribute("tblHead", head);
            request.getRequestDispatcher("Part4.jsp").forward(request, response);
        } catch (Exception e) {
            try {
                PrintWriter out = response.getWriter();
                out.println("<br>");
                out.println("<h3>File Does not exist! Try naming another from the same directory or change directory in the code.</h3>");
                out.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
    
    public List<List<String>> getRow() {
        return row;
    }

    public void setRow(List<List<String>> row) {
        this.row = row;
    }

    public List<String> getHead() {
        return head;
    }

    public void setHead(List<String> head) {
        this.head = head;
    }
}
