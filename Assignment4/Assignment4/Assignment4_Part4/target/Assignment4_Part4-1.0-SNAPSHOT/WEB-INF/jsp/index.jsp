<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Movie Store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Welcome to our Movie Store</h1>
        <p> Please make your selection below:</p>
        <form action="movie.htm" method="post">
            <input type="hidden" name="action" value="select"/>
            <select name="selection">
                <option value="browse">Browse Movie</option>
                <option value="add">Add New Movies to Database</option>
            </select>
            <button type="submit" value="submit">Send</button>
        </form>
    </body>
</html>
