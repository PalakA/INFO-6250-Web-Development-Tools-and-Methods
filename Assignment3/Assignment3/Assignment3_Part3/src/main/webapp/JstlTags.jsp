<%-- 
    Document   : JstlTags
    Created on : Oct 20, 2021, 10:52:10 PM
    Author     : palak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Tag View Page</title>
    </head>
    <body>
        <h1>JSTL Tag View</h1>
        <br>
        <b><c:out value="${'JSTL Core Tags'}"/></b>
        <ul>
            <c:set var="Income" scope="session" value="${4000*4}"/>  
            <li><b>c:set tag</b> - <c:out value="${Income}"/></li>
                <c:remove var="Income"/>
            <li><b>c:remove tag</b> - <c:out value="${Income}"/>  </li>
            <li><b>c:url tag</b> - <c:url value="/JstlTags.jsp"/> </li>

            <c:url value="/JstlTags.jsp" var="completeURL"> 
                <c:param name="trackingId" value="786"/>
                <c:param name="user" value="Palak"/>
            </c:url>
            <li><b>c:param</b> - ${completeURL}</li>
        </ul>
        <br>
        <b><c:out value="${'JSTL Formatting Tags'}"/></b>
        <ul>
            <c:set var="Amount" value="786.970" />  

            <fmt:parseNumber var="j" type="number" value="${Amount}" />  
            <li><b>fmt:parseNumber </b> - <c:out value="${j}" /> </li>

            <fmt:parseNumber var="j" integerOnly="true" type="number" value="${Amount}" />  
            <li><b>fmt:parseNumber </b> - <c:out value="${j}" /> </li>

            <c:set var="date" value="12-08-2016" />  
            <fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />  
            <li><b>fmt:parseDate </b> - <c:out value="${parsedDate}" /></li>

            <c:set var="date" value="<%=new java.util.Date()%>" />  
            <li><b>fmt:formatDate </b> - <fmt:formatDate value="${date}"  
                            type="both" timeStyle="long" dateStyle="long" /></li>
        </ul>
        <br>
        <b><c:out value="${'JSTL Function Tags'}"/></b>
        <ul>
            <c:set var="msg" value="The Example of JSTL fn:startsWith() Function"/>
            <li><b>fn:startsWith </b> - The string starts with "Example": ${fn:startsWith(msg, 'Example')}</li>

            <c:set var="string" value="This is the first string."/>
            <li><b>fn:substring </b> - ${fn:substring(string, 5, 17)} </li>

            <c:set var="str1" value="This is first string"/>
            <li><b>fn:length </b> - Length of the String is: ${fn:length(str1)}</li>

            <c:set var="string" value="Welcome to JSP Programming"/>
            <li><b>fn:toLowerCase </b> - ${fn:toLowerCase("HELLO,")} ${fn:toLowerCase(string)}</li>
        </ul>
        <br>
        <b><c:out value="${'JSTL XML Tags'}"/></b>
        <ul>
            <c:set var="book">  
                <books>
                    <book>  
                        <name>Tomorrow land</name>  
                        <author>Brad Bird</author>  
                        <price>2000</price>  
                    </book>  
                </books>  
            </c:set>

            <x:parse xml="${book}" var="output"/>
            <x:set var="fragment" select="$output/books/book[1]/price"/>
            <li><b>x:parse </b> - <x:out select="$fragment" /></li>
            <li><b>x:set</b> - <x:out select="$fragment" /></li>
            <li><b>x:out</b> - <x:out select="$fragment" /> </li>
        </ul>
        <br>
        <b><c:out value="${'JSTL SQL Tags'}"/></b>
        <ul>
            <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/moviedb" 
                               user="root"  password="mysql"/>
            <li><b> sql:setDataSource</b> - Database Connection Established</li>

            <sql:query dataSource="${db}" var="rs">  
                SELECT * from movies;  
            </sql:query>

            <li><b>sql:query </b></li>
            <br>
            <table border="2" width="100%">  
                <tr>  
                    <th>Movie Title</th>  
                    <th>Actor</th>  
                    <th>Actress</th>  
                    <th>Genre</th>
                    <th>Year of Release</th>
                </tr>  
                <c:forEach var="table" items="${rs.rows}">  
                    <tr>  
                        <td><c:out value="${table.title}"/></td>  
                        <td><c:out value="${table.actor}"/></td>  
                        <td><c:out value="${table.actress}"/></td>  
                        <td><c:out value="${table.genre}"/></td> 
                        <td><c:out value="${table.year}"/></td>
                    </tr>  
                </c:forEach> 
            </table>

            <sql:transaction dataSource="${db}">
                <sql:update var="count">  
                    UPDATE movies SET year = '2019' WHERE actor = "George Clooney";
                </sql:update>  
            </sql:transaction>
            <br>
            <li><b>sql:transaction</b></li>
            <br>
            <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/moviedb" 
                               user="root"  password="mysql"/>
            <sql:query dataSource="${db}" var="rs">  
                SELECT * from movies;  
            </sql:query>
            <table border="2" width="100%">  
                <tr>  
                    <th>Movie Title</th>  
                    <th>Actor</th>  
                    <th>Actress</th>  
                    <th>Genre</th>
                    <th>Year of Release</th>
                </tr>  
                <c:forEach var="table" items="${rs.rows}">  
                    <tr>  
                        <td><c:out value="${table.title}"/></td>  
                        <td><c:out value="${table.actor}"/></td>  
                        <td><c:out value="${table.actress}"/></td>  
                        <td><c:out value="${table.genre}"/></td> 
                        <td><c:out value="${table.year}"/></td>
                    </tr>  
                </c:forEach>  
            </table>
        </ul>
    </body>
</html>
