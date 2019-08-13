<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row my-3">
        <div class="col">
            <h4>Bootstrap 4 Chart.js</h4>
        </div>
    </div>
    <div class="row my-2">
        <div class="col-md-8 py-1">
            <div class="card">
                <div class="card-body">
                    <canvas id="chBar"></canvas>
                    <table class="table" id="dataTable">
                        <thead>
                        <c:forEach items="${months}" var="month">
                            <th>${month}</th>
                        </c:forEach>
                        </thead>
                        <tbody>
                                <tr>
                                    <c:forEach items="${otherData}" var="otherData">
                                        <td>${otherData}</td>
                                    </c:forEach>
                                </tr>
                                <tr>
                                    <c:forEach items="${domainMgmtData}" var="domainMgmtData">
                                        <td>${domainMgmtData}</td>
                                    </c:forEach>
                                </tr>
                                <tr>
                                    <c:forEach items="${ipdata}" var="ipdata">
                                        <td>${ipdata}</td>
                                    </c:forEach>
                                </tr>
                                <tr>
                                    <c:forEach items="${ssldata}" var="ssldata">
                                        <td>${ssldata}</td>
                                    </c:forEach>
                                </tr>
                                <tr>
                                    <c:forEach items="${dnsdata}" var="dnsdata">
                                        <td>${dnsdata}</td>
                                    </c:forEach>
                                </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-6 py-1">
            <div class="card">
                <div class="card-body">
                    <canvas id="chLine"></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="row py-2">
        <div class="col-md-4 py-1">
            <div class="card">
                <div class="card-body">
                    <canvas id="chDonut1"></canvas>
                </div>
            </div>
        </div>
        <div class="col-md-4 py-1">
            <div class="card">
                <div class="card-body">
                    <canvas id="chDonut2"></canvas>
                </div>
            </div>
        </div>
        <div class="col-md-4 py-1">
            <div class="card">
                <div class="card-body">
                    <canvas id="chDonut3"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>

<c:set var="context" value="${pageContext.request.contextPath}" />
<script src="${context}/js/stackedChart.js"></script>

</body>
</html>

