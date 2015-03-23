var IndicatorWeightDistribution_Parameters = new Array();
IndicatorWeightDistribution_Parameters[0] = "productionCoordination";
IndicatorWeightDistribution_Parameters[1] = "pumpEffeciency";
IndicatorWeightDistribution_Parameters[2] = "systemEffeciency";
IndicatorWeightDistribution_Parameters[3] = "production";
IndicatorWeightDistribution_Parameters[4] = "econemicBenifits";
IndicatorWeightDistribution_Parameters[5] = "utilization";

var IndicatorWeightDistribution_Labels = new Array();
IndicatorWeightDistribution_Labels[0] = "供产协调";
IndicatorWeightDistribution_Labels[1] = "泵效";
IndicatorWeightDistribution_Labels[2] = "系统效率";
IndicatorWeightDistribution_Labels[3] = "产量";
IndicatorWeightDistribution_Labels[4] = "经济效益";
IndicatorWeightDistribution_Labels[5] = "利用率";

function IndicatorWeightDistributionModel() {
}

function editIndicatorWeightDistribution(wellId, indicatorWeightDistribution) {
	var windowName = "IndicatorWeightDistribution";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window",
				IndicatorWeightDistribution_Parameters,
				indicatorWeightDistribution == undefined ? null
						: indicatorWeightDistribution,
				IndicatorWeightDistribution_Labels,
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
