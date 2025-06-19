<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- 화면영역 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="linkToCSS" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
    <hr>
    <header>registerAjaxFileUpForm.jsp 입니다.</header>
    <main>
        <div>
            <input type="file" id="inputFile">
        </div>
    </main>
    <hr>
    </body>
    <footer>
        <h2>footer 입니다.</h2>
    </footer>

    <script type="text/javascript">
            $(document).ready(function () {
                $("#inputFile").on("change", function (event) {
                console.log("change");
                var files = event.target.files;
                var file = files[0];
                console.log(file);
                var formData = new FormData();
                formData.append("file", file);
                $.ajax({
                    type: "post",
                    url: "/member/uploadAjax",
                    data: formData,
                    dataType: "text",
                    processData: false,
                    contentType: false,
                    success: function (data) {
                    alert(data);
                    },
                });
                });
            });
    </script>
</html>