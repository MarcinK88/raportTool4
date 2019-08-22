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
<form:form method="post" modelAttribute="tableWriter" cssClass="form-horizontal tkFont">

    <div class="form-group">
        <label class="col-md-1 control-label" for="ba">Select BA:</label>
        <div class="col-md-1">
                <form:select id="ba" path="selectedBa" class="form-control" items="${tableWriter.ba}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-1 control-label" for="year">Select Year:</label>
        <div class="col-md-1">
                <form:select id="year" path="selectedYear" class="form-control" items="${tableWriter.years}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-1 control-label" for="month">Select Month:</label>
        <div class="col-md-1">
                <form:select id="month" path="selectedMonth" class="form-control" items="${tableWriter.months}"/>
        </div>
    </div>

    <input type="submit" value="generate" class="btn btn-success">

</form:form>


</body>
</html>
