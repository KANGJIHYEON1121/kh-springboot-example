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
        <h4>redirect</h4>
        <c:redirect url="http://localhost:8080/boardjstl/list" />
        <h4>redirect 이후의 코드는 실행되지 않는다.</h4>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>
