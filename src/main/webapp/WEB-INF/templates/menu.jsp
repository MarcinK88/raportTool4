<!DOCTYPE html>
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
        .bs-example{
            margin: 20px;
        }
    </style>

</head>
<body>
<div class="bs-example">
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
                        <a href="/converted" class="dropdown-item">All tickets</a>
                        <a href="/opentickets" class="dropdown-item">Opened tickets</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Reports</a>
                <div class="dropdown-menu">
                    <a href="/charttest" class="dropdown-item">Monthly report</a>
                    <a href="#" class="dropdown-item">Other reports</a>
                </div>
                </div>
                <a href="/importlist" class="nav-item nav-link">Import file</a>
            </div>
            <div class="navbar-nav">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${sessionScope.get("loggedUser")}</a>
                <div class="dropdown-menu dropdown-menu-right dropdown-info">
                    <a href="/logout" class="dropdown-item">Logout</a>
                </div>
            </div>
        </div>
    </nav>
