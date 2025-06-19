<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url values='/css/member/header.css' />"

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판영역</title>
<link rel="stylesheet" type="text/css" href="<c:url values='/css/member/modify.css' />"
<script type="text/javascript" src="<c:url values='/css/member/modify.js' />"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<header>
		<h1>Member`s 게시판</h1>
	</header>

<main>
	<h2>MODIFY</h2>
	<form:form modelAttribute="member" action="modify">
		<form:hidden path="memberNo" />
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memberID" /></td>
				<td><font color="red"><form:errors path="memberID" /></font></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="memberPW" /></td>
				<td><font color="red"><form:errors path="memberPW" /></font></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><form:textarea path="memberName" /></td>
				<td><font color="red"><form:errors path="memberName" /></font></td>
			</tr>
		</table>
	</form:form>

	<div>
		<button type="submit" id="btnModify">Modify</button>
		<button type="submit" id="btnList">List</button>
	</div>

</main>


<%@ include file="./footer.jsp"%>
