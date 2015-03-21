var RodStructure_Parameters = new Array();
RodStructure_Parameters[0] = "poleLevel";
RodStructure_Parameters[1] = "rodDiameter";
RodStructure_Parameters[2] = "rodLength";
function RodStructureParameterModel() {
}

function editRodStructureParameter(wellId, rodStructureParameter) {
	var windowName = "RodStructureParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window", wellId,
				RodStructure_Parameters,
				rodStructureParameter == undefined ? null
						: rodStructureParameter, "updateRodStructureParameter("
						+ wellId + ")");

	}
	$("#RodStructureParameterModel").modal('show');
}

updateRodStructureParameter = function(wellId) {
	$.post("/well/" + wellId + "/updateRodStructureParameter", {
		"poleLevel" : $("#poleLevel").val(),
		"rodDiameter" : $("#rodDiameter").val(),
		"rodLength" : $("#rodLength").val(),
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
