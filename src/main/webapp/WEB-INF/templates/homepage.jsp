<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="menu.jsp"/>
<html>
<head>
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<ul class="tkFont">
    <li><a href="/tickets">Tickets</a></li>
    <li><a href="/selectmonth">Monthly report</a></li>
    <li><a href="/ba">BA report</a> </li>
    <li><a href="/importlist">Import file</a></li>
<sec:authorize access="hasRole('ADMIN')"><li><a href="/admin/editusers">Manage users</a></li></sec:authorize>
<%--    <li><a href="/testpage">test page</a></li>--%>
</ul>
</body>
</html>
