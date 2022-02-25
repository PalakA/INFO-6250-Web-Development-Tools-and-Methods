<%-- 
    Document   : cart
    Created on : Oct 21, 2021, 11:41:28 PM
    Author     : palak
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cart</title>
        <style type='text/css'>
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
            table {
                border-spacing: 15px;
                padding: 10px;
            }
        </style>
    </style>
</head>
<body>
    <jsp:include page="./index.jsp"/>
    <form action="cart" method="post">
        <input type="hidden" name="action" value="remove"/>
        <hr><br/>
        <h1>Shopping Cart</h1>
        <table>
            <tr>
                <th>S.No.</th>
                <th>Item</th>
                <th>Remove Item</th>
            </tr>
            <c:forEach items="${sessionScope.list }" var="item" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item}</td>
                    <td><button class="button-2" type="submit" name="element" value="${item}"> Remove</button></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
