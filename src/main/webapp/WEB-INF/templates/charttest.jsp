<jsp:include page="menu.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="tableWriter">

    Select Year: <form:select path="selectedYear"><form:options items="${tableWriter.years}"/></form:select> <br>
    Select Month: <form:select path="selectedMonth"><form:options items="${tableWriter.months}"/></form:select><br>
    <input type="submit" value="generate">


</form:form>
</body>
</html>
