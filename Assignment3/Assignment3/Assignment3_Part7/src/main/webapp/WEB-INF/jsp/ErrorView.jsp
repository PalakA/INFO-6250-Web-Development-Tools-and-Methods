<%-- 
    Document   : ErrorView
    Created on : Oct 21, 2021, 7:55:48 PM
    Author     : palak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Library</title>
    </head>
    <body>
        <h1>Error Adding Books</h1>
        
        <c:out value='${requestScope.errorMessage}'/>
        <br>
        <br>
        <a href="././index.html">Click here to go back  to the main page</a>
    </body>
</html>
