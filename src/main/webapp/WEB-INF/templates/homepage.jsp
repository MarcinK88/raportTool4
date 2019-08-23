<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"/>
<html>
<head>
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="row my-2">
<div class="list-group col-md-1 py-1">


    <a href="/tickets" class="list-group-item list-group-item-action">Tickets</a>
    <a href="/selectmonth" class="list-group-item list-group-item-action">Monthly report</a>
    <a href="/ba" class="list-group-item list-group-item-action">BA report</a>
    <a href="/importlist" class="list-group-item list-group-item-action">Import file</a>
<sec:authorize access="hasRole('ADMIN')"><li><a href="/admin/editusers" class="list-group-item list-group-item-action">Manage users</a></li></sec:authorize>


</div>
</div>
</body>
</html>
