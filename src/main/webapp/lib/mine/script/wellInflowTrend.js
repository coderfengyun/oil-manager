WellInflowTrend.prototype = function() {
	var wellId = new UrlParamParser().getParamFromUri('wellId');
	var paramWindowName = "WellInflowTrendParameters";
	var tableName = "wellInflowTrendTable";
	var chartDivId = "highchartsPlot";
	var paramNameList = new Array();
	var paramLabelList = new Array();
	var table = $("#" + tableName).DataTable();
	paramNameList[0] = "producedFluidVolume";
	paramNameList[1] = "wellBotomFlowPressure";
	paramLabelList[0] = "产液量(t\d)";
	paramLabelList[1] = "井底流压(MPa)";
	var options = new ChartHelper().buildOptions(chartDivId, "油井流入动态",
			paramLabelList[0], paramLabelList[1]);
	var wellInflowTrend_API = new WellInflowTrend_API();
	var chart = new Highcharts.Chart(options);

	pageInit = function() {
		$(document).ready(function() {
			loadWellInflowTrend();
		});

		$('.btn-add').click(
				function(e) {
					if ($("#" + paramWindowName).length <= 0) {
						buildModalWindow(paramWindowName, "#modal-windows",
								paramNameList, null, paramLabelList,
								"addAWellInflowTrend(" + wellId + ")");
					}
					$("#" + paramWindowName).modal('show');
				});
	},

	_loadCallBack = function(data) {
		if (data == null) {
			information("Get Inflow Trend Fails!");
			return;
		}
		var operations = null;
		data.forEach(function(inflowTrend) {
			var tr = table.row.add(
					[ i + 1, inflowTrend.producedFluidVolume,
							inflowTrend.wellBotomFlowPressure, operations ])
					.draw().node();
			$(tr).attr("id", inflowTrend.id);
		});
		drawChartWithTheDataIn(table);

	},

	loadWellInflowTrend = function() {
		wellInflowTrend_API.get(wellId, _loadCallBack);
	},

	drawChartWithTheDataIn = function() {
		var rowCount = table.rows().indexes().length;
		options.series[0].data.splice(0, rowCount - 1);
		for (var i = 0; i < rowCount; i++) {
			var rowData = table.row(i).data();
			options.series[0].data.push([ rowData[1], rowData[2] ]);
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
	},

	/**
	 * append a row to the tail of the table;
	 * 
	 * The data is a Array with two element;
	 * 
	 * At the same time, will add a point to the chart;
	 */
	appendRowToTable = function(data) {
		new OilTable().appendRowToTable(table, data);
	},

	_addCallBack = function(response) {
		if (response == null || response == false) {
			information("Add WellInflowTrend Fails!");
			return;
		}
		appendRowToTable([ producedFluidVolume, wellBotomFlowPressure ]);
		drawChartWithTheDataIn();
		information("Success!");
	},

	addAWellInflowTrend = function(wellId) {
		var input = new Array();
		paramNameList.forEach(function(element) {
			input[element] = $('#' + element).val();
		});
		wellInflowTrend_API.add(wellId, input, _addCallBack);
	}
	return {
		addAWellInflowTrend : addAWellInflowTrend,
		pageInit : pageInit
	};
}();

function WellInflowTrend() {
	var modalWindowDiv = '<div id="modal-windows"></div>'
	$(document.body).append(modalWindowDiv);
}
var WellInflowTrend_Instance = new WellInflowTrend();
WellInflowTrend_Instance.pageInit();
