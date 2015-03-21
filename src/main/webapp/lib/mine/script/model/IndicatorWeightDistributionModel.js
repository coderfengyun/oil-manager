var IndicatorWeightDistribution_Parameters = new Array();
IndicatorWeightDistribution_Parameters[0] = "productionCoordination";
IndicatorWeightDistribution_Parameters[1] = "pumpEffeciency";
IndicatorWeightDistribution_Parameters[2] = "systemEffeciency";
IndicatorWeightDistribution_Parameters[3] = "production";
IndicatorWeightDistribution_Parameters[4] = "econemicBenifits";
IndicatorWeightDistribution_Parameters[5] = "utilization";

function IndicatorWeightDistributionModel() {
}

function editIndicatorWeightDistribution(wellId, indicatorWeightDistribution) {
	var windowName = "IndicatorWeightDistribution";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window", wellId,
				IndicatorWeightDistribution_Parameters,
				indicatorWeightDistribution == undefined ? null
						: indicatorWeightDistribution,
				"updateIndicatorWeightDistribution(" + wellId + ")");

	}
	$("#IndicatorWeightDistribution").modal('show');
}

updateIndicatorWeightDistribution = function(wellId) {
	$.post("/well/" + wellId + "/updateIndicatorWeightDistribution", {
		"productionCoordination" : $("#productionCoordination").val(),
		"pumpEffeciency" : $("#pumpEffeciency").val(),
		"systemEffeciency" : $("#systemEffeciency").val(),
		"production" : $("#production").val(),
		"econemicBenifits" : $("#econemicBenifits").val(),
		"utilization" : $("#utilization").val(),
	}, function(data) {
		if (data != null) {
			information(data == true ? "Success" : "Fail");
		} else {
			information("fail");
		}
	}, "json").error(function() {
		information($.i18n.prop('failed-connect-server'));
	});
}
