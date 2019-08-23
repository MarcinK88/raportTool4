<jsp:include page="menu.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport tool</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="divposition">
    <div class="tkFont">Are you sure to delete user ${username}?</div>

    <a href="/admin/editusers">
        <button class="btn btn-danger">NO</button>
    </a><a href="/admin/deleteuser/${username}">
    <button class="btn btn-success">YES</button>
</a>
</div>
<jsp:include page="footer_rel.jsp"/>
</body>
</html>
