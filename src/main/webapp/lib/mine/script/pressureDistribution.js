function PressureDistribution() {
}

PressureDistribution.prototype = function() {
	var table = $("#wellPressureDistributionTable").DataTable();
	var urlParamParser = new UrlParamParser();
	var wellId = urlParamParser.getParamFromUri('wellId');
	var options = new ChartHelper().buildOptions('highchartsPlot');
	var chart = new Highcharts.Chart(options);

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
			drawChartWithDataInTable = function() {
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
										// drawChartWithTheDataIn(table);
									}
								}, "json").error(function() {
							information($.i18n.prop('failed-connect-server'));
						});
			}

	return {
		addAWellPressureDistribution : addAWellPressureDistribution,
		loadAll : loadAll,
		drawChartWithDataInTable : drawChartWithDataInTable
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
	PressureDistribution_Instance.drawChartWithDataInTable();
});
$(document).ready(function() {
	PressureDistribution_Instance.loadAll();
});