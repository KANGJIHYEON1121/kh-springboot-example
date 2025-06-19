<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>





<%-- 화면영역 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
    </head>
    <body>
    <hr>
    <header>User의 result.jsp 입니다.</header>
    <main>
      <h3>Spring Form Result</h3>
      <table border="1">
        <tr>
          <td>유저ID</td>
          <td>${user.userId}</td>
        </tr>
        <tr>
          <td>이름</td>
          <td>${user.userName}</td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td>${user.userPassword}</td>
        </tr>
        <tr>
          <td>소개</td>
          <td>${user.introduction}</td>
        </tr>
        <tr>
            <td>취미</td>
            <td>
                <c:forEach var="hobby" items="${user.checkBoxList}">
                <c:out value="${hobby}" /><br>
                </c:forEach>
            </td>
          </tr>
      </table>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>