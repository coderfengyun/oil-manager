var RodStringDesign_Parameters = new Array();
RodStringDesign_Parameters[0] = "safetyFactor";
RodStringDesign_Parameters[1] = "poleLevel";
RodStringDesign_Parameters[2] = "minRodDiameter";
function RodStringDesignParameterModel() {
}

function editRodStringDesignParameter(wellId, rodStringDesignParameter) {
	var windowName = "RodStringDesignParameterModel";
	if ($(windowName).length <= 0) {
		buildModalWindow(windowName, "#other-modal-window", wellId,
				RodStringDesign_Parameters,
				rodStringDesignParameter == undefined ? null
						: rodStringDesignParameter,
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
