/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author palak
 */
public class Part6Servlet extends HttpServlet {

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
        out.println("<link rel=\"stylesheet\" href=\"tuition.css\">");
        out.println("</head>");

        out.println("<body>");
        out.println("<h2 style=\"text-align:center;\">Tuition Waiver Form</h2>");
        out.println("<table style=\"padding: 15px;border-spacing: 15px;border:1px solid black;margin-left:auto;margin-right:auto;\">");

        out.println("<tr>");
        out.println("<td><b>Academic Term: </b>" + request.getParameter("academicTerm") + "</td>");
        out.println("<td><b>Academic Year: </b>" + request.getParameter("academicYear") + "</td>");
        out.println("<td><b>Employee Status: </b>" + request.getParameter("employeeStatus") + "</td>");
        if (request.getParameter("employeeStatus") != null) {
            out.println("<td><b>Other Employee Status: </b>" + request.getParameter("employeeStatusOther") + "</td>");
        }
        out.println("</tr>");

        out.println("<td><b>Student's Name: </b>" + request.getParameter("name") + "</td>");
        out.println("<td><b>Relationship to Employee: </b>" + request.getParameter("relationshiptoEmployee") + "</td>");
        out.println("<td><b>Student's NUID: </b>" + request.getParameter("studentNUID") + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Employee's Name: </b>" + request.getParameter("empName") + "</td>");
        out.println("<td><b>Employee's NUID: </b>" + request.getParameter("empNUID") + "</td>");
        out.println("<td><b>Department: </b>" + request.getParameter("department") + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Campus Location: </b>" + request.getParameter("campusLocation") + "</td>");
        out.println("<td><b>Phone Number: </b>" + request.getParameter("phoneNumber") + "</td>");
        out.println("<td><b>Supervisor's Name: </b>" + request.getParameter("supervisorName") + "</td>");
        out.println("<td><b>School / Program: </b>" + request.getParameter("program") + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td colspan=\"8\"><table style=\"padding: 15px; border: solid black 1px;\"><thead><th>Course No.</th>"
                + "<th>Course Name</th><th>Supervisor Signature</th><th>Credit Hrs.</th>"
                + "<th>Day(s)</th><th>Time</th><th>&nbsp</th></thead>");

        out.println("<tr><td>" + request.getParameter("courseNo_1") + "</td>");
        out.println("<td>" + request.getParameter("courseName_1") + "</td>");
        out.println("<td>" + request.getParameter("supervisorSignature_1") + "</td>");
        out.println("<td>" + request.getParameter("creditHrs_1") + "</td>");
        out.println("<td>" + request.getParameter("days_1") + "</td>");
        out.println("<td>" + request.getParameter("time_1") +" "+ request.getParameter("ampm_1") + "</td></tr>");

        out.println("<tr><td>" + request.getParameter("courseNo_2") + "</td>");
        out.println("<td>" + request.getParameter("courseName_2") + "</td>");
        out.println("<td>" + request.getParameter("supervisorSignature_2") + "</td>");
        out.println("<td>" + request.getParameter("creditHrs_2") + "</td>");
        out.println("<td>" + request.getParameter("days_2") + "</td>");
        out.println("<td>" + request.getParameter("time_2") +" "+ request.getParameter("ampm_2") + "</td></tr>");

        out.println("<tr><td>" + request.getParameter("courseNo_3") + "</td>");
        out.println("<td>" + request.getParameter("courseName_3") + "</td>");
        out.println("<td>" + request.getParameter("supervisorSignature_3") + "</td>");
        out.println("<td>" + request.getParameter("creditHrs_3") + "</td>");
        out.println("<td>" + request.getParameter("days_3") + "</td>");
        out.println("<td>" + request.getParameter("time_3") +" "+ request.getParameter("ampm_3") + "</td></tr>");
        out.println("</table>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td><b>Employee's Signature: </b>" + request.getParameter("empSignature") + "</td>");
        out.println("<td><b>Date: </b>" + request.getParameter("employeeSignDate") + "</td>");
        out.println("<td><b>HRM Approval: </b>" + request.getParameter("HRMsignature") + "</td>");
        out.println("<td><b>Date: </b>" + request.getParameter("HRMSignDate") + "</td>");
        out.println("</tr>");
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
