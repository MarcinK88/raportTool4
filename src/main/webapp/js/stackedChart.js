/* chart.js chart examples */

// chart colors
var colors = ['#007bff','#28a745','#333333','#c3e6cb','#dc3545','#6c757d'];

// Requests per BA
var reqperba = document.getElementById("reqperba");
var reqperbatab = document.getElementById("reqperbatab");

// Go through cells
for (var i = 1; i < reqperbatab.rows.length; i++) {
    var reqperbatabRow = reqperbatab.rows[i];
    var coData = {};
    var isData = {};
    var mxData = {};
    var seData = {};
    var etData = {};
    var ctData = {};
    var reqperbaLabels = {};
    for (var j = 1; j < reqperbatab.rows[0].cells.length; j++) {
        reqperbaLabels[j-1] = reqperbatab.rows[0].cells[j].innerHTML;
        coData[j-1] = reqperbatab.rows[1].cells[j].innerHTML;
        isData[j-1] = reqperbatab.rows[2].cells[j].innerHTML;
        mxData[j-1] = reqperbatab.rows[3].cells[j].innerHTML;
        seData[j-1] = reqperbatab.rows[4].cells[j].innerHTML;
        etData[j-1] = reqperbatab.rows[5].cells[j].innerHTML;
        ctData[j-1] = reqperbatab.rows[6].cells[j].innerHTML;
    }


}

if (reqperba) {

    var valuesCo = Object.values(coData).map(Number);
    var valuesIs = Object.values(isData).map(Number);
    var valuesMx = Object.values(mxData).map(Number);
    var valuesSe = Object.values(seData).map(Number);
    var valuesEt = Object.values(etData).map(Number);
    var valuesCt = Object.values(ctData).map(Number);
    var reqperbaValuesLabels = Object.values(reqperbaLabels);



    new Chart(reqperba, {
        type: 'bar',
        data: {
            labels: reqperbaValuesLabels,
            datasets: [{
                label: 'CO',
                data: valuesCo,
                backgroundColor: colors[0]
            },
                {
                    label: 'IS',
                    data: valuesIs,
                    backgroundColor: colors[1]
                },
                {
                    label: 'MX',
                    data: valuesMx,
                    backgroundColor: colors[2]
                },
                {
                    label: 'SE',
                    data: valuesSe,
                    backgroundColor: colors[3]
                },
                {
                    label: 'ET',
                    data: valuesEt,
                    backgroundColor: colors[4]
                },
                {
                    label: 'CT',
                    data: valuesCt,
                    backgroundColor: colors[5]
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
                text: 'Number of opened Requests per BA',
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


// Requests per region
var reqperreg = document.getElementById("reqperreg");
var reqperregtab = document.getElementById("reqperregtab");

// Go through cells
for (var i = 1; i < reqperregtab.rows.length; i++) {
    var reqperregtabRow = reqperregtab.rows[i];
    var apacData = {};
    var emeaData = {};
    var latamData = {};
    var naData = {};
    var reqperregLabels = {};
    for (var j = 1; j < reqperregtab.rows[0].cells.length; j++) {
        reqperregLabels[j-1] = reqperregtab.rows[0].cells[j].innerHTML;
        apacData[j-1] = reqperregtab.rows[1].cells[j].innerHTML;
        emeaData[j-1] = reqperregtab.rows[2].cells[j].innerHTML;
        latamData[j-1] = reqperregtab.rows[3].cells[j].innerHTML;
        naData[j-1] = reqperregtab.rows[4].cells[j].innerHTML;
    }
}

if (reqperreg) {
    var valuesApac = Object.values(apacData).map(Number);
    var valuesEmea = Object.values(emeaData).map(Number);
    var valuesLatam = Object.values(latamData).map(Number);
    var valuesNa = Object.values(naData).map(Number);
    var reqperregValuesLabels = Object.values(reqperregLabels);

    new Chart(reqperreg, {
        type: 'bar',
        data: {
            labels: reqperregValuesLabels,
            datasets: [{
                label: 'APAC',
                data: valuesApac,
                backgroundColor: colors[0]
            },
                {
                    label: 'EMEA',
                    data: valuesEmea,
                    backgroundColor: colors[1]
                },
                {
                    label: 'LATAM',
                    data: valuesLatam,
                    backgroundColor: colors[2]
                },
                {
                    label: 'NA',
                    data: valuesNa,
                    backgroundColor: colors[3]
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
                text: 'Number of opened Requests per Region',
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

//Requests per category
var reqpercat = document.getElementById("reqpercat");
var reqpercattab = document.getElementById("reqpercattab");

var datas = {};
var reqpercatLabels = {};

for (var j = 0; j < reqpercattab.rows[0].cells.length; j++) {
    reqpercatLabels[j] = reqpercattab.rows[0].cells[j].innerHTML;
    datas[j] = reqpercattab.rows[1].cells[j].innerHTML;

}

if (reqpercat) {
    var valuesDatas = Object.values(datas).map(Number);
    var reqpercatValuesLabels = Object.values(reqpercatLabels).map(String);

new Chart(reqpercat, {
    type: 'pie',
    data: {
        labels: reqpercatValuesLabels,
        datasets: [{
            backgroundColor: [colors[0], colors[1], colors[2], colors[3], colors[4]],
            data: valuesDatas
        }],


    },
    options: {
        legend: {
            display: true,
            position: 'right'
        },
        title: {
            display: true,
            text: 'Total Number of Requests per category',
            fontSize: 18,
            fontStyle: 'bold'
        }
    }
});
}

//KPI1
var kpi1 = document.getElementById("kpi1");
var kpi1tab = document.getElementById("kpi1tab");
var kpi1Labels = {};
var kpi1Data = {};

// Go through cells
for (var i = 0; i < kpi1tab.rows[0].cells.length; i++) {
    kpi1Labels[i] = kpi1tab.rows[0].cells[i].innerHTML;
    kpi1Data[i] = kpi1tab.rows[1].cells[i].innerHTML;
}

if(kpi1) {

    var valuesKpi1 = Object.values(kpi1Data).map(Number);
    var kpi1ValuesLabels = Object.values(kpi1Labels).map(String);

    new Chart(kpi1, {
        type: 'bar',
        data: {
            labels: kpi1ValuesLabels,
            datasets: [{
              data: valuesKpi1,
              backgroundColor: colors[0]
          }]
        },
        options: {
            scales: {
              yAxes: [{
                  ticks: {
                      beginAtZero: true
                  }
              }]
            },
            legend: {
                display: false
            },
            title: {
                display: true,
                text: 'Mean resolution time in days',
                fontSize: 18,
                fontStyle: 'bold'
            }
        }

    });
}

//KPI2
var kpi2 = document.getElementById("kpi2");
var kpi2tab = document.getElementById("kpi2tab");
var kpi2Labels = {};
var kpi2Data = {};

// Go through cells
for (var i = 0; i < kpi2tab.rows[0].cells.length; i++) {
    kpi2Labels[i] = kpi2tab.rows[0].cells[i].innerHTML;
    kpi2Data[i] = kpi2tab.rows[1].cells[i].innerHTML;
}

if(kpi2) {

    var valuesKpi2 = Object.values(kpi2Data).map(Number);
    var kpi2ValuesLabels = Object.values(kpi2Labels).map(String);

    new Chart(kpi2, {
        type: 'bar',
        data: {
            labels: kpi2ValuesLabels,
            datasets: [{
                data: valuesKpi2,
                backgroundColor: colors[0]
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            legend: {
                display: false
            },
            title: {
                display: true,
                text: '% of tickets solved the same day',
                fontSize: 18,
                fontStyle: 'bold'
            }
        }

    });
}

//KPI3
var kpi3 = document.getElementById("kpi3");
var kpi3tab = document.getElementById("kpi3tab");
var kpi3Labels = {};
var kpi3Data = {};

// Go through cells
for (var i = 0; i < kpi3tab.rows[0].cells.length; i++) {
    kpi3Labels[i] = kpi3tab.rows[0].cells[i].innerHTML;
    kpi3Data[i] = kpi3tab.rows[1].cells[i].innerHTML;
}

if(kpi3) {

    var valuesKpi3 = Object.values(kpi3Data).map(Number);
    var kpi3ValuesLabels = Object.values(kpi3Labels).map(String);

    new Chart(kpi3, {
        type: 'bar',
        data: {
            labels: kpi3ValuesLabels,
            datasets: [{
                data: valuesKpi3,
                backgroundColor: colors[0]
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            legend: {
                display: false
            },
            title: {
                display: true,
                text: 'Mean resolution time in days per type ',
                fontSize: 18,
                fontStyle: 'bold'
            }
        }

    });
}



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

