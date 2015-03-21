var WellDesign_Parameters = new Array();
WellDesign_Parameters[0] = "producedFluidVolume";
WellDesign_Parameters[1] = "moistureRatio";
WellDesign_Parameters[2] = "minProducedFluidVolume";
WellDesign_Parameters[3] = "minPumpEfficiency";

function editWellDesginParameter(wellId, wellDesginParameter) {
	if ($("#WellDesignParams").length <= 0) {
		buildModalWindow("WellDesignParams", "#other-modal-window", wellId,
				WellDesign_Parameters, wellDesginParameter == undefined ? null
						: wellDesginParameter, "updateDesginParameter("
						+ wellId + ")");

	}
	$("#WellDesignParams").modal('show');
}

function updateDesginParameter(wellId) {
	$.post("/well/" + wellId + "/updateDesignParameter", {
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
