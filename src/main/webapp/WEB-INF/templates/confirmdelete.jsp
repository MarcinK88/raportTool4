<jsp:include page="menu.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport tool</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

</head>
<body>
Are you sure to delete user ${username}?

<a href="/admin/editusers"><button class="btn btn-danger">NO</button> </a><a href="/admin/deleteuser/${username}"><button class="btn btn-success">YES</button> </a>
</body>
</html>
