<jsp:include page="menu.jsp"/>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<form method="post" action="/importlist" enctype="multipart/form-data" class="tkFont">
    <input type="file" name="file" />
    <button type="submit" class="btn btn-secondary" >SEND</button>
</form>

</div>
</body>
</html>