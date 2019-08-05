<jsp:include page="menu.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,500" rel="stylesheet"/>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">

</head>
<body>





        <h1>All tickets</h1>
        <table class="table responsive table-hover dataTable" id="sort">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Request ID</th>
                <th scope="col">Request type</th>
                <th scope="col">Certificate name</th>
                <th scope="col">Domain total number/tag</th>
                <th scope="col">Request owner</th>
                <th scope="col">Request contributor</th>
                <th scope="col">Request status</th>
                <th scope="col">Year</th>
                <th scope="col">Open date</th>
                <th scope="col">Open CW</th>
                <th scope="col">Open month</th>
                <th scope="col">Close date</th>
                <th scope="col">Close CW</th>
                <th scope="col">Close month</th>
                <th scope="col">Resolution Time (in days)</th>
                <th scope="col">Region</th>
                <th scope="col">BA</th>
                <th scope="col">Size</th>
                <th scope="col">Provider Name</th>
                <th scope="col">Provider Ref.NO</th>
                <th scope="col">Requester</th>
                <th scope="col">Comments</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${converted}" var="ticket">
                    <tr>
                    <td data-table-header="id"> <a href="/editTicket/${ticket.id}">${ticket.id}</a></td>
                    <td data-table-header="Request ID">${ticket.requestId}</td>
                    <td data-table-header="Request type">${ticket.requestType}</td>
                    <td data-table-header="Certificate name">${ticket.certificateName}</td>
                    <td data-table-header="Domain total number/tag">${ticket.domainTotalNumberTag}</td>
                    <td data-table-header="Request owner">${ticket.requestOwner}</td>
                    <td data-table-header="Request contributor">${ticket.requestContributor}</td>
                    <td data-table-header="Request status">${ticket.requestStatus}</td>
                    <td data-table-header="Year">${ticket.year}</td>
                    <td data-table-header="Open date">${ticket.openDate}</td>
                    <td data-table-header="Open CW">${ticket.openCw}</td>
                    <td data-table-header="Open month">${ticket.openMonth}</td>
                    <td data-table-header="Close date">${ticket.closeDate}</td>
                    <td data-table-header="Close CW">${ticket.closeCw}</td>
                    <td data-table-header="Close month">${ticket.closeMonth}</td>
                    <td data-table-header="Resolution Time (in days)">${ticket.resolutionTimeInDays}</td>
                    <td data-table-header="Region">${ticket.region}</td>
                    <td data-table-header="BA">${ticket.ba}</td>
                    <td data-table-header="Size">${ticket.size}</td>
                    <td data-table-header="Provider Name">${ticket.providerName}</td>
                    <td data-table-header="Provider Ref.NO">${ticket.providerRefNo}</td>
                    <td data-table-header="Requester">${ticket.requester}</td>
                    <td data-table-header="Comments">${ticket.comments}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.15/sorting/stringMonthYear.js"></script>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script src="${context}/js/script.js"></script>
</body>
</html>
