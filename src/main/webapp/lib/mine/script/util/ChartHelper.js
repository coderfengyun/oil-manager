function ChartHelper() {
}
ChartHelper.prototype = function() {
	buildOptions = function(chartDivId) {
		var options = {
			chart : {
				renderTo : chartDivId,
				defaultSeriesType : 'line',
			},
			plotOptions : {
				series : {
					fillOpacity : 0.85,
					color : '#369bd7'
				}
			},
			credits : {
				enabled : false
			},
			legend : {
				enabled : false
			},
			title : {
				text : "Value",
				align : "center",
				style : {
					fontSize : '13px',
					fontWeight : "bold",
				},
				margin : 20,
			},
			xAxis : {
				plotLines : [ {
					width : 20,
					color : '#808080'
				} ],
				min : 0,
				title : {
					text : "X",
					style : {
						fontSize : '13px',
						fontWeight : "bold",
					},
				},
				gridLineWidth : 1,
			},
			yAxis : {
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ],
				title : {
					text : "Y",
					style : {
						fontSize : '13px',
						fontWeight : "bold",
					},
				},
				min : 0,
				gridLineWidth : 1,
			},
			tooltip : {
				formatter : function() {
					var formatStr = '<b>' + this.y + "A" + this.x + "B";
					return formatStr;
				}
			},
			series : [ {
				id : 'default-serie',
				data : []
			} ]
		};
		return options;
	}
	return {
		buildOptions : buildOptions
	}
}();
