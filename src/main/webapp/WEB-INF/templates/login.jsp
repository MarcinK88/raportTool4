<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <title>Raport tool</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="wrapper fadeInDown tkFont">
    <div id="formContent">
        <div class="fadeIn first">
            Login page
        </div>

        <form method="post" action="/login">
            <input type="text" name="username" id="username" cssClass="fadeIn second" placeholder="username"/>
            <input type="password" name="password" id="password" cssClass="fadeIn third" placeholder="password"/>
            <input type="submit" class="fadeIn fourth" value="Login"/>
        </form>

        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>

    </div>
</div>
<jsp:include page="footer_abs.jsp"/>
</body>
</html>
