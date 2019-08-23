<jsp:include page="menu.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<ul class="tkFont">
    <li><a href="/alltickets">All tickets</a></li>
    <li><a href="/opentickets">Opened tickets</a></li>
    <li><a href="/noregion">Tickets with no Region</a></li>
    <li><a href="/noba">Tickets with no BA</a></li>
    <li><a href="/norequester">Tickets with no Requester</a></li>
    <li><a href="/nocomments">Tickets with no Comments</a></li>
</ul>
<jsp:include page="footer_abs.jsp"/>
</body>
</html>
