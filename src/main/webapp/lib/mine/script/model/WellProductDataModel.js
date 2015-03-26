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
productData_Parameters[11] = "wellHeadOilPressure";

var productData_Labels = new Array();
productData_Labels[0] = "抽油机型号";
productData_Labels[1] = "生产气油比(m3/t)";
productData_Labels[2] = "产量(t/d)";
productData_Labels[3] = "泵径(mm)";
productData_Labels[4] = "冲程(m)";
productData_Labels[5] = "冲次(min-1)";
productData_Labels[6] = "井口套压(MPa)";
productData_Labels[7] = "井口油压(MPa)";
productData_Labels[8] = "体积含水率(%)";
productData_Labels[9] = "动液面(m)";
productData_Labels[10] = "尾管长度(m)";
productData_Labels[11] = "井口油压(MPa)";
function WellProductDataModel() {
}

function editWellProductData(wellId, wellProductData) {
	if ($("#WellProductParams").length <= 0) {
		buildModalWindow("WellProductParams", "#other-modal-window",
				new WellProductDataModel().getParamNames(),
				wellProductData == undefined ? null : wellProductData,
				productData_Labels, "updateProductData(" + wellId + ")");

	}
	$("#WellProductParams").modal('show');
}

function updateProductData(wellId) {
	$.post("well/" + wellId + "/updateProductData", {
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