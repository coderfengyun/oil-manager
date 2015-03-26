var FluidPhysica_Parameters = new Array();
FluidPhysica_Parameters[0] = "saturationPressure";
FluidPhysica_Parameters[1] = "reservoirPressure";
FluidPhysica_Parameters[2] = "crudeOilDensity";
FluidPhysica_Parameters[3] = "crudeOilViscosity";
FluidPhysica_Parameters[4] = "formationWaterDensity";
FluidPhysica_Parameters[5] = "gasPhaseRelativeDensity";

var FluidPhysical_Label = new Array();
FluidPhysical_Label[0] = "饱和压力(MPa)";
FluidPhysical_Label[1] = "油层压力(MPa)";
FluidPhysical_Label[2] = "原油密度(kg/m^3)";
FluidPhysical_Label[3] = "原油粘度(mPa.s)";
FluidPhysical_Label[4] = "地层水密度(kg/m^3)";
FluidPhysical_Label[5] = "气相相对密度(小数)";

function FliudPhysicalParameterModel() {
}

function editFluidPhysicalParameter(wellId, fluidPhysicalParameter) {
	var windowName = "FluidPhysicalParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window",
				FluidPhysica_Parameters,
				fluidPhysicalParameter == undefined ? null
						: fluidPhysicalParameter, FluidPhysical_Label,
				"updateFluidPhysicalParameter(" + wellId + ")");

	}
	$("#FluidPhysicalParameterModel").modal('show');
}

updateFluidPhysicalParameter = function(wellId) {
	$.post("well/" + wellId + "/updateFluidPhysicalParameter", {
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
