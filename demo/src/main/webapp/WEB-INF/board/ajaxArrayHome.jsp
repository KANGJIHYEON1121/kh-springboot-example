<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%-- 화면영역 --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="linkToCSS" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
        $("#putBtn").on("click", function () {
            var userObjectArray = [
                {userId:"name01", password:"pw01"},
                {userId:"name02", password:"pw02"} ];

            $.ajax({
                type: "post",
                url: "/board/registerArray",
                data: JSON.stringify(userObjectArray),
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    console.log("result: " + result);
                    if (result === "SUCCESS") {
                        alert("SUCCESS");
                    }
                }
            });
        });
    });
    </script>
  </head>
  <body>
    <hr />
    <header>AjaxArray.jsp 입니다.</header>
    <main>
      <h1>AjaxArray Home</h1>
      <div>
        <button id="putBtn">수정(put)</button>
      </div>
    </main>
    <hr />
  </body>
  <footer>
    <h2>footer 입니다.</h2>
  </footer>
</html>