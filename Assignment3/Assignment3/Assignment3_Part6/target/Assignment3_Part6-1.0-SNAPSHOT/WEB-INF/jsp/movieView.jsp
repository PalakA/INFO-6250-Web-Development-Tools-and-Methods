<%-- 
    Document   : movieViewjsp
    Created on : Oct 20, 2021, 12:45:57 AM
    Author     : palak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/style.css">
        <title>Movie View Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 15px;
            }
        </style>
    </head>
    <body>
        <h1>Movies in Library </h1>
        <br>
        <c:out value='You searched for "${requestScope.keyword}"'/>

        <br>
        <br>
        <table>
            <th>S.No.</th>
            <th>Movie Title</th>
            <th>Lead Actor</th>
            <th>Lead Actress</th>
            <th>Genre</th>
            <th>Year of Release</th>

            <c:forEach var="c"  items="${requestScope.list}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${c.title}</td>
                    <td>${c.actor}</td>
                    <td>${c.actress}</td>
                    <td>${c.genre}</td>
                    <td>${c.year}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="././index.html">Click here to go back  to the main page</a>
    </body>
</html>
