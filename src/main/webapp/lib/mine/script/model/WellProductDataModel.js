var parameters = new Array();
parameters[0] = "id";
parameters[1] = "pumpingMachineType";
parameters[2] = "producingOilRate";
parameters[3] = "production";
parameters[4] = "pumpDiameter";
parameters[5] = "stroke";
parameters[6] = "bluntTimes";
parameters[7] = "wellHeadCasingPressure";
parameters[8] = "pumpDepth";
parameters[9] = "volumetricMoistureContent";
parameters[10] = "workingFluidLevel";
parameters[11] = "sternTubeLength";

function WellProductDataModel() {
}

function editWellProductData(wellId, wellProductData) {
	if ($("#WellProductParams").length <= 0) {
		buildModalWindow("WellProductParams", "#other-modal-window", wellId,
				new WellProductDataModel().getParamNames(),
				wellProductData == undefined ? null : wellProductData,
				"updateProductData(" + wellId + ")");

	}
	$("#WellProductParams").modal('show');
}

function updateProductData(wellId) {
	$.post("/well/" + wellId + "/updateProductData", {
		"pumpingMachineType" : $("#pumpingMachineType").val(),
		"producingOilRate" : $("#producingOilRate").val(),
		"production" : $("#production").val(),
		"pumpDiameter" : $("#pumpDiameter").val(),
		"stroke" : $("#stroke").val(),
		"bluntTimes" : $("#bluntTimes").val(),
		"wellHeadCasingPressure" : $("#wellHeadCasingPressure").val(),
		"pumpDepth" : $("#pumpDepth").val(),
		"volumetricMoistureContent" : $("#volumetricMoistureContent").val(),
		"workingFluidLevel" : $("#workingFluidLevel").val(),
		"sternTubeLength" : $("#sternTubeLength").val(),
	}, function(data) {
		if (data != null) {
			information(data == true ? "succes" : "fail");
		}
	}, "json").error(function() {
		information($.i18n.prop('failed-connect-server'));
	});
}

WellProductDataModel.prototype.getParamNames = function() {
	return parameters;
}