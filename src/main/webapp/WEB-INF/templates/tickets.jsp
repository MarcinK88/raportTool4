<jsp:include page="menu.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="divposition">
    <div class="row my-2">
        <div class="list-group col-md-1 py-1">
            <a href="/alltickets" class="list-group-item list-group-item-action">All tickets</a>
            <a href="/opentickets" class="list-group-item list-group-item-action">Opened tickets</a>
            <a href="/noregion" class="list-group-item list-group-item-action">Tickets with no Region</a>
            <a href="/noba" class="list-group-item list-group-item-action">Tickets with no BA</a>
            <a href="/norequester" class="list-group-item list-group-item-action">Tickets with no Requester</a>
            <a href="/nocomments" class="list-group-item list-group-item-action">Tickets with no Comments</a>
        </div>
    </div>
</div>
<jsp:include page="footer_abs.jsp"/>
</body>
</html>
