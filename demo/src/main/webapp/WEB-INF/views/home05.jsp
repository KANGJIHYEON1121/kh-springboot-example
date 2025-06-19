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
        <h2>home04 page</h2>
        <h1>MEMBERMAP 저장된 값 출력</h1>
            <p>id = ${memberMap["id"]}</p>
            <p>pwd = ${memberMap["pwd"]}</p>
            <p>email = ${memberMap["email"]}</p>
            <p>name = ${memberMap["name"]}</p>
            <p>date = ${memberMap["date"]}</p>

    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>