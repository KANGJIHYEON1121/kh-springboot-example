<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
    <table border = "1"> 
        <tr>
            <td>\${empty board}</td>
            <td>${empty board}</td>
        </tr>
        <tr>
            <td>\${empty board.title}</td>
            <td>${empty board.title}</td>
        </tr>
    </table>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>