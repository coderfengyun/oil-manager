function PressureDistribution() {
}

PressureDistribution.prototype = function() {
	var table = $("#wellPressureDistributionTable").DataTable();
	var urlParamParser = new UrlParamParser();
	var wellId = urlParamParser.getParamFromUri('wellId');
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
		loadAll : loadAll
	};
}();

var PressureDistribution_Instance = new PressureDistribution();
$(".btn-add").click(function(e) {
	$("#PressureDistributionParams").modal('show');
});
$("#submitPressureDistribution").click(function(e) {
	PressureDistribution_Instance.addAWellPressureDistribution();
});
$(document).ready(function() {
	PressureDistribution_Instance.loadAll();
});