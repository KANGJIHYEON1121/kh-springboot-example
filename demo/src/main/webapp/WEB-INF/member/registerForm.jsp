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
    <header>registerForm.jsp 입니다.</header>
    <main>
    <form action="/member/register" method="post">
        userId: <input type="text" name="userId" value="hong"><br> 
        password: <input type="text" name="password" value="1234"><br>
        dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
        <input type="submit" value="register">
    </form>
    <hr>
    <form action="/member/registerSelect" method="post">
        nationality:<select name="nationality" multiple>
        <option value="Korea" selected>대한민국</option>
        <option value="Germany">독일</option>
        <option value="Australia">호주</option>
        <option value="Canada">캐나다</option>
    </select><br>
<input type="submit" value="registerSelect">
</form>
<hr>
    <form action="/member/registerBoard" method="post">
        userId: <input type="text" name="userId" value="hong"><br> 
        password: <input type="text" name="password" value="1234"><br>
        dateOfBirth: <input type="text" name="dateOfBirth" value="20001020"><br>
        boardNo: <input type="text" name="board.boardNo" value="200"><br>
        <input type="submit" value="register">
    </form>
    <form action="/member/registerFileupload" method="post" enctype = "multipart/form-data">
        userId: <input type="text" name="userId" value="hong"><br> 
        password: <input type="text" name="password" value="1234"><br>
        file: <input type="file"  name = "picture1">
        file: <input type="file"  name = "picture2">
        <%-- file: <input type="file" multiple = "multiple" name = "picture"> --%>
        <input type="submit" value="register">
    </form>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>