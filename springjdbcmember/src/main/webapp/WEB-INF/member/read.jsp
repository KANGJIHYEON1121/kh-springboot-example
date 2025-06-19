<%-- 헤더 영역 --%>
<%@ include file="./header.jsp" %>

<!-- 화면영역 -->
<main>
    <h2>READ</h2>
    <form:form modelAttribute="member">
        <form:hidden path="no" />
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" readonly="true" /></td>
            </tr>
            <tr>
                <td>PWD</td>
                <td><form:input path="pwd" readonly="true" /></td>
            </tr>
            <tr>
                <td>NAME</td>
                <td><form:textarea path="name" readonly="true" /></td>
            </tr>
        </table>
    </form:form>
    <div>
        <button type="submit" id="btnModify">Modify</button>
        <button type="submit" id="btnRemove">Remove</button>
    </div>
</main>

<%-- 푸터 영역 --%>
<%@ include file="./footer.jsp" %>

<script>
    $(document).ready(function() { var formObj = $("#member"); console.log(formObj);
        $("#btnModify").on("click", function() {
            var no = $("#no");
            var noVal = no.val();
            self.location = "/member/modify?no=" + noVal;
        });
        $("#btnRemove").on("click", function() { 
            formObj.attr("action", "/member/remove"); 
            formObj.submit();
        });
        $("#btnList").on("click", function() { 
            self.location = "/member/list";
        });
    });
</script>