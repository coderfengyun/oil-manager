$(".oil-navigate-button").click(
		function(e) {
			var target = e.target || e.srcElement;
			target.href = target.href + '?wellId='
					+ new UrlParamParser().getParamFromUri('wellId');
		});