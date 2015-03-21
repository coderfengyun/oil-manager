var parameters = new Array();
parameters[0] = "saturationPressure";
parameters[1] = "reservoirPressure";
parameters[2] = "crudeOilDensity";
parameters[3] = "crudeOilViscosity";
parameters[4] = "formationWaterDensity";
parameters[5] = "gasPhaseRelativeDensity";
function FliudPhysicalParameterModel() {
}

FluidPhysicalParameterModel.prototype.getParams = function() {
	return parameters;
}

FluidPhysicalParameterModel.prototype.editWellProductData = function(wellId,
		wellProductData) {
	var windowName = "#FluidPhysicalParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window", wellId,
				new WellProductDataModel().getParamNames(),
				wellProductData == undefined ? null : wellProductData,
				"updateProductData(" + wellId + ")");

	}
	$("#WellProductParams").modal('show');
}
