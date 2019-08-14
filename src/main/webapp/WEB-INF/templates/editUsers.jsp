<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="menu.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,500" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

    <title>Raport tool</title>
</head>
<body>
<table class="table responsive table-hover dataTable tkFont">
    <thead>
    <th scope="col">username</th>
    <th scope="col">enabled</th>
    <th scope="col">role</th>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.enabled}</td>
            <td>${user.userRoles.role}</td>
            <td><a href="/admin/editusers/${user.username}">EDIT</a></td>
<%--            <td><a href="/admin/confirmdelete/${user.username}">DELETE</a></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="tkFont"><a href="/newuser">add new user</a></div>
</body>
</html>
