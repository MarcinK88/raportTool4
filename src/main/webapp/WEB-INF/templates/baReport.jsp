<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="menu.jsp"/>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Raport tool</title>
    <link href="css/font.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="divposition">
${selectedBa}, ${selectedMonth} ${selectedYear}
</div>
<div class="container tkFont">

    <%-- Opened Requests per month per type --%>

    <div class="row my-2">
        <div class="col-md-9 py-1">
            <div class="card">
                <div class="card-body">
                    <canvas id="chBar"></canvas>

                    <table class="table table-striped table-hover table-sm table-bordered table-responsive"
                           id="dataTable">
                        <thead>
                        <th></th>
                        <c:forEach items="${months}" var="month">
                            <th>${month}</th>
                        </c:forEach>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Other</td>
                            <c:forEach items="${otherData}" var="otherData">
                                <td>${otherData}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Domain mgmt</td>
                            <c:forEach items="${domainMgmtData}" var="domainMgmtData">
                                <td>${domainMgmtData}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>IP mgmt</td>
                            <c:forEach items="${ipData}" var="ipdata">
                                <td>${ipdata}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>SSL Certificate</td>
                            <c:forEach items="${sslData}" var="ssldata">
                                <td>${ssldata}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>DNS</td>
                            <c:forEach items="${dnsData}" var="dnsdata">
                                <td>${dnsdata}</td>
                            </c:forEach>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <%-- Opened Requests in selected month per type --%>
    <div class="col-md-6 py-1">
        <div class="card">
            <div class="card-body">
                <canvas id="openedselmon"></canvas>
                <table class="table table-striped table-hover table-sm table-bordered" id="openedselmontab">
                    <thead>
                    <th>DNS</th>
                    <th>SSL Certificate</th>
                    <th>IP mgmt</th>
                    <th>Domain mgmt</th>
                    <th>Other</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${totalDnsDatas}</td>
                        <td>${totalSslDatas}</td>
                        <td>${totalIpDatas}</td>
                        <td>${totalDomainDatas}</td>
                        <td>${totalOtherDatas}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>

    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <script src="${context}/js/specificba.js"></script>
    <jsp:include page="footer_rel.jsp"/>
</body>
</html>
