<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>

    <title>Title</title>
</head>
<body>

<form:form cssClass="border border-light p-5" method="post" modelAttribute="user"  >
    <p class="h4 mb-4 text-center">Sign in</p>
    <form:hidden path="id" />
    login: <form:input cssClass="form-control mb-4" path="login" />
    password: <form:input cssClass="form-control mb-4" path="password" type="password" />
    <button type="submit" value="login" class="btn btn-info btn-block my-4">Login</button>

</form:form>

</body>
</html>
