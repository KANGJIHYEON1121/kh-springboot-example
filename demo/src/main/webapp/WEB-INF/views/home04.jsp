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
        <h1>NAME 문자열 배열 출력</h1>
            <c:forEach var = "data" items = "${name}">
                <h2> <c:out value = "${data}"/> </h2>

                
            </c:forEach>

            <h1>NAME 문자열 배열 출력 첨자형식으로 출력</h1>
                <p> ${name[0]} </p>
                <p> ${name[1]} </p>
                <p> ${name[2]} </p>

        <h1>NAME LIST 문자열 배열 출력</h1>
            <c:forEach var = "data" items = "${nameList}">
                <h2> <c:out value = "${data}"/> </h2>
            </c:forEach>
        
        <h1>NAME LIST 문자열 배열 출력</h1>
            <p> ${nameList[0]} </p>
            <p> ${nameList[1]} </p>
            <p> ${nameList[2]} </p>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>