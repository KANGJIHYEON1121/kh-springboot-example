<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
    </head>
    <body>
        <h1>home01 page</h1>
        <h1>${serverTime}</h1>
        <p>boardNo  ${board.boardNo}</p>
        <p>title  ${board.title}</p>
        <p>content  ${board.content}</p>
        <p>writer  ${board.writer}</p>
        <p>regDate  ${board.regDate}</p>
    </body>
</html>