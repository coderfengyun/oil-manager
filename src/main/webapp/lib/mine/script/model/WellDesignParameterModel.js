var WellDesign_Parameters = new Array();
WellDesign_Parameters[0] = "producedFluidVolume";
WellDesign_Parameters[1] = "moistureRatio";
WellDesign_Parameters[2] = "minProducedFluidVolume";
WellDesign_Parameters[3] = "minPumpEfficiency";

var WellDesign_Labels = new Array();
WellDesign_Labels[0] = "产液量（m3/d）";
WellDesign_Labels[1] = "含水率(小数)";
WellDesign_Labels[2] = "最低产液量（m3/d）";
WellDesign_Labels[3] = "最低泵效(小数)";

function editWellDesginParameter(wellId, wellDesginParameter) {
	if ($("#WellDesignParams").length <= 0) {
		buildModalWindow("WellDesignParams", "#other-modal-window",
				WellDesign_Parameters, wellDesginParameter == undefined ? null
						: wellDesginParameter, WellDesign_Labels,
				"updateDesginParameter(" + wellId + ")");

	}
	$("#WellDesignParams").modal('show');
}

function updateDesginParameter(wellId) {
	$.post("well/" + wellId + "/updateDesignParameter", {
		"producedFluidVolume" : $("#producedFluidVolume").val(),
		"moistureRatio" : $("#moistureRatio").val(),
		"minProducedFluidVolume" : $("#minProducedFluidVolume").val(),
		"minPumpEfficiency" : $("#minPumpEfficiency").val(),
	}, function(data) {
		if (data != null) {
			information(data == true ? "succes" : "fail");
		}
	}, "json").error(function() {
		information($.i18n.prop('failed-connect-server'));
	});
}
