$(document).ready(function() {
	var table = $('#wellBaseDataTable').DataTable();
	var tbody = table.table().body();
	$(tbody).on('click', 'td a.delete', function(e) {
		e.preventDefault();
		var row = $(this).closest("tr");
		var id = $(row).attr("id");
		row = table.row(row);
		if (confirm($.i18n.prop("sure_to_delete_this_well_base_data"))) {
			deleteWellBaseData(id, row);
		}
	});
	loadWellBaseDatas(table);
});
var currentSelectWellId = -1;
var wellDataList = new Array();
function get(id) {
	return wellDataList[id];
};
function put(id, instance) {
	wellDataList[id] = instance;
};

$('.btn-add').click(function(e) {
	$("#WellBaseDataParams").modal('show');
});
changeHref = function(source) {
	currentSelectWellId = $(source).closest("tr").attr("id");
	new UrlParamParser().setParamForUri('wellId', currentSelectWellId);
};
function submitWellBaseData() {
	var table = $('#wellBaseDataTable');
	$.post("well/insertWellBaseData", {
		"wellDepth" : $("#wellDepth").val(),
		"casingOutterDiameter" : $("#casingOutterDiameter").val(),
		"casingInnerDiameter" : $("#casingInnerDiameter").val(),
		"reservoirTemperature" : $("#reservoirTemperature").val(),
		"tubingOutterDiameter" : $("#tubingOutterDiameter").val(),
		"tubingInnerDiameter" : $("#tubingInnerDiameter").val(),
	}, function(data) {
		if (data != null) {
			if (data == true) {
				loadWellBaseDatas(table.DataTable());
				information("Success!");
			} else {
				informatin("insert fails!")
			}
		} else {
			information(data.failedMessage);
		}
	}, "json").error(function() {
		information($.i18n.prop('failed-connect-server'));
	});
};

function loadWellBaseDatas(table) {
	var jsInstance = this;
	// table.fnClearTable();
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
			+ "指标权重分配-IndicatorWeightDistribution" + "</option></select>";
	$
			.get(
					"well/",
					{},
					function(data) {
						if (data != null) {
							for (var i = 0; i < data.length; i++) {
								var wellBaseData = data[i];
								var tr = table.row
										.add(
												[
														checkbox,
														wellBaseData.wellDepth,
														wellBaseData.casingOutterDiameter,
														wellBaseData.casingInnerDiameter,
														wellBaseData.reservoirTemperature,
														wellBaseData.tubingOutterDiameter,
														wellBaseData.tubingInnerDiameter,
														allowedOperations ])
										.draw().node();
								$(tr).attr("id", wellBaseData.id);
								put(wellBaseData.id, wellBaseData);
							}
						} else {
							information("data is null!")
						}
					}, "json")
			.error(
					function() {
						information("There is something wrong when get all the well base data!")
					});
};

function onSelectChange(select) {
	var tr = select.closest("tr");
	var id = $(tr).attr("id");
	var wellData = get(id);
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
	case "WellInflowTrend":
		viewWellInflowTrend(id);
		break;
	}
	select.options[0].selected = true;
};
function deleteWellBaseData(id, row) {
};

viewWellInflowTrend = function(wellId) {
	window.open("wellInflowTrend.jsp?wellId=" + wellId, "油井流入动态->产能预测",
			'menubar=yes,resizable=yes,titlebar=yes,toolbar=yes');
}
