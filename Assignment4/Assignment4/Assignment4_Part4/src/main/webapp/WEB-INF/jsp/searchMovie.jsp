<%-- 
    Document   : searchMovie
    Created on : Nov 1, 2021, 10:29:20 PM
    Author     : palak
--%>

<html>
    <head>
        <title>Search Movies</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="movie.htm" method="get">
            <h1>Searching Movies</h1>
            <input type="hidden" name="action" value="search"/>
            <table>
                <tr>
                    <td>Keyword:</td>
                    <td><input type="text" name="keyword"/></td>
                </tr>
                <tr>
                    <td><input type="radio" id="title" name="radio" value="title"> Search by Title</td>
                </tr>
                <tr>
                    <td><input type="radio" id="actor" name="radio" value="actor"> Search by Actor</td>
                </tr>
                <tr>
                    <td><input type="radio" id="actress" name="radio" value="actress"> Search by Actress</td>
                </tr>
                <tr>
                    <td><input type="radio" id="actress" name="radio" value="genre"> Search by Genre</td>
                </tr>
            </table>
            <br>
            <button type="submit">Search Movies</button>
        </form>
        <br>
        <a href="./index.htm">Click here to go back  to the main page</a>
    </body>
</html>
