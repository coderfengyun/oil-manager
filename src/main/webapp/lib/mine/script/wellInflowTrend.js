WellInflowTrend.prototype = function() {
	var wellId = new UrlParamParser().getParamFromUri('wellId');
	var trendIdValueMap = new Array();
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

	var chart = new Highcharts.Chart(options);

			get = function(id) {
				return this.trendIdValueMap[id];
			},

			put = function(id, data) {
				this.trendIdValueMap[id] = data;
			},

			loadWellInflowTrend = function() {
				var operations = null;
				$
						.get(
								wellId + "/inflowTrend/",
								{},
								function(data) {
									if (data == null) {
										information("Get Inflow Trend Fails!")
									} else {
										for (var i = 0; i < data.length; i++) {
											var inflowTrend = data[i];
											var tr = table.row
													.add(
															[
																	i + 1,
																	inflowTrend.producedFluidVolume,
																	inflowTrend.wellBotomFlowPressure,
																	operations ])
													.draw().node();
											$(tr).attr("id", inflowTrend.id);
										}
										drawChartWithTheDataIn(table);
									}
								}, "json").error(function() {
							information($.i18n.prop('failed-connect-server'));
						});
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

			init = function() {
				$("#" + this.tableName)
						.dataTable(
								{
									"language" : {
										"search" : $.i18n
												.prop('dataTable.search'),
										"lengthMenu" : "_MENU_"
												+ $.i18n
														.prop('dataTable.number_per_page'),
										"emptyTable" : $.i18n
												.prop('dataTable.no_data_in_table'),
										"info" : "_START_"
												+ $.i18n.prop('dataTable.to')
												+ "_END_"
												+ $.i18n
														.prop('dataTable.total')
												+ "_TOTAL_"
												+ $.i18n
														.prop('dataTable.record'),
										"paginate" : {
											"previous" : $.i18n
													.prop('dataTable.previous-page'),
											"next" : $.i18n
													.prop('dataTable.next-page'),
										},
										"infoEmpty" : $.i18n.prop('no-entries'),
									}
								});
			}
	return {
		loadWellInflowTrend : loadWellInflowTrend,
		paramNameList : paramNameList,
		paramLabelList : paramLabelList,
		trendIdValueMap : trendIdValueMap,
		paramWindowName : paramWindowName,
		drawChartWithTheDataIn : drawChartWithTheDataIn,
		appendRowToTable : appendRowToTable,
		wellId : wellId
	};
}();

function WellInflowTrend() {
	var modalWindowDiv = '<div id="modal-windows"></div>'
	$(document.body).append(modalWindowDiv);
}

var WellInflowTrend_Instance = new WellInflowTrend();

$(document).ready(function() {
	WellInflowTrend_Instance.loadWellInflowTrend();
});

addAWellInflowTrend = function(wellId) {
	var producedFluidVolume = $("#producedFluidVolume").val(), wellBotomFlowPressure = $(
			"#wellBotomFlowPressure").val();
	$.ajax({
		url : wellId + "/inflowTrend/",
		type : 'PUT',
		data : {
			"producedFluidVolume" : producedFluidVolume,
			"wellBotomFlowPressure" : wellBotomFlowPressure,
		},
		dataType : 'json',
		success : function(response) {
			if (response == null || response == false) {
				information("Add WellInflowTrend Fails!");
			} else {
				WellInflowTrend_Instance.appendRowToTable([
						producedFluidVolume, wellBotomFlowPressure ]);
				WellInflowTrend_Instance.drawChartWithTheDataIn();
				information("Success!");
			}
		},
		error : function() {
			information($.i18n.prop('failed-connect-server'));
		}
	});
}

$('.btn-add').click(
		function(e) {
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