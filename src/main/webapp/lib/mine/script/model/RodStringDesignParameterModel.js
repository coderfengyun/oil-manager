var RodStringDesign_Parameters = new Array();
RodStringDesign_Parameters[0] = "safetyFactor";
RodStringDesign_Parameters[1] = "poleLevel";
RodStringDesign_Parameters[2] = "minRodDiameter";

var RodStringDesign_Labels = new Array();
RodStringDesign_Labels[0] = "安全系数";
RodStringDesign_Labels[1] = "杆柱级数（1,2,3）";
RodStringDesign_Labels[2] = "最小杆径（m）";

function RodStringDesignParameterModel() {
}

function editRodStringDesignParameter(wellId, rodStringDesignParameter) {
	var windowName = "RodStringDesignParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window",
				RodStringDesign_Parameters,
				rodStringDesignParameter == undefined ? null
						: rodStringDesignParameter, RodStringDesign_Labels,
				"updateRodStringDesignParameter(" + wellId + ")");
	}
	$("#RodStringDesignParameterModel").modal('show');
}

updateRodStringDesignParameter = function(wellId) {
	$.post("/well/" + wellId + "/updateRodStringDesignParameter", {
		"safetyFactor" : $("#safetyFactor").val(),
		"poleLevel" : $("#poleLevel").val(),
		"minRodDiameter" : $("#minRodDiameter").val(),
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
