UrlParamParser.prototype = function() {
	/**
	 * if there's no parameters in current url, then return undefined;
	 * 
	 * else if there's parameter's name without parameter's value, return null;
	 * 
	 * else return the parameter's value
	 */

	getParamFromUri = function(name) {
		var uriParamPart = window.location.search;
		if (uriParamPart.length < 1) {
			return undefined;
		}
		var result = uriParamPart.substring(1).match(_buildRegexExp(name));
		if (result != null) {
			return result[2];
		} else {
			return null;
		}
	},

	_buildRegexExp = function(name) {
		return new RegExp(_buildRegexContent(name), "i");
	},

	_buildRegexContent = function(name) {
		return "(^|&)" + name + "=([^&]*)(&|$)";
	},

	setParamForUri = function(name, value) {
		var query = window.location.search;
		var originValue = getParamFromUri(name);
		var result = '';
		if (originValue == undefined) {
			// no parameter in url
			query += '?' + name + '=' + value;
		} else if (originValue == null) {
			// has that parameter without value
			query += '?' + name + '=' + value;
		} else {
			query = '?'
					+ query.substring(1).replace(_buildRegexExp(name),
							name + '=' + value);
		}
		if (location.href.indexOf('?') > -1) {
			result = location.href.substring(0, location.href.indexOf('?'));
		}
		location.href = result + query;
	}
	return {
		getParamFromUri : getParamFromUri,
		setParamForUri : setParamForUri
	};
}();

function UrlParamParser() {
}