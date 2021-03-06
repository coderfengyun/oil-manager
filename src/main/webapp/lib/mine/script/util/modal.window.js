function ModalWindowHelper() {
}

ModalWindowHelper.prototype = function() {

	showWith = function(divId, parentDiv, paramNameList, paramValueMap,
			paramLabels, onSubmitMethodString) {
		if ($('#' + divId).length <= 0) {
			buildModalWindow(divId, parentDiv, paramNameList, paramValueMap,
					paramLabels, onSubmitMethodString);
		}
		$('#' + divId).modal('show');
	}

	return {
		showWith : showWith
	};
}();

function buildModalWindow(divId, parentDiv, paramNameList, paramValueMap,
		paramLabels, onSubmitMethodString) {
	var modalDiaglog = '<div class="modal fade" id="' + divId
			+ '"><div class="modal-dialog"><div class="modal-content">';
	for (var i = 0; i < paramNameList.length; i++) {
		var paramName = paramNameList[i];
		var paramLabel = paramLabels[i];
		modalDiaglog += '<div class="control-group"><label class="control-label" for="focusedInput">'
				+ paramLabel + '</label>';
		modalDiaglog += '<div class="controls"><input class="input-xlarge focused" id='
				+ buildDoubleQuoteVal(paramName)
				+ ' type="text" value="'
				+ (paramValueMap != null ? paramValueMap[paramName] : "")
				+ '"><div id='
				+ buildDoubleQuoteVal(paramName + "-error")
				+ ' style="display: none;color: red"></div></div>';
		modalDiaglog += '</div>';
	}
	modalDiaglog += '</div>';
	modalDiaglog += '<div class="modal-footer"><button type="button" class="btn btn-primary" data-dismiss="modal" onClick="'
			+ onSubmitMethodString
			+ '">提交</button><button type="button" class="btn btn-primary" data-dismiss="modal">取消</button></div>';
	modalDiaglog += '</div></div>'
	$(parentDiv).append(modalDiaglog);
}

function buildDoubleQuoteVal(insideVal) {
	return '"' + insideVal + '"';
}