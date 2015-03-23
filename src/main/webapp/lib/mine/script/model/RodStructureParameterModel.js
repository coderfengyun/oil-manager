var RodStructure_Parameters = new Array();
RodStructure_Parameters[0] = "poleLevel";
RodStructure_Parameters[1] = "rodDiameter";
RodStructure_Parameters[2] = "rodLength";

var RodStructure_Labels = new Array();
RodStructure_Labels[0] = "杆柱级次（1,2,3）";
RodStructure_Labels[1] = "杆径（m）";
RodStructure_Labels[2] = "杆长（m）";
function RodStructureParameterModel() {
}

function editRodStructureParameter(wellId, rodStructureParameter) {
	var windowName = "RodStructureParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window",
				RodStructure_Parameters,
				rodStructureParameter == undefined ? null
						: rodStructureParameter, RodStructure_Labels,
				"updateRodStructureParameter(" + wellId + ")");

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
