<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"/>
<html>
<head>
    <title>Raport tool</title>
</head>
<body>

<ul>
    <li><a href="/tickets">Tickets</a></li>
    <li><a href="/selectmonth">Monthly report</a></li>
    <li><a href="/importlist">Import file</a></li>
<sec:authorize access="hasRole('ADMIN')"><li><a href="/admin/editusers">Manage users</a></li></sec:authorize>
</ul>
</body>
</html>
