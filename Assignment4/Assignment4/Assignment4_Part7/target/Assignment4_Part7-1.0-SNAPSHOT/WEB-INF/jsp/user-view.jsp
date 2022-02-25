<%-- 
    Document   : user-view
    Created on : Oct 27, 2021, 6:16:58 PM
    Author     : ysf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User View Page</title>
    </head>
    <body>
        <h1>Registration Completed</h1>
        User Name: ${requestScope.user.email}
        <br/>
        About Me: ${requestScope.user.aboutme}
        <br/>
        Date: ${requestScope.user.startdate}
        <br/>
        Gender: ${requestScope.user.gender}
        <br/>
        User Info: ${requestScope.info}
        <br/>
        Scope from Context: ${requestScope.userLookupService}
    </body>
</html>
