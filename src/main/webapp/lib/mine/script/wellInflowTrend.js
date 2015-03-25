WellInflowTrend.prototype = function() {
	var wellId = -1;
	var trendIdValueMap = new Array();
	var paramWindowName = "WellInflowTrendParameters";
	var tableName = "wellInflowTrendTable";
	var chartDivId = "highchartsPlot";
	var paramNameList = new Array();
	var paramLabelList = new Array();
	paramNameList[0] = "producedFluidVolume";
	paramNameList[1] = "wellBotomFlowPressure";
	paramLabelList[0] = "产液量(t\d)";
	paramLabelList[1] = "井底流压(MPa)";
	var options = {
		chart : {
			renderTo : chartDivId,
			defaultSeriesType : 'line',
		},
		plotOptions : {
			series : {
				fillOpacity : 0.85,
				color : '#369bd7'
			}
		},
		credits : {
			enabled : false
		},
		legend : {
			enabled : false
		},
		title : {
			text : $.i18n.prop('test-loadSchedule'),
			align : "center",
			style : {
				fontSize : '13px',
				fontWeight : "bold",
			},
			margin : 20,
		},
		xAxis : {
			plotLines : [ {
				width : 20,
				color : '#808080'
			} ],
			min : 0,
			title : {
				text : $.i18n.prop('times'),
				style : {
					fontSize : '13px',
					fontWeight : "bold",
				},
			},
			gridLineWidth : 1,
		},
		yAxis : {
			plotLines : [ {
				value : 0,
				width : 1,
				color : '#808080'
			} ],
			title : {
				text : $.i18n.prop('users'),
				style : {
					fontSize : '13px',
					fontWeight : "bold",
				},
			},
			min : 0,
			gridLineWidth : 1,
		},
		tooltip : {
			formatter : function() {
				var formatStr = '<b>' + this.y + $.i18n.prop('userNumbetPlot')
						+ this.x + $.i18n.prop('timePlot');
				return formatStr;
			}
		},
		series : [ {
			id : 'default-serie',
			data : []
		} ]
	};
	var chart = new Highcharts.Chart(options);
	get = function(id) {
		return this.trendIdValueMap[id];
	},

	put = function(id, data) {
		this.trendIdValueMap[id] = data;
	},

	loadWellInflowTrend = function(wellId) {
		var operations = null;
		var table = getTable();
		$.get(
				"/" + wellId + "/inflowTrend/",
				{},
				function(data) {
					if (data == null) {
						information("Get Inflow Trend Fails!")
					} else {
						for (var i = 0; i < data.length; i++) {
							var inflowTrend = data[i];
							var tr = table.row.add(
									[ i + 1, inflowTrend.producedFluidVolume,
											inflowTrend.wellBotomFlowPressure,
											operations ]).draw().node();
							$(tr).attr("id", inflowTrend.id);
						}
						drawChartWithTheDataIn(table);
					}
				}, "json").error(function() {
			information($.i18n.prop('failed-connect-server'));
		});
	},

	drawChartWithTheDataIn = function(table) {
		var rowCount = table.rows().indexes().length;
		options.series[0].data.splice(0, rowCount - 1);
		for (var i = 0; i < rowCount; i++) {
			var data = table.row(i).data();
			options.series[0].data.push([ data[1], data[2] ]);
		}
		options.series[0].data.sort(function(a, b) {
			if (a[0] < b[0]) {
				return -1;
			} else if (a[0] > b[0]) {
				return 1;
			} else {
				return 0;
			}
		});
		this.chart = new Highcharts.Chart(options);
	};
	getWellIdFromUri = function(name) {
		var regex = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var uriParamPart = window.location.search;
		if (uriParamPart.length < 1) {
			return null;
		}
		var result = uriParamPart.substring(1).match(regex);
		if (result != null) {
			return result[2];
		} else {
			return null;
		}
	};
	getTable = function() {
		return $("#" + tableName).DataTable();
	}
	getChart = function() {
		// return chart;
		return $('#' + chartDivId).highcharts();
	}
	return {
		loadWellInflowTrend : loadWellInflowTrend,
		getWellIdFromUri : getWellIdFromUri,
		paramNameList : paramNameList,
		paramLabelList : paramLabelList,
		trendIdValueMap : trendIdValueMap,
		wellId : wellId,
		paramWindowName : paramWindowName,
		getTable : getTable,
		getChart : getChart,
		drawChartWithTheDataIn : drawChartWithTheDataIn
	};
}();

function WellInflowTrend() {
	var modalWindowDiv = '<div id="modal-windows"></div>'
	$(document.body).append(modalWindowDiv);
}

var WellInflowTrend_Instance = new WellInflowTrend();

$(document).ready(
		function() {
			var table = WellInflowTrend_Instance.getTable();
			var tbody = table.table().body();
			$(tbody).on(
					'click',
					'td a.delete',
					function(e) {
						e.preventDefault();
						var row = $(this).closest("tr");
						var id = $(row).attr("id");
						row = table.row(row);
						if (confirm($.i18n
								.prop("sure_to_delete_this_well_base_data"))) {
							deleteWellBaseData(id, row);
						}
					});

			WellInflowTrend_Instance.wellId = WellInflowTrend_Instance
					.getWellIdFromUri("wellId");
			WellInflowTrend_Instance
					.loadWellInflowTrend(WellInflowTrend_Instance.wellId);
		});

$("#" + WellInflowTrend_Instance.tableName).dataTable(
		{
			"language" : {
				"search" : $.i18n.prop('dataTable.search'),
				"lengthMenu" : "_MENU_"
						+ $.i18n.prop('dataTable.number_per_page'),
				"emptyTable" : $.i18n.prop('dataTable.no_data_in_table'),
				"info" : "_START_" + $.i18n.prop('dataTable.to') + "_END_"
						+ $.i18n.prop('dataTable.total') + "_TOTAL_"
						+ $.i18n.prop('dataTable.record'),
				"paginate" : {
					"previous" : $.i18n.prop('dataTable.previous-page'),
					"next" : $.i18n.prop('dataTable.next-page'),
				},
				"infoEmpty" : $.i18n.prop('no-entries'),
			}
		});

addAWellInflowTrend = function(wellId) {
	var producedFluidVolume = $("#producedFluidVolume").val(), wellBotomFlowPressure = $(
			"#wellBotomFlowPressure").val();
	$
			.ajax({
				url : "/" + wellId + "/inflowTrend/",
				type : 'PUT',
				data : {
					"wellId" : wellId,
					"producedFluidVolume" : producedFluidVolume,
					"wellBotomFlowPressure" : wellBotomFlowPressure,
				},
				dataType : 'json',
				success : function(response) {
					if (response == null || response == false) {
						information("Add WellInflowTrend Fails!");
					} else {
						appendRowToTable([ producedFluidVolume,
								wellBotomFlowPressure ]);
						addPointToChart([ producedFluidVolume,
								wellBotomFlowPressure ]);
						information("Success!");
					}
				},
				error : function() {
					information($.i18n.prop('failed-connect-server'));
				}
			});
}
/**
 * append a row to the tail of the table;
 * 
 * The data is a Array with two element;
 * 
 * At the same time, will add a point to the chart;
 */
appendRowToTable = function(data) {
	var table = WellInflowTrend_Instance.getTable();
	var targetIndex = table.rows().indexes().length;
	table.row.add([ targetIndex + 1, data[0], data[1] ]).draw();
}

addPointToChart = function(data) {
	// var chart = WellInflowTrend_Instance.getChart();
	// var serie = chart.get('default-serie');
	// serie.addPoint(data);
	WellInflowTrend_Instance.drawChartWithTheDataIn(WellInflowTrend_Instance
			.getTable());
}

$('.btn-setting').click(
		function(e) {
			e.preventDefault();
			if ($("#" + WellInflowTrend_Instance.paramWindowName).length <= 0) {
				buildModalWindow(WellInflowTrend_Instance.paramWindowName,
						"#modal-windows",
						WellInflowTrend_Instance.paramNameList, null,
						WellInflowTrend_Instance.paramLabelList,
						"addAWellInflowTrend("
								+ WellInflowTrend_Instance.wellId + ")");
			}
			$("#" + WellInflowTrend_Instance.paramWindowName).modal('show');
		});