<jsp:include page="menu.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
logged user: ${sessionScope.get("loggedUser")}
<ul>
    <li><a href="/converted">All tickets</a></li>
    <li><a href="/opentickets">Open tickets</a></li>
    <li><a href="/noregion">Tickets with no Region</a></li>
    <li><a href="/noba">Tickets with no BA</a></li>
    <li><a href="/norequester">Tickets with no Requester</a></li>
    <li><a href="/nocomments">Tickets with no Comments</a></li>
    <li><a href="/alltickets">all non converted tickets - test</a></li>
</ul>
</body>
</html>
