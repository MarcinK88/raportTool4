<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--    <title>Bootstrap 4 Static Navbar with Dropdown and Search Form</title>--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        .bs-example {
            margin: 20px;
        }
    </style>
    <title>Raport tool</title>
    <c:set var="context" value="${pageContext.request.contextPath}"/>

    <link href="${context}/css/font.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="bs-example tkFont">
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <a href="/" class="navbar-brand">Homepage</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Tickets</a>
                    <div class="dropdown-menu">
                        <a href="/alltickets" class="dropdown-item">All tickets</a>
                        <a href="/opentickets" class="dropdown-item">Opened tickets</a>
                        <a href="/noregion" class="dropdown-item">Tickets with no Region</a>
                        <a href="/noba" class="dropdown-item">Tickets with no BA</a>
                        <a href="/norequester" class="dropdown-item">Tickets with no Requester</a>
                        <a href="/nocomments" class="dropdown-item">Tickets with no Comments</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Reports</a>
                    <div class="dropdown-menu">
                        <a href="/selectmonth" class="dropdown-item">Monthly report</a>
                        <a href="/ba" class="dropdown-item">BA Report</a>
                    </div>
                </div>
                <a href="/importlist" class="nav-item nav-link">Import file</a>
            </div>
            <div class="navbar-nav">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><sec:authentication
                        property="principal.username"/></a>
                <div class="dropdown-menu dropdown-menu-right dropdown-info">
                    <sec:authorize access="hasRole('ADMIN')"><a href="/admin/editusers" class="dropdown-item">Manage
                        users</a></sec:authorize>
                    <a href="/changepwd" class="dropdown-item">Change password</a>
                    <a href="/logout" class="dropdown-item">Logout</a>
                </div>
            </div>
        </div>
    </nav>
</div>

</body>
</html>