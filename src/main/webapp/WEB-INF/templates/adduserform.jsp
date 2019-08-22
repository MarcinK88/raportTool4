<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="menu.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

    <title>Raport tool</title>
</head>
<body>


    <form:form method="post" modelAttribute="user" cssClass="form-horizontal tkFont">

        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">username</label>
                <div class="col-md-1">
                    <form:input path="username" id="username" name="username" type="text" placeholder="username" class="form-control input-md" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="enabled">enabled</label>
                <div class="col-md-1">
                    <form:select path="enabled" id="enabled" name="enabled" class="form-control" items="${enabled}" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="enabled">role</label>
                <div class="col-md-1">
                    <form:select path="userRoles" id="role" name="role" class="form-control" >
                        <form:option value="1">ROLE_ADMIN</form:option>
                        <form:option value="2">ROLE_USER</form:option>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-1">
                    <form:input path="password" id="password" name="password" type="password" placeholder="password" class="form-control input-md" />
                </div>

            <div class="col-md-4">
                <button type="submit" id="save" name="save" class="btn btn-success">Save</button>
            </div>
        </div>
        </fieldset>
    </form:form>
</body>
</html>
