var result = new Array();
result[0] = "id";
result[1] = "pumpingMachineType";
result[2] = "producingOilRate";
result[3] = "production";
result[4] = "pumpDiameter";
result[5] = "stroke";
result[6] = "bluntTimes";
result[7] = "wellHeadCasingPressure";
result[8] = "pumpDepth";
result[9] = "volumetricMoistureContent";
result[10] = "workingFluidLevel";
result[11] = "sternTubeLength";

function WellProductDataModel() {
}

WellProductDataModel.prototype.getParamNames = function() {
	return result;
}

function editWellProductData(wellId, wellProductData) {
	if ($("#WellProductParams").length <= 0) {
		buildModalWindow("WellProductParams", "#other-modal-window", wellId,
				new WellProductDataModel().getParamNames(),
				wellProductData == undefined ? null : wellProductData,
				"onSubmitProductData(" + wellId + ")");

	}
	$("#WellProductParams").modal('show');
}

updateOrInsert = function() {
	$.post()
}