var FluidPhysica_Parameters = new Array();
FluidPhysica_Parameters[0] = "saturationPressure";
FluidPhysica_Parameters[1] = "reservoirPressure";
FluidPhysica_Parameters[2] = "crudeOilDensity";
FluidPhysica_Parameters[3] = "crudeOilViscosity";
FluidPhysica_Parameters[4] = "formationWaterDensity";
FluidPhysica_Parameters[5] = "gasPhaseRelativeDensity";

function FliudPhysicalParameterModel() {
}

function editFluidPhysicalParameter(wellId, fluidPhysicalParameter) {
	var windowName = "FluidPhysicalParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window", wellId,
				FluidPhysica_Parameters,
				fluidPhysicalParameter == undefined ? null
						: fluidPhysicalParameter,
				"updateFluidPhysicalParameter(" + wellId + ")");

	}
	$("#FluidPhysicalParameterModel").modal('show');
}

updateFluidPhysicalParameter = function(wellId) {
	$.post("/well/" + wellId + "/updateFluidPhysicalParameter", {
		"saturationPressure" : $("#saturationPressure").val(),
		"reservoirPressure" : $("#reservoirPressure").val(),
		"crudeOilDensity" : $("#crudeOilDensity").val(),
		"crudeOilViscosity" : $("#crudeOilViscosity").val(),
		"formationWaterDensity" : $("#formationWaterDensity").val(),
		"gasPhaseRelativeDensity" : $("#gasPhaseRelativeDensity").val(),
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
