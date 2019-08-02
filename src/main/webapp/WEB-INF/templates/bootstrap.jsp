<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,500" rel="stylesheet"/>

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">


</head>

<body>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Form Name</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestId">Request ID</label>
            <div class="col-md-4">
                <input id="requestId" name="requestId" type="text" placeholder="Request ID" class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestType">Request type</label>
            <div class="col-md-4">
                <select id="requestType" name="requestType" class="form-control">
                    <option value="SSL Certificate">SSL Certificate</option>
                    <option value="DNS">DNS</option>
                    <option value="IP mgmt">IP mgmt</option>
                    <option value="Domain mgmt">Domain mgmt</option>
                    <option value="Other">Other</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="certificateNam">Certificate name</label>
            <div class="col-md-4">
                <input id="certificateNam" name="certificateNam" type="text" placeholder="Certificate name" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="domainTotalNumberTag">Domain total number/tag</label>
            <div class="col-md-4">
                <input id="domainTotalNumberTag" name="domainTotalNumberTag" type="text" placeholder="Domain total number/tag" class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestOwner">Request owner</label>
            <div class="col-md-4">
                <select id="requestOwner" name="requestOwner" class="form-control">
                    <option value="Matthias Hagen">Matthias Hagen</option>
                    <option value="Marcin Kucharczyk">Marcin Kucharczyk</option>
                    <option value="Katarzyna Rytter">Katarzyna Rytter</option>
                    <option value="Frank Witzer">Frank Witzer</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestContributor">Request contributor</label>
            <div class="col-md-4">
                <input id="requestContributor" name="requestContributor" type="text" placeholder="Request contributor" class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requestStatus">Request status</label>
            <div class="col-md-4">
                <select id="requestStatus" name="requestStatus" class="form-control">
                    <option value="In progress">In progress</option>
                    <option value="Closed">Closed</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="year">Year</label>
            <div class="col-md-4">
                <input id="year" name="year" type="text" placeholder="Year" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="openDate">Open date</label>
            <div class="col-md-4">
                <input id="openDate" name="openDate" type="text" placeholder="Open date" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="openCw">Open CW</label>
            <div class="col-md-4">
                <input id="openCw" name="openCw" type="text" placeholder="Open CW" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="openMonth">Open month</label>
            <div class="col-md-4">
                <input id="openMonth" name="openMonth" type="text" placeholder="Open month" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="closeDate">Close date</label>
            <div class="col-md-4">
                <input id="closeDate" name="closeDate" type="text" placeholder="Close date" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="closeCw">Close CW</label>
            <div class="col-md-4">
                <input id="closeCw" name="closeCw" type="text" placeholder="Close CW" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="closeMonth">Close month</label>
            <div class="col-md-4">
                <input id="closeMonth" name="closeMonth" type="text" placeholder="Close month" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="resolutionTimeInDays"> Resolution time (in days)</label>
            <div class="col-md-4">
                <input id="resolutionTimeInDays" name="resolutionTimeInDays" type="text" placeholder=" Resolution time (in days)" class="form-control input-md">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="region">Region</label>
            <div class="col-md-4">
                <select id="region" name="region" class="form-control">
                    <option value="EMEA">EMEA</option>
                    <option value="APAC">APAC</option>
                    <option value="LATAM">LATAM</option>
                    <option value="NA">NA</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="ba">BA</label>
            <div class="col-md-4">
                <select id="ba" name="ba" class="form-control">
                    <option value="CO">CO</option>
                    <option value="CT">CT</option>
                    <option value="ET">ET</option>
                    <option value="IS">IS</option>
                    <option value="MX">MX</option>
                    <option value="SE">SE</option>
                </select>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="size">Size</label>
            <div class="col-md-4">
                <input id="size" name="size" type="text" placeholder="Size" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="providerName">Provider name</label>
            <div class="col-md-4">
                <input id="providerName" name="providerName" type="text" placeholder="Provider name" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="providerRefNo">Provider Ref.NO</label>
            <div class="col-md-4">
                <input id="providerRefNo" name="providerRefNo" type="text" placeholder="placeholder" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="requester">Requester</label>
            <div class="col-md-4">
                <input id="requester" name="requester" type="text" placeholder="Requester" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="comments">Comments</label>
            <div class="col-md-4">
                <input id="comments" name="comments" type="text" placeholder="Comments" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="save">Save ticket</label>
            <div class="col-md-4">
                <button id="save" name="save" class="btn btn-success">Save</button>
            </div>
        </div>

    </fieldset>
</form>



<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/plug-ins/1.10.15/sorting/stringMonthYear.js"></script>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script src="${context}/js/script.js"></script>

</body>
</html>