<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
    </head>
    <body>       
        <h1>home.jsp 입니다.</h1>
        <h1>환영합니다!</h1>
        <P>서버의 시간은 ${serverTime} 입니다.</P>
        <a href="board/list">회원 게시판</a> 
        <br>
        <a href="notice/list">공지사항</a>
    </body>
</html>