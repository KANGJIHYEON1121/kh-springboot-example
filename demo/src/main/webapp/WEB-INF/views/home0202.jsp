<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- 화면영역 --%>
<!DOCTYPE html>
<html>
    <body>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
    </head>
    <hr>
    <main>
        <%-- <c:set var = "myTitle" value = "${board.title}" /> --%>
        <c:set var = "myTitle"> ${board.title} </c:set>
        <table border = "1"> 
            <tr>
                <td>\${board title}</td>
                <td>${myTitle}</td>
            </tr>
        
        <c:set target = "${board}" property = "title" value = "react" />
        <table border = "1"> 
            <tr>
                <td>\${board title}</td>
                <td>${board.title}</td>
            </tr>
        </table>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>