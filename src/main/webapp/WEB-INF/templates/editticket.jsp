<jsp:include page="menu.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,500" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
    <link href="css/font.css" rel="stylesheet" type="text/css"/>
    <title>Raport tool</title>
</head>
<body>

<form:form method="post" modelAttribute="ticket" cssClass="form-horizontal tkFont">
    <fieldset>
        <form:hidden path="id"/>
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestId">Request ID</label>
            <div class="col-md-4">
                <form:input path="requestId" id="requestId" name="requestId" type="text" placeholder="Request ID"
                            cssClass="form-control input-md"/>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestType">Request type</label>
            <div class="col-md-4">
                <form:select id="requestType" name="requestType" class="form-control" path="requestType"
                             items="${requestType}"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="certificateNam">Certificate name</label>
            <div class="col-md-4">
                <form:input path="certificateName" id="certificateNam" name="certificateNam" type="text"
                            placeholder="Certificate name" class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="domainTotalNumberTag">Domain total number/tag</label>
            <div class="col-md-4">
                <form:input path="domainTotalNumberTag" id="domainTotalNumberTag" name="domainTotalNumberTag"
                            type="text" placeholder="Domain total number/tag" class="form-control input-md"/>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestOwner">Request owner</label>
            <div class="col-md-4">
                <form:select path="requestOwner" id="requestOwner" name="requestOwner" class="form-control"
                             items="${ticketOwners}"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestContributor">Request contributor</label>
            <div class="col-md-4">
                <form:input path="requestContributor" id="requestContributor" name="requestContributor" type="text"
                            placeholder="Request contributor" class="form-control input-md"/>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestStatus">Request status</label>
            <div class="col-md-4">
                <form:select path="requestStatus" id="requestStatus" name="requestStatus" class="form-control"
                             items="${requestStatus}"/></div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="year">Year</label>
            <div class="col-md-4">
                <form:input path="year" id="year" name="year" type="text" placeholder="Year"
                            class="form-control input-md"/>

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="openDate">Open date</label>
            <div class="col-md-4">
                <form:input path="openDate" id="openDate" name="openDate" type="date" placeholder="Open date"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="openCw">Open CW</label>
            <div class="col-md-4">
                <form:input path="openCw" id="openCw" name="openCw" type="text" placeholder="Open CW"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="openMonth">Open month</label>
            <div class="col-md-4">
                <form:input path="openMonth" id="openMonth" name="openMonth" type="text" placeholder="Open month"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="closeDate">Close date</label>
            <div class="col-md-4">
                    <%--                <c:if test="${empty ticket.closeDate}">${param.get{ticket} </c:if>--%>
                <form:input path="closeDate" id="closeDate" name="closeDate" type="date" placeholder="Close date"
                            class="form-control input-md"/>
                <input type="checkbox" id="clearDate"> Clear date
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="closeCw">Close CW</label>
            <div class="col-md-4">
                <form:input path="closeCw" id="closeCw" name="closeCw" type="text" placeholder="Close CW"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="closeMonth">Close month</label>
            <div class="col-md-4">
                <form:input path="closeMonth" id="closeMonth" name="closeMonth" type="text" placeholder="Close month"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="resolutionTimeInDays"> Resolution time (in days)</label>
            <div class="col-md-4">
                <form:input path="resolutionTimeInDays" id="resolutionTimeInDays" name="resolutionTimeInDays"
                            type="text" placeholder=" Resolution time (in days)" class="form-control input-md"/>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="region">Region</label>
            <div class="col-md-4">
                <form:select path="region" id="region" name="region" class="form-control" items="${region}"/>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="ba">BA</label>
            <div class="col-md-4">
                <form:select path="ba" id="ba" name="ba" class="form-control" items="${ba}"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="size">Size</label>
            <div class="col-md-4">
                <form:input path="size" id="size" name="size" type="text" placeholder="Size"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="providerName">Provider name</label>
            <div class="col-md-4">
                <form:input path="providerName" id="providerName" name="providerName" type="text"
                            placeholder="Provider name" class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="providerRefNo">Provider Ref.NO</label>
            <div class="col-md-4">
                <form:input path="providerRefNo" id="providerRefNo" name="providerRefNo" type="text"
                            placeholder="Provider Ref.NO" class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requester">Requester</label>
            <div class="col-md-4">
                <form:input path="requester" id="requester" name="requester" type="text" placeholder="Requester"
                            class="form-control input-md"/>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="comments">Comments</label>
            <div class="col-md-4">
                <form:input path="comments" id="comments" name="comments" type="text" placeholder="Comments"
                            class="form-control input-md"/>
            </div>
        </div>

    </fieldset>

    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for="save">Save ticket</label>
        <div class="col-md-4">
            <button type="submit" id="save" name="save" class="btn btn-success">Save</button>
        </div>
    </div>

</form:form>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.15/sorting/stringMonthYear.js"></script>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<script src="${context}/js/cleardatescript.js"></script>
<jsp:include page="footer_rel.jsp"/>
</body>
</html>
