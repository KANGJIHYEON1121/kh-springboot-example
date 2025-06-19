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
    <header>User의 registerForm.jsp 입니다.</header>
    <main>
        <!-- modelAttribute 속성에 폼 객체의 속성명을 지정한다.-->
        <form:form modelAttribute="user" method="post" action="/user/register">
         <table>
           <tr>
             <td>유저ID</td>
             <td>
               <form:input path="userId" />
               <font color="red"><form:errors path="userId" /></font>
             </td>
           </tr>
           <tr>
             <td>이름</td>
             <td>
               <form:input path="userName" />
               <font color="red"><form:errors path="userName" /></font>
             </td>
           </tr>
           <tr>
             <td>비밀번호</td>
             <td>
               <form:password path="userPassword" />
               <font color="red"><form:errors path="userPassword" /></font>
             </td>
           </tr>
           <tr>
            <td>소개</td>
                <td>
                <form:textarea path="introduction" rows="6" cols="30" />
                </td>
                <tr>
            </tr>
            <tr>
            <td>취미(hobbyList) : </td>
            <td>
            <form:checkboxes path="checkBoxList" items="${hobbyBoxList}"
            itemValue="value" itemLabel="label" />
            </td>
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