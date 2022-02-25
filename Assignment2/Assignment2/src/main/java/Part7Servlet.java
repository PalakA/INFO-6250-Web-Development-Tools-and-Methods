/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palak
 */
@WebServlet(urlPatterns = {"/Part7Servlet.htm"})
public class Part7Servlet extends HttpServlet {

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part 7</title>");
        out.println("</head>");
        out.println("<body>");
        Enumeration e = request.getParameterNames();

        out.println("<h2 style=\"text-align:center;\">Tuition Waiver Form</h2>");
        
        out.println("<table style=\"padding: 15px;border-spacing: 15px;border:1px solid black;\">");
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            String fieldName = (String) obj;
            String fieldValue = request.getParameter(fieldName);
            out.println("<tr>");
            out.println("<td>");
            out.println("<b>"+fieldName + "</b> : " + fieldValue);
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
