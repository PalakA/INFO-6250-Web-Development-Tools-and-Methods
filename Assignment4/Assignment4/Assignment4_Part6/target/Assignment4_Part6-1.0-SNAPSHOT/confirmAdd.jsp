<%-- 
    Document   : confirmAdd
    Created on : Oct 21, 2021, 11:42:19 PM
    Author     : palak
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Confirmation</title>
        <style type='text/css'>
            body {
                font: 18px sans-serif;
                margin: 10px;
                padding: 10px;
            }
            h1 {
                color: green;
            }
            /* CSS */
            .button-2 {
                background-color: rgba(51, 51, 51, 0.05);
                border-radius: 8px;
                border-width: 0;
                color: #333333;
                cursor: pointer;
                display: inline-block;
                font-family: "Haas Grot Text R Web", "Helvetica Neue", Helvetica, Arial, sans-serif;
                font-size: 14px;
                font-weight: 500;
                line-height: 20px;
                list-style: none;
                margin: 0;
                padding: 10px 12px;
                text-align: center;
                transition: all 200ms;
                vertical-align: baseline;
                white-space: nowrap;
                user-select: none;
                -webkit-user-select: none;
                touch-action: manipulation;
            }

            .button-2:hover {
                background-color: C1BDBD;
            }

            .button-2:focus {
                border-color: #C1BDBD;
                box-shadow: rgba(213, 217, 217, .5) 0 2px 5px 0;
                outline: 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="./index.jsp"/>
        <h1> The following item has been added to your shopping cart!</h1>
        <hr>
        <br>
        <ul>
            <c:forEach items="${requestScope.item}" var="item">
                <li><c:out value="${item}"/></li>
                </c:forEach>
        </ul>
        <br/>
        <br/>
        <br/>
        <button onclick="location.href = 'http://localhost:8080/Assignment3_Part8/product?param=Cart'" class="button-2" type="button"> View Cart </button>
        <button onclick="location.href = 'http://localhost:8080/Assignment3_Part8/product?param=Book'" class="button-2" type="button"> Books Store </button>
        <button onclick="location.href = 'http://localhost:8080/Assignment3_Part8/product?param=Music'" class="button-2" type="button"> Music Store </button>
        <button onclick="location.href = 'http://localhost:8080/Assignment3_Part8/product?param=Computer'" class="button-2" type="button"> Computers Store </button>
    </body>
</html>
