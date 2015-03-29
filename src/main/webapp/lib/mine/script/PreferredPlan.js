function PreferredPlan() {
}

PreferredPlan.prototype = function() {
	var baseTable = $("#preferredPlanBaseTable").DataTable();
	var resultTable = $("#preferredPlanScoreTable").DataTable();
	var urlParamParser = new UrlParamParser();
	var wellId = urlParamParser.getParamFromUri('wellId');
	var oilTableHelper = new OilTable();
	var PreferredPlan_Parameters = new Array();
	PreferredPlan_Parameters[0] = "pumpDepth";
	PreferredPlan_Parameters[1] = "systemEffeciency";
	PreferredPlan_Parameters[2] = "production";
	PreferredPlan_Parameters[3] = "econemicBenifits";
	PreferredPlan_Parameters[4] = "utilization";
	PreferredPlan_Parameters[5] = "pumpEffeciency";

	var PreferredPlanl_Label = new Array();
	PreferredPlanl_Label[0] = "泵深(m)";
	PreferredPlanl_Label[1] = "系统效率";
	PreferredPlanl_Label[2] = "产量(m^3/d)";
	PreferredPlanl_Label[3] = "经济效益";
	PreferredPlanl_Label[4] = "利用率";
	PreferredPlanl_Label[5] = "泵效(%)";

	var Score_Parameters = new Array();
	Score_Parameters[0] = "pumpDepth";
	Score_Parameters[1] = "score";

	var Score_Labels = new Array();
	Score_Labels[0] = "泵深(m)";
	Score_Labels[1] = "评分";

			_appendRowToTable = function(data) {
				oilTableHelper.appendRowToTable(baseTable,
						_convert2TableData(data));
			},
			_convert2TableData = function(data) {
				return [ data["pumpDepth"], data["pumpEffeciency"],
						data["systemEffeciency"], data["production"],
						data["econemicBenifits"], data["utilization"] ];
			},
			loadAll = function() {
				$.ajax({
					url : wellId + "/preferredPlan/",
					type : 'GET',
					data : {},
					dataType : 'json',
					success : function(data) {
						if (data == null) {
							information("Get Pressure Distribution Fails!");
						} else {
							for (var i = 0; i < data.length; i++) {
								var preferredPlan = data[i];
								var tr = _appendRowToTable(preferredPlan);
								$(tr).attr("id", preferredPlan.id);
							}
						}
					},
					error : function() {
						information($.i18n.prop('failed-connect-server'));
					}
				});
			},
			_addAPreferredPlan = function(data) {
				$.ajax({
					url : wellId + "/preferredPlan/",
					type : 'PUT',
					data : {
						"pumpDepth" : data["pumpDepth"],
						"systemEffeciency" : data["systemEffeciency"],
						"production" : data["production"],
						"econemicBenifits" : data["econemicBenifits"],
						"utilization" : data["utilization"],
						"pumpEffeciency" : data["pumpEffeciency"],
					},
					dataType : 'json',
					success : function(response) {
						if (response == null || response == false) {
							information("Add WellInflowTrend Fails!");
						} else {
							_appendRowToTable(data);
							information("Success!");
						}
					},
					error : function() {
						information($.i18n.prop('failed-connect-server'));
					}
				});
			},
			editPreferredPlanParams = function(PreferredPlanlParameter) {
				var windowName = "preferredPlanBaseModal";
				if ($(windowName).length <= 0) {
					buildModalWindow(windowName, "body",
							PreferredPlan_Parameters,
							PreferredPlanlParameter == undefined ? null
									: PreferredPlanlParameter,
							PreferredPlanl_Label,
							"updatePreferredPlanBaseModal()");

				}
				$("#preferredPlanBaseModal").modal('show');
			},
			_getValByDomId = function(id) {
				return $("#" + id).val();
			},
			updatePreferredPlanBaseModal = function() {
				var data = new Array();
				for (var i = 0; i < PreferredPlan_Parameters.length; i++) {
					data[PreferredPlan_Parameters[i]] = _getValByDomId(PreferredPlan_Parameters[i]);
				}
				_addAPreferredPlan(data);
			},

			_addScoreToTabl = function(data) {
				oilTableHelper.appendRowToTable(resultTable, [
						data[Score_Parameters[0]], data[Score_Parameters[1]] ]);
			},

			calculate = function() {
				$.ajax({
					url : wellId + "/preferredPlan/score",
					type : 'GET',
					data : {},
					dataType : 'json',
					success : function(data) {
						if (data == undefined || data == null) {
							information("preferredPlan score fails!")
						} else {
							for (var i = 0; i < data.length; i++) {
								_addScoreToTabl(data[i]);
							}
						}
					}
				});
			}
	return {
		editPreferredPlanParams : editPreferredPlanParams,
		loadAll : loadAll,
		calculate : calculate
	};
}();

var PreferredPlan_Instance = new PreferredPlan();

$(".btn-add").click(function(e) {
	PreferredPlan_Instance.editPreferredPlanParams(null);
});
$(".btn-calculate").click(function(e) {
	PreferredPlan_Instance.calculate();
});
$(document).ready(function() {
	PreferredPlan_Instance.loadAll();
});
