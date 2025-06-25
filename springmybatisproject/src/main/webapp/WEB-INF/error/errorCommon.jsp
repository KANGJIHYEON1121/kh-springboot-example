<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
  <div>
    <h2>고객님 서버 문제가 발생하였습니다. 빠게 조치하도록 하겠습니다.</h2>
    <h2>${message}</h2>
    <a href="/board/list">List</a>
  </div>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>
