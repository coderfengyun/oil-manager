UrlParamParser.prototype = function() {
	getParamFromUri = function(name) {
		var regex = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var uriParamPart = window.location.search;
		if (uriParamPart.length < 1) {
			return null;
		}
		var result = uriParamPart.substring(1).match(regex);
		if (result != null) {
			return result[2];
		} else {
			return null;
		}
	};
	return {
		getParamFromUri : getParamFromUri
	};
}();

function UrlParamParser() {
}