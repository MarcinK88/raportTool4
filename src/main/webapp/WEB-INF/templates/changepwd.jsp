<jsp:include page="menu.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<form method="post" action="/changepwd" class="tkFont">
    <label for="old">Old password:</label>
    <input type="password" id="old" name="oldpwd">
    <label for="new">New password:</label>
    <input type="password" id="new" name="newpwd">
    <button type="submit">change</button>
</form>

${response}
<jsp:include page="footer_abs.jsp"/>
</body>
</html>
