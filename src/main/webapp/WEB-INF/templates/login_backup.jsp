<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="user">

<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 col-xs-12">
            <div class="jumbotron">
                <h1 class="text-center">Login Page</h1>
                <br>
                <div class="form-group">
                    <form:label path="login" cssClass="control-table">Login</form:label>
                    <form:input path="login" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <form:label path="password" cssClass="control-table">Password</form:label>
                    <form:input path="password" cssClass="form-control" type="password" />
                </div>
                <br>
                <div class="pull-right">
                    <button type="submit" class="btn btn-outline-info">Login</button>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
    </form:form>



</body>
</html>
