<jsp:include page="menu.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport tool</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<form:form method="post" modelAttribute="tableWriter" cssClass="tkFont">

    Select BA: <form:select path="selectedBa"><form:options items="${tableWriter.ba}"/></form:select> <br>
    Select Year: <form:select path="selectedYear"><form:options items="${tableWriter.years}"/></form:select> <br>
    Select Month: <form:select path="selectedMonth"><form:options items="${tableWriter.months}"/></form:select><br>
    <input type="submit" value="generate" class="btn btn-success">


</form:form>


</body>
</html>
