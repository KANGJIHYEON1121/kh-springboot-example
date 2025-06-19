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
    <header>User의 radiobuttons01.jsp 입니다.</header>
    <main>
        <form:form modelAttribute="user" method="post" action="/user/register">
  <table>
    <tr>
      <td>성별</td>
      <td><form:radiobuttons path="gender" items= "${genderCodeMap}"/></td>
    </tr>
    <tr>
      <td>성별</td>
        <form:select path="nationality" items="${nationalityCodeMap}" />
    </tr>
  </table>


  <form:button name="register">등록</form:button>
  </form:form>

    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>
</html>