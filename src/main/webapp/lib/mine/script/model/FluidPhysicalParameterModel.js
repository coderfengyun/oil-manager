var FluidPhysica_Parameters = new Array();
FluidPhysica_Parameters[0] = "saturationPressure";
FluidPhysica_Parameters[1] = "reservoirPressure";
FluidPhysica_Parameters[2] = "crudeOilDensity";
FluidPhysica_Parameters[3] = "crudeOilViscosity";
FluidPhysica_Parameters[4] = "formationWaterDensity";
FluidPhysica_Parameters[5] = "gasPhaseRelativeDensity";
function FliudPhysicalParameterModel() {
}

FluidPhysicalParameterModel.prototype.getParamNames = function() {
	return FluidPhysica_Parameters;
}

function editFluidPhysicalParameter(wellId, wellProductData) {
	var windowName = "#FluidPhysicalParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window", wellId,
				new FluidPhysicalParameterModel().getParamNames(),
				wellProductData == undefined ? null : wellProductData,
				"updateFluidPhysicalParameter(" + wellId + ")");

	}
	$("#WellProductParams").modal('show');
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
	}, "json").error(function() {
		information($.i18n.prop('failed-connect-server'));
	});
}
