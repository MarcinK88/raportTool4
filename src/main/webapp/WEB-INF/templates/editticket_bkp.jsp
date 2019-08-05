<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 10619730
  Date: 19.07.2019
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
</head>
<body>
logged user: ${sessionScope.get("loggedUser")}<br>
<a href="/">Homepage</a>
<form:form method="post" modelAttribute="ticket">
    <form:hidden path="id" />
    Request ID <form:input path="requestId"/><br>
    Request type <form:select path="requestType" items="${requestType}"/><br>
    Certificate name <form:input path="certificateName"/><br>
    Domain total number/tag <form:input path="domainTotalNumberTag"/><br>
    Request owner <form:select path="requestOwner" items="${ticketOwners}"/><br>
    Request contributor <form:input path="requestContributor"/><br>
    Request status <form:select path="requestStatus" items="${status}"/><br>
    Year <form:input path="year"/><br>
    Open date <form:input path="openDate"/><br>
    Open CW <form:input path="openCw"/> <br>
    Open month <form:input path="openMonth"/><br>
    Close date <form:input path="closeDate"/><br>
    Close CW <form:input path="closeCw"/><br>
    Close month <form:input path="closeMonth"/><br>
    Resolution time (in days) <form:input path="resolutionTimeInDays"/><br>
    Region <form:select path="region" items="${region}"/><br>
    BA <form:select path="ba" items="${ba}"/><br>
    Size <form:input path="size"/><br>
    Provider name <form:input path="providerName"/><br>
    Provider Ref.NO <form:input path="providerRefNo"/><br>
    Requester <form:input path="requester"/><br>
    Comments <form:input path="comments"/><br>


    <input type="submit" value="Save">

</form:form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
