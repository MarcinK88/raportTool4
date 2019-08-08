/* chart.js chart examples */

// chart colors
var colors = ['#007bff','#28a745','#333333','#c3e6cb','#dc3545','#6c757d'];

// /* large line chart */
// var chLine = document.getElementById("chLine");
// var chartData = {
//     labels: ["S", "M", "T", "W", "T", "F", "S"],
//     datasets: [{
//         data: [589, 445, 483, 503, 689, 692, 634],
//         backgroundColor: 'transparent',
//         borderColor: colors[0],
//         borderWidth: 4,
//         pointBackgroundColor: colors[0]
//     },
//         {
//             data: [639, 465, 493, 478, 589, 632, 674],
//             backgroundColor: colors[3],
//             borderColor: colors[1],
//             borderWidth: 4,
//             pointBackgroundColor: colors[1]
//         }]
// };
//
// Requests per BA
var reqperba = document.getElementById("reqperba");
var reqperbatab = document.getElementById("reqperbatab");
console.log(reqperbatab.rows[0].cells.length);
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

// /* large pie/donut chart */
// var chPie = document.getElementById("chPie");
// if (chPie) {
//     new Chart(chPie, {
//         type: 'pie',
//         data: {
//             labels: ['Desktop', 'Phone', 'Tablet', 'Unknown'],
//             datasets: [
//                 {
//                     backgroundColor: [colors[1],colors[0],colors[2],colors[5]],
//                     borderWidth: 0,
//                     data: [50, 40, 15, 5]
//                 }
//             ]
//         },
//         plugins: [{
//             beforeDraw: function(chart) {
//                 var width = chart.chart.width,
//                     height = chart.chart.height,
//                     ctx = chart.chart.ctx;
//                 ctx.restore();
//                 var fontSize = (height / 70).toFixed(2);
//                 ctx.font = fontSize + "em sans-serif";
//                 ctx.textBaseline = "middle";
//                 var text = chart.config.data.datasets[0].data[0] + "%",
//                     textX = Math.round((width - ctx.measureText(text).width) / 2),
//                     textY = height / 2;
//                 ctx.fillText(text, textX, textY);
//                 ctx.save();
//             }
//         }],
//         options: {layout:{padding:0}, legend:{display:false}, cutoutPercentage: 80}
//     });
// }
//


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

    // var valuesOther = json.map(function (e) {
    //     return e.otherData;
    // });
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

// /* 3 donut charts */
// var donutOptions = {
//     cutoutPercentage: 85,
//     legend: {position:'bottom', padding:5, labels: {pointStyle:'circle', usePointStyle:true}}
// };
//
// // donut 1
// var chDonutData1 = {
//     labels: ['Bootstrap', 'Popper', 'Other'],
//     datasets: [
//         {
//             backgroundColor: colors.slice(0,3),
//             borderWidth: 0,
//             data: [74, 11, 40]
//         }
//     ]
// };
//
// var chDonut1 = document.getElementById("chDonut1");
// if (chDonut1) {
//     new Chart(chDonut1, {
//         type: 'pie',
//         data: chDonutData1,
//         options: donutOptions
//     });
// }
//
// // donut 2
// var chDonutData2 = {
//     labels: ['Wips', 'Pops', 'Dags'],
//     datasets: [
//         {
//             backgroundColor: colors.slice(0,3),
//             borderWidth: 0,
//             data: [40, 45, 30]
//         }
//     ]
// };
// var chDonut2 = document.getElementById("chDonut2");
// if (chDonut2) {
//     new Chart(chDonut2, {
//         type: 'pie',
//         data: chDonutData2,
//         options: donutOptions
//     });
// }
//
// // donut 3
// var chDonutData3 = {
//     labels: ['Angular', 'React', 'Other'],
//     datasets: [
//         {
//             backgroundColor: colors.slice(0,3),
//             borderWidth: 0,
//             data: [21, 45, 55, 33]
//         }
//     ]
// };
// var chDonut3 = document.getElementById("chDonut3");
// if (chDonut3) {
//     new Chart(chDonut3, {
//         type: 'pie',
//         data: chDonutData3,
//         options: donutOptions
//     });
// }

