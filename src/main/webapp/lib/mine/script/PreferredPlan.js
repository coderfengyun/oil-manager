function PreferredPlan() {
}

PreferredPlan.prototype = function() {
	var baseTable = $("#preferredPlanBaseTable").DataTable();
	var resultTable = $("#preferredPlanBaseTable").DataTable();
	var urlParamParser = new UrlParamParser();
	var wellId = urlParamParser.getParamFromUri('wellId');
	var oilTableHelper = new OilTable();
	var FluidPhysica_Parameters = new Array();
	FluidPhysica_Parameters[0] = "pumpDepth";
	FluidPhysica_Parameters[1] = "systemEffeciency";
	FluidPhysica_Parameters[2] = "production";
	FluidPhysica_Parameters[3] = "econemicBenifits";
	FluidPhysica_Parameters[4] = "utilization";
	FluidPhysica_Parameters[5] = "pumpEffeciency";

	var FluidPhysical_Label = new Array();
	FluidPhysical_Label[0] = "泵深(m)";
	FluidPhysical_Label[1] = "系统效率";
	FluidPhysical_Label[2] = "产量(m^3/d)";
	FluidPhysical_Label[3] = "经济效益";
	FluidPhysical_Label[4] = "利用率";
	FluidPhysical_Label[5] = "泵效(%)";

	appendRowToTable = function(data) {
		oilTableHelper.appendRowToTable(baseTable, data);
	},
	loadAll = function(){
		
	},
	_addAPreferredPlan = function(data) {
		$.ajax({
			url: wellId + "/preferredPlan/",
			type: 'PUT',
			data:{
				"pumpDepth": data["pumpDepth"],
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
					appendRowToTable(data);
					information("Success!");
				}
			},error : function() {
				information($.i18n.prop('failed-connect-server'));
			}
		});
	},
	editPreferredPlanParams=function(fluidPhysicalParameter) {
		var windowName = "preferredPlanBaseModal";
		if ($(windowName).length <= 0) {
			buildModalWindow(windowName, "body",
					FluidPhysica_Parameters,
					fluidPhysicalParameter == undefined ? null
							: fluidPhysicalParameter, FluidPhysical_Label,
					"updatePreferredPlanBaseModal()");

		}
		$("#preferredPlanBaseModal").modal('show');
	},
	
	_getValByDomId=function(id){
		return $("#" + id).val();
	},
	updatePreferredPlanBaseModal = function(){
		var data = new Array();
		for(var i = 0; i < FluidPhysica_Parameters.length; i++){
			data[FluidPhysica_Parameters[i]] = _getValByDomId(FluidPhysica_Parameters[i]);
		}
		_addAPreferredPlan(data);
	}
	return {
		appendRowToTable , appendRowToTable,
		editPreferredPlanParams, editPreferredPlanParams,
		loadAll,loadAll
		};
}();

var PreferredPlan_Instance = new PreferredPlan();

$(".btn-add").click(function(e) {
	PreferredPlan_Instance.editPreferredPlanParams(null);
});
$(document).ready(function() {
	PreferredPlan_Instance.loadAll();
});
