var productData_Parameters = new Array();
productData_Parameters[0] = "pumpingMachineType";
productData_Parameters[1] = "producingOilRate";
productData_Parameters[2] = "production";
productData_Parameters[3] = "pumpDiameter";
productData_Parameters[4] = "stroke";
productData_Parameters[5] = "bluntTimes";
productData_Parameters[6] = "wellHeadCasingPressure";
productData_Parameters[7] = "pumpDepth";
productData_Parameters[8] = "volumetricMoistureContent";
productData_Parameters[9] = "workingFluidLevel";
productData_Parameters[10] = "sternTubeLength";

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
	return productData_Parameters;
}