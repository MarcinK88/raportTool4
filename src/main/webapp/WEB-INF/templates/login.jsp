<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <title>Title</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
<%--            <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />--%>
            Login page
        </div>

        <form:form method="post" modelAttribute="user">
            <form:input path="login" id="login" cssClass="fadeIn second" placeholder="login" />
            <form:password path="password" id="password" cssClass="fadeIn third" placeholder="password"  />
            <input type="submit" class="fadeIn fourth" value="Login"/>
        </form:form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>

    </div>
</div>


</body>
</html>
