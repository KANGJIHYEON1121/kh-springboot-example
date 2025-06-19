<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="spring"
uri="http://www.springframework.org/tags"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ taglib prefix="f"
uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%-- 화면영역 --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="linkToCSS" />
  </head>
  <body>
    <hr />
    <header>User의 registerSpringFormErrors.jsp 입니다.</header>
    <main>
      <form:form modelAttribute="user" method="post" action="register">
        <table>
          <tr>
            <td>유저ID</td>
            <td>
              <form:input path="userId" /><font color="red"
                ><form:errors path="userId"
              /></font>
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td>
              <form:input path="userName" /><font color="red"
                ><form:errors path="userName"
              /></font>
            </td>
          </tr>
          <tr>
            <td>E-MAIL</td>
            <td>
              <form:input path="email" /><font color="red"
                ><form:errors path="email"
              /></font>
            </td>
          </tr>
        </table>
        <form:button name="register">등록</form:button>
      </form:form>
    </main>
    <hr />
  </body>
  <footer>
    <h2>footer 입니다.</h2>
  </footer>
</html>
