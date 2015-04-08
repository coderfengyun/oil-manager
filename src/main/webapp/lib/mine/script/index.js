function WellBaseData_Page() {
};
WellBaseData_Page.prototype = function() {
	var WellBaseData_Params = new Array();
	WellBaseData_Params[0] = "wellDepth";
	WellBaseData_Params[1] = "casingOutterDiameter";
	WellBaseData_Params[2] = "casingInnerDiameter";
	WellBaseData_Params[3] = "reservoirTemperature";
	WellBaseData_Params[4] = "tubingOutterDiameter";
	WellBaseData_Params[5] = "tubingInnerDiameter";

	var WellBaseData_Labels = new Array();
	WellBaseData_Labels[0] = "井深(单位:米)";
	WellBaseData_Labels[1] = "套管外径(单位:毫米)";
	WellBaseData_Labels[2] = "套管内径(单位:毫米)";
	WellBaseData_Labels[3] = "油层温度(单位:摄氏度)";
	WellBaseData_Labels[4] = "油管外径(单位:毫米)";
	WellBaseData_Labels[5] = "油管内径(单位:毫米)";
	var currentSelectWellId = -1;
	var table = $('#wellBaseDataTable').DataTable();
	var wellBaseData_API = new WellBaseData_API();
	var wellDataList = new Array();
			get = function(id) {
				return wellDataList[id];
			},
			put = function(id, instance) {
				wellDataList[id] = instance;
			},
			showParamWindowWith = function(paramNameValueMap) {
				var modalWindowHelper = new ModalWindowHelper();
				modalWindowHelper.showWith('WellBaseDataParams', "body",
						WellBaseData_Params, paramNameValueMap,
						WellBaseData_Labels, "addWellBaseData()");
			},
			loadWellBaseDatas = function() {
				wellBaseData_API.load(loadWellBaseDataCallBack);
			},
			loadWellBaseDataCallBack = function(data) {
				var checkbox = "<input class='check' onclick='changeHref(this)' type='checkbox'>";
				var allowedOperations = "<select class='selectpicker'onchange='onSelectChange(this)'><option>operations</option><option value=WellProductData>"
						+ "当前油井生产数据-WellProductData"
						+ "</option><option value=FluidPhysicalParameter>"
						+ "流体物性参数-FluidPhysicalParameter"
						+ "</option><option value=WellDesignParameter>"
						+ "油井设计工作参数-WellDesignParameter"
						+ "</option><option value=RodStringDesignParameter>"
						+ "抽油杆柱设计工作参数-RodStringDesignParameter"
						+ "</option><option value=RodStructureParameter>"
						+ "抽油杆结构参数-RodStructureParameter"
						+ "</option><option value=IndicatorWeightDistribution>"
						+ "指标权重分配-IndicatorWeightDistribution"
						+ "</option></select>";
				if (data != null) {
					for (var i = 0; i < data.length; i++) {
						var wellBaseData = data[i];
						var tr = table.row.add(
								[ checkbox, wellBaseData.wellDepth,
										wellBaseData.casingOutterDiameter,
										wellBaseData.casingInnerDiameter,
										wellBaseData.reservoirTemperature,
										wellBaseData.tubingOutterDiameter,
										wellBaseData.tubingInnerDiameter,
										allowedOperations ]).draw().node();
						$(tr).attr("id", wellBaseData.id);
						put(wellBaseData.id, wellBaseData);
					}
				} else {
					information("data is null!")
				}
			},

			addWellBaseData = function() {
				wellBaseData_API.add(_addWellDataCallBack);
			},

			_addWellDataCallBack = function(data) {
				if (data != null) {
					if (data == true) {
						information("Success!");
					} else {
						informatin("insert fails!")
					}
				} else {
					information(data.failedMessage);
				}
			},

			deleteWellBaseData = function(id) {
				wellBaseData_API.deleteW(id, _deleteWellBaseDataCallBack);
			},

			_deleteWellBaseDataCallBack = function(data) {
				if (data == null || data == undefined || data == false) {
					information("connect server error!");
				} else {
					information("Sucess");
				}
			}
	return {
		showParamWindowWith : showParamWindowWith,
		loadWellBaseDatas : loadWellBaseDatas,
		deleteWellBaseData : deleteWellBaseData,
		currentSelectWellId : currentSelectWellId
	};
}();

var WellBaseData_Instance = new WellBaseData_Page();

$(document).ready(function() {
	WellBaseData_Instance.loadWellBaseDatas();
});
$('.btn-add').click(function(e) {
	WellBaseData_Instance.showParamWindowWith(null);
});
$('.btn-delete').click(function(e) {
	var wellId = new UrlParamParser().getParamFromUri('wellId');
	if (wellId == undefined || wellId == null) {
		information("并未选中要删除行！");
	} else {
		deleteWellBaseData(wellId);
	}
});

changeHref = function(source) {
	WellBaseData_Instance.currentSelectWellId = $(source).closest("tr").attr(
			"id");
	 new UrlParamParser().setParamForUri('wellId',
			WellBaseData_Instance.currentSelectWellId);
};

onSelectChange = function(select) {
	var tr = select.closest("tr");
	var id = $(tr).attr("id");
	var wellData = WellBaseData_Instance.get(id);
	switch (select.value) {
	case "WellBaseData":
		editWellBaseData();
		break;
	case "WellProductData":
		editWellProductData(id, wellData.wellProductData);
		break;
	case "FluidPhysicalParameter":
		editFluidPhysicalParameter(id, wellData.fluidPhysicalParameter);
		break;
	case "WellDesignParameter":
		editWellDesginParameter(id, wellData.wellDesignParameter);
		break;
	case "RodStringDesignParameter":
		editRodStringDesignParameter(id, wellData.rodStringDesignParameter);
		break;
	case "RodStructureParameter":
		editRodStructureParameter(id, wellData.rodStructureParameter);
		break;
	case "IndicatorWeightDistribution":
		editIndicatorWeightDistribution(id,
				wellData.indicatorWeightDistribution);
		break;
	}
	select.options[0].selected = true;
};