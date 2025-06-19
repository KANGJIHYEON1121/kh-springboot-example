<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- 화면영역 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
    </head>
    <body>
    <hr>
    <main>
    <header>search.jsp 입니다.</header>
    <table border = "1"> 
        <tr>
            <td>\${board.title}</td>
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

