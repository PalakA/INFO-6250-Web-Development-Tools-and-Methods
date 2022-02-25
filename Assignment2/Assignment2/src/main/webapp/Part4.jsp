<%-- 
    Document   : Part4
    Created on : Oct 7, 2021, 1:28:23 PM
    Author     : palak
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<html>
    <head>
        <title>CsvDriver</title>
    </head>
    <body style="border: solid black 1px dashed black; margin: 5px;background: black">
        <table>
            <thead style="background: lightgrey">
                <c:forEach var="tblHeader" items='${tblHead}'>
                <th>${tblHeader}</th>
                </c:forEach>
        </thead>
        <c:forEach var="tableRow" items='${list}'>
            <tr style="border: solid black 1px dashed black; background: lightsalmon">
                <c:forEach var="tableCol" items="${tableRow}">
                    <td style="border: solid black 1px dashed black;"> ${tableCol}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

</body>
</html>