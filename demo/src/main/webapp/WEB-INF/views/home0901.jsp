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
    <h1>home0901 페이지 입니다.</h1>
    <main>
        <c:import url = "/boardjstl/search" >
            <c:param name = "title" value = "orange" />
        </c:import>
        <a href = "http://Localhost:8080/boardjstl/search?title=orange">boardjstl/search?title=orange</a>
        <br> <br>
        <form action="/boardjstl/search" method = "get">
            <input type="text" name = "title" value = "orange">
            <input type="submit" value = "전송">
        </form>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>