<%-- 
    Document   : BookView
    Created on : Oct 21, 2021, 9:33:19 AM
    Author     : palak
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Library</title>
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
        <h1>Enter Book details to add to library</h1>
        <br>
        <c:choose>
            <c:when test="${requestScope['action']=='result'}">
                <h1>${num} books added successfully!</h1>
            </c:when>
            <c:otherwise>
                <form action="action.htm" method="post">
                    <table border="1">
                        <tr>
                            <th>ISBN</th>
                            <th>Title</th>
                            <th>Authors</th>
                            <th>Price</th>
                        </tr>
                        <c:forEach begin="1" end="${ num }" step="1" varStatus="loopCounter">
                            <input type="hidden" name="action" value="submitBooks"/>
                            <input type="hidden" name="num" value="${num}"/>
                            <tr>
                                <td>
                                    <input name="isbn${loopCounter.index}"/>
                                </td>
                                <td>
                                    <input name="title${loopCounter.index}"/>
                                </td>
                                <td>
                                    <input name="authors${loopCounter.index}"/>
                                </td>
                                <td>
                                    <input name="price${loopCounter.index}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                    <button type="submit" value="submit">Add Books</button>
                </form>
            </c:otherwise>
        </c:choose>
        <br/>
        <a href="./index.htm">Home</a>
    </body>
</html>
