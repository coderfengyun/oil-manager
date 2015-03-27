function PressureDistribution() {
}

PressureDistribution.prototype = function() {
	var table = $("#wellPressureDistributionTable").DataTable();
	var urlParamParser = new UrlParamParser();
	var wellId = urlParamParser.getParamFromUri('wellId');
	var chartHelper = new ChartHelper();
	var sinkingPressureOptions = chartHelper.buildOptions(
			'sinkingPressurePlot', '沉没压力与下泵深度关系曲线', '下泵深度(m)', '沉没压力(MPa)');
	var sinkingPressureChart = new Highcharts.Chart(sinkingPressureOptions);
	var fulfillCoefficientOptions = chartHelper.buildOptions(
			'fulfillCoefficientPlot', '沉没压力与充满系数关系曲线', '沉没压力(MPa)', '充满系数');
	var fulfillCoefficientChart = new Highcharts.Chart(
			fulfillCoefficientOptions);

			appendRowToTable = function(data) {
				new OilTable().appendRowToTable(table, data);
			},

			addAWellPressureDistribution = function() {
				var pumpDepth = $("#pumpDepth").val(), sinkingPressure = $(
						"#sinkingPressure").val(), fulfillCoefficient = $(
						"#fulfillCoefficient").val();
				$.ajax({
					url : wellId + "/pressureDistribution/",
					type : 'PUT',
					data : {
						"pumpDepth" : pumpDepth,
						"sinkingPressure" : sinkingPressure,
						"fulfillCoefficient" : fulfillCoefficient,
					},
					dataType : 'json',
					success : function(response) {
						if (response == null || response == false) {
							information("Add WellInflowTrend Fails!");
						} else {
							appendRowToTable([ pumpDepth, sinkingPressure,
									fulfillCoefficient ]);
							information("Success!");
						}
					},
					error : function() {
						information($.i18n.prop('failed-connect-server'));
					}
				});
			},
			sortByFirst = function(a, b) {
				if (a[0] < b[0]) {
					return -1;
				} else if (a[0] > b[0]) {
					return 1;
				} else {
					return 0;
				}
			},
			drawAllChartWithDataInTable = function() {
				_drawChart(sinkingPressureOptions, sinkingPressureChart, 1, 2);
				_drawChart(fulfillCoefficientOptions, fulfillCoefficientChart,
						2, 3);
			},
			_drawChart = function(options, targetChart, xIndex, yIndex) {
				var rowCount = table.rows().indexes().length;
				var seriesData = options.series[0].data;
				seriesData.splice(0, rowCount - 1);
				for (var i = 0; i < rowCount; i++) {
					var data = table.row(i).data();
					seriesData.push([ data[xIndex], data[yIndex] ]);
				}
				seriesData.sort(sortByFirst);
				targetChart = new Highcharts.Chart(options);
			},
			loadAll = function() {
				var operations = null;
				$
						.get(
								wellId + "/pressureDistribution/",
								{},
								function(data) {
									if (data == null) {
										information("Get Inflow Trend Fails!")
									} else {
										for (var i = 0; i < data.length; i++) {
											var pressureDistribution = data[i];
											var tr = table.row
													.add(
															[
																	i + 1,
																	pressureDistribution.pumpDepth,
																	pressureDistribution.sinkingPressure,
																	pressureDistribution.fulfillCoefficient ])
													.draw().node();
											$(tr).attr("id",
													pressureDistribution.id);
										}
									}
								}, "json").error(function() {
							information($.i18n.prop('failed-connect-server'));
						});
			}

	return {
		addAWellPressureDistribution : addAWellPressureDistribution,
		loadAll : loadAll,
		drawAllChartWithDataInTable : drawAllChartWithDataInTable
	};
}();

var PressureDistribution_Instance = new PressureDistribution();
$(".btn-add").click(function(e) {
	$("#PressureDistributionParams").modal('show');
});
$("#submitPressureDistribution").click(function(e) {
	PressureDistribution_Instance.addAWellPressureDistribution();
});
$("#updateChart").click(function(e) {
	PressureDistribution_Instance.drawAllChartWithDataInTable();
});
$(document).ready(function() {
	PressureDistribution_Instance.loadAll();
});