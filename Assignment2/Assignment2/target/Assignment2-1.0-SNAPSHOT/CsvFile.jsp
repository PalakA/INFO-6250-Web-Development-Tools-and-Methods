<%-- 
    Document   : CsvFile
    Created on : Oct 7, 2021, 1:26:19 PM
    Author     : palak
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>CSV File Viewer</title>
    </head>
    <body style="text-align: center">
        <form action="XlsDriver.csv" method="get">
            <h1 style="text-align:center;"><u>CSV File Viewer</u></h1>
            <br>
            <table style="text-align:center;">
                <tr>
                    <td>Enter CSV file name:</td>
                    <td><input type="text" placeholder="File Name" title="Enter File Name" name="inputFile"></td>
                    <td>(*DO NOT give .csv in the input)</td>
                </tr>
                <tr></tr>
                <tr></tr>
                <tr>
                    <td><input type="submit" value="Upload File" title="Submit Button" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
