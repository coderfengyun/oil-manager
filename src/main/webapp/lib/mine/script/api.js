function WellBaseData_API() {
};

WellBaseData_API.prototype = function() {
			load = function(CallBack) {
				$
						.get("well/", {}, function(data) {
							CallBack(data);
						}, "json")
						.error(
								function() {
									information("There is something wrong when get all the well base data!")
								});
			},

			add = function(CallBack) {
				$.post("well/insertWellBaseData", {
					"wellDepth" : $("#wellDepth").val(),
					"casingOutterDiameter" : $("#casingOutterDiameter").val(),
					"casingInnerDiameter" : $("#casingInnerDiameter").val(),
					"reservoirTemperature" : $("#reservoirTemperature").val(),
					"tubingOutterDiameter" : $("#tubingOutterDiameter").val(),
					"tubingInnerDiameter" : $("#tubingInnerDiameter").val(),
				}, function(data) {
					CallBack(data);
				}, "json").error(function() {
					information($.i18n.prop('failed-connect-server'));
				});
			},

			deleteW = function(id) {
				$.ajax({
					url : 'well/' + id,
					type : 'DELETE',
					data : {},
					success : function(data) {
						CallBack(data);
					},
					error : function() {
						information("Connect Server ERROR");
					}
				});
			}

	return {
		load : load,
		add : add,
		deleteW : deleteW
	}
}();

function PreferredPlan_API() {
};

PreferredPlan_API.prototype = function() {
	load = function(wellId, CallBack) {
		$.ajax({
			url : wellId + "/preferredPlan/",
			type : 'GET',
			data : {},
			dataType : 'json',
			success : function(data) {
				CallBack(data);
			},
			error : function() {
				information($.i18n.prop('failed-connect-server'));
			}
		});
	},

	add = function(wellId, paramNameValueMap, CallBack) {
		$.ajax({
			url : wellId + "/preferredPlan/",
			type : 'PUT',
			data : {
				"pumpDepth" : paramNameValueMap["pumpDepth"],
				"systemEffeciency" : paramNameValueMap["systemEffeciency"],
				"production" : paramNameValueMap["production"],
				"econemicBenifits" : paramNameValueMap["econemicBenifits"],
				"utilization" : paramNameValueMap["utilization"],
				"pumpEffeciency" : paramNameValueMap["pumpEffeciency"],
			},
			dataType : 'json',
			success : function(response) {
				CallBack(paramNameValueMap, response);
			},
			error : function() {
				information($.i18n.prop('failed-connect-server'));
			}
		});
	},

	calculate = function(wellId, CallBack) {
		$.ajax({
			url : wellId + "/preferredPlan/score",
			type : 'GET',
			data : {},
			dataType : 'json',
			success : function(data) {
				CallBack(data);
			}
		});
	}

	return {
		load : load,
		add : add,
		calculate : calculate
	};
}();

function PressureDistribution_API() {
}

PressureDistribution_API.prototype = function() {
	load = function(wellId, CallBack) {
		$.get(wellId + "/pressureDistribution/", {}, function(data) {
			CallBack(data);
		}, "json").error(function() {
			information($.i18n.prop('failed-connect-server'));
		});
	}

	add = function(wellId, paramNameValueMap, CallBack) {
		$.ajax({
			url : wellId + "/pressureDistribution/",
			type : 'PUT',
			data : {
				"pumpDepth" : paramNameValueMap["pumpDepth"],
				"sinkingPressure" : paramNameValueMap["sinkingPressure"],
				"fulfillCoefficient" : paramNameValueMap["fulfillCoefficient"],
			},
			dataType : 'json',
			success : function(response) {
				CallBack([ paramNameValueMap["pumpDepth"],
						paramNameValueMap["sinkingPressure"],
						paramNameValueMap["fulfillCoefficient"] ], response);
			},
			error : function() {
				information($.i18n.prop('failed-connect-server'));
			}
		});
	}

	return {
		load : load,
		add : add
	};
}();

function WellInflowTrend_API() {
}

WellInflowTrend_API.prototype = function() {
			add = function(wellId, paramNameValueMap, CallBack) {
				$
						.ajax({
							url : wellId + "/inflowTrend/",
							type : 'PUT',
							data : {
								"producedFluidVolume" : paramNameValueMap["producedFluidVolume"],
								"wellBotomFlowPressure" : paramNameValueMap["wellBotomFlowPressure"],
							},
							dataType : 'json',
							success : function(response) {
								CallBack(response);
							},
							error : function() {
								information($.i18n
										.prop('failed-connect-server'));
							}
						});
			},

			get = function(wellId, CallBack) {
				$.get(wellId + "/inflowTrend/", {}, function(data) {
					CallBack(data);
				}, "json").error(function() {
					information($.i18n.prop('failed-connect-server'));
				});
			}
	return {
		add : add,
		get : get
	};
}();