<%-- 
    Document   : computer
    Created on : Oct 21, 2021, 11:41:53 PM
    Author     : palak
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shop for Laptops</title>
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

            .checkboxes input{
                margin: 0px 0px 0px 0px;
            }

            .checkboxes label{
                margin: 0px 20px 0px 3px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="/./index.html"/>
        <hr><br>
        <h1>Shop for Laptops</h1>
        <form action="cart" method="post">
            <a href="http://localhost:8080/Assignment3_Part8/product?param=Cart">View Cart</a><br/><br/>
            <input type="hidden" value="add" name="action">
            <div id="computer">
                <c:forEach items="${requestScope.list}" var="item" varStatus="loopCounter">
                    <input type="checkbox" name="chkItem" id="computer${loopCounter.index}" value="${item.title}">
                    <label for="computer${loopCounter.index}"> ${item.title} [${item.price}]</label>
                    <br>
                </c:forEach>
            </div>
            <br/><br/>
            <button type="submit" class="button-2" onclick=" return confirm_update()">Add to Cart</button>
        </form>

        <script>
            function confirm_update() {
                var cont = document.getElementById('computer').children;
                var count = 0;
                for (var i = 0; i < cont.length; i++) {
                    // Check if the element is a checkbox.
                    if (cont[i].tagName == 'INPUT' && cont[i].type == 'checkbox') {
                        // Finally, check if the checkbox is checked.
                        if (cont[i].checked) {
                            count++;
                        }
                    }
                }
                if (count == 0)
                {
                    alert('No Item selected to add to Cart');
                    return false;
                }
            }
        </script>
    </body>
</html>