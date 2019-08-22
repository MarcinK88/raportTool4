//charts for specific BA

// chart colors
var colors = ['#007bff','#28a745','#333333','#c3e6cb','#dc3545','#6c757d'];

// opened requests per month per type
/* bar chart */
var chBar = document.getElementById("chBar");
var table = document.getElementById('dataTable');
var json = []; // First row needs to be headers

// Go through cells
for (var i = 1; i < table.rows.length; i++) {
    var tableRow = table.rows[i];
    var dnsData = {};
    var sslData = {};
    var ipData = {};
    var domainData = {};
    var otherData = {};
    var labels = {};
    for (var j = 1; j < table.rows[0].cells.length; j++) {
        labels[j-1] = table.rows[0].cells[j].innerHTML;
        otherData[j-1] = table.rows[1].cells[j].innerHTML;
        domainData[j-1] = table.rows[2].cells[j].innerHTML;
        ipData[j-1] = table.rows[3].cells[j].innerHTML;
        sslData[j-1] = table.rows[4].cells[j].innerHTML;
        dnsData[j-1] = table.rows[5].cells[j].innerHTML;
    }
}

if (chBar) {

    var valuesOther = Object.values(otherData).map(Number);
    var valuesDns = Object.values(dnsData).map(Number);
    var valuesSsl = Object.values(sslData).map(Number);
    var valuesIp = Object.values(ipData).map(Number);
    var valuesDomain = Object.values(domainData).map(Number);
    var valuesLabels = Object.values(labels);


    new Chart(chBar, {
        type: 'bar',
        data: {
            labels: valuesLabels,
            datasets: [{
                label: 'DNS',
                data: valuesDns,
                backgroundColor: colors[0]
            },
                {
                    label: 'SSL Certificate',
                    data: valuesSsl,
                    backgroundColor: colors[1]
                },
                {
                    label: 'IP mgmt',
                    data: valuesIp,
                    backgroundColor: colors[2]
                },
                {
                    label: 'Domain mgmt',
                    data: valuesDomain,
                    backgroundColor: colors[3]
                },
                {
                    label: 'Other',
                    data: valuesOther,
                    backgroundColor: colors[4]
                }

            ]
        },
        options: {
            legend: {
                display: true,
                position: 'right',
            },
            title: {
                display: true,
                text: 'Opened Requests per month per type',
                fontSize: 18,
                fontStyle: 'bold'
            },
            scales: {
                xAxes: [{
                    barPercentage: 1,
                    categoryPercentage: 0.5,
                    stacked: true
                }],
                yAxes: [{
                    stacked: true
                }]
            }
        }
    });
}

//request per category in selected month
var openedselmon = document.getElementById("openedselmon");
var openedselmontab = document.getElementById("openedselmontab");

var openedselmonDatas = {};
var openedselmonLabels = {};

for (var j = 0; j < openedselmontab.rows[0].cells.length; j++) {
    openedselmonLabels[j] = openedselmontab.rows[0].cells[j].innerHTML;
    openedselmonDatas[j] = openedselmontab.rows[1].cells[j].innerHTML;

}

if (openedselmon) {
    var openedselmonValuesDatas = Object.values(openedselmonDatas).map(Number);
    var openedselmonValuesLabels = Object.values(openedselmonLabels).map(String);

    new Chart(openedselmon, {
        type: 'pie',
        data: {
            labels: openedselmonValuesLabels,
            datasets: [{
                backgroundColor: [colors[0], colors[1], colors[2], colors[3], colors[4]],
                data: openedselmonValuesDatas
            }],


        },
        options: {
            legend: {
                display: true,
                position: 'right'
            },
            title: {
                display: true,
                text: 'Number of Requests per category',
                fontSize: 18,
                fontStyle: 'bold'
            }
        }
    });
}


