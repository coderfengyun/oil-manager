WellInflowTrend.prototype = function() {
	var wellId = -1;
	var trendIdValueMap = new Array();
	var paramWindowName = "WellInflowTrendParameters";
	var tableName = "wellInflowTrendTable";
	var paramNameList = new Array();
	var paramLabelList = new Array();
	paramNameList[0] = "producedFluidVolume";
	paramNameList[1] = "wellBotomFlowPressure";
	paramLabelList[0] = "产液量(t\d)";
	paramLabelList[1] = "井底流压(MPa)";

	get = function(id) {
		return this.trendIdValueMap[id];
	},

	put = function(id, data) {
		this.trendIdValueMap[id] = data;
	},

	loadWellInflowTrend = function(wellId, table) {
		var operations = null;
		$.get(
				"/" + wellId + "/inflowTrend/",
				{},
				function(data) {
					if (data == null) {
						information("Get Inflow Trend Fails!")
					} else {
						for (var i = 0; i < data.length; i++) {
							var inflowTrend = data[i];
							var tr = table.row.add(
									[ , i + 1, inflowTrend.producedFluidVolume,
											inflowTrend.wellBotomFlowPressure,
											operations ]).draw().node();
							$(tr).attr("id", inflowTrend.id);
						}
					}
				}, "json").error(function() {
			information($.i18n.prop('failed-connect-server'));
		});
	},

	getWellIdFromUri = function(name) {
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
		loadWellInflowTrend : loadWellInflowTrend,
		getWellIdFromUri : getWellIdFromUri,
		paramNameList : paramNameList,
		paramLabelList : paramLabelList,
		trendIdValueMap : trendIdValueMap,
		wellId : wellId,
		paramWindowName : paramWindowName
	};
}();

function WellInflowTrend() {
	var modalWindowDiv = '<div id="modal-windows"></div>'
	$(document.body).append(modalWindowDiv);
}

var WellInflowTrend_Instance = new WellInflowTrend();

$(document).ready(
		function() {
			var table = $("#wellInflowTrendTable").DataTable();
			var tbody = table.table().body();
			$(tbody).on(
					'click',
					'td a.delete',
					function(e) {
						e.preventDefault();
						var row = $(this).closest("tr");
						var id = $(row).attr("id");
						row = table.row(row);
						if (confirm($.i18n
								.prop("sure_to_delete_this_well_base_data"))) {
							deleteWellBaseData(id, row);
						}
					});

			WellInflowTrend_Instance.wellId = WellInflowTrend_Instance
					.getWellIdFromUri("wellId");
			WellInflowTrend_Instance.loadWellInflowTrend(
					WellInflowTrend_Instance.wellId, table);
		});

$("#" + WellInflowTrend_Instance.tableName).dataTable(
		{
			"language" : {
				"search" : $.i18n.prop('dataTable.search'),
				"lengthMenu" : "_MENU_"
						+ $.i18n.prop('dataTable.number_per_page'),
				"emptyTable" : $.i18n.prop('dataTable.no_data_in_table'),
				"info" : "_START_" + $.i18n.prop('dataTable.to') + "_END_"
						+ $.i18n.prop('dataTable.total') + "_TOTAL_"
						+ $.i18n.prop('dataTable.record'),
				"paginate" : {
					"previous" : $.i18n.prop('dataTable.previous-page'),
					"next" : $.i18n.prop('dataTable.next-page'),
				},
				"infoEmpty" : $.i18n.prop('no-entries'),
			}
		});

addAWellInflowTrend = function(wellId) {
	$.ajax({
		url : "/" + wellId + "/inflowTrend/",
		type : 'PUT',
		data : {
			"wellId" : wellId,
			"producedFluidVolume" : $("#producedFluidVolume").val(),
			"wellBotomFlowPressure" : $("#wellBotomFlowPressure").val(),
		},
		dataType : 'json',
		success : function(response) {
			if (response == null || response == false) {
				information("Add WellInflowTrend Fails!");
			} else {
				information("Success!");
			}
		},
		error : function() {
			information($.i18n.prop('failed-connect-server'));
		}
	});
}

$('.btn-setting').click(
		function(e) {
			e.preventDefault();
			if ($("#" + WellInflowTrend_Instance.paramWindowName).length <= 0) {
				buildModalWindow(WellInflowTrend_Instance.paramWindowName,
						"#modal-windows",
						WellInflowTrend_Instance.paramNameList, null,
						WellInflowTrend_Instance.paramLabelList,
						"addAWellInflowTrend("
								+ WellInflowTrend_Instance.wellId + ")");
			}
			$("#" + WellInflowTrend_Instance.paramWindowName).modal('show');
		});