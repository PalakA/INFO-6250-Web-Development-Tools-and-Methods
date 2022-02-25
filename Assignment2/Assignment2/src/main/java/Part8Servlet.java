/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palak
 */
@WebServlet(urlPatterns = {"/Part8Servlet.htm"})
public class Part8Servlet extends HttpServlet {

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
        out.println("<title>TuitionFeeWaiver Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 style=\"text-align:center;\">Tuition Waiver Form</h2>");

        out.println("<table style=\"padding: 15px;border-spacing: 15px;border:1px solid black;\">");
        Map<String, String[]> map = request.getParameterMap();
        for (String key : map.keySet()) {
            for (String value : map.get(key)) {
                out.println("<tr><td><b>" + key + "<b>:</td><td> " + value + "<td></tr>");
            }
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
