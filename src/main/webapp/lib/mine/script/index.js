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

$("#wellBaseDataTable").dataTable(
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

$('.btn-setting').click(function(e) {
	e.preventDefault();
	$("#WellBaseDataParams").modal('show');
});

function submitWellBaseData() {
	var table = $('#wellBaseDataTable');
	$.post("insertWellBaseData", {
		"wellDepth" : $("#wellDepth").val(),
		"casingOutterDiameter" : $("#casingOutterDiameter").val(),
		"casingInnerDiameter" : $("#casingInnerDiameter").val(),
		"reservoirTemperature" : $("#reservoirTemperature").val(),
		"tubingOutterDiameter" : $("#tubingOutterDiameter").val(),
		"tubingInnerDiameter" : $("#tubingInnerDiameter").val(),
	}, function(data) {
		if (data.success) {
			loadWellBaseDatas(table.DataTable());
		} else {
			information(data.failedMessage);
		}
	}, "json").error(function() {
		information($.i18n.prop('failed-connect-server'));
	});
}
function loadWellBaseDatas(table) {
	$
			.post(
					"queryAllWellBaseData",
					{},
					function(data) {
						if (data != null) {
							for (var i = 0; i < data.length; i++) {
								var wellBaseData = data[i];
								var tr = table.row
										.add(
												[
														,
														wellBaseData.wellDepth,
														wellBaseData.casingOutterDiameter,
														wellBaseData.casingInnerDiameter,
														wellBaseData.reservoirTemperature,
														wellBaseData.tubingOutterDiameter,
														wellBaseData.tubingInnerDiameter ])
										.draw().node();
								$(tr).attr("id", wellBaseData.id);
							}
						} else {
							information("data is null!")
						}
					}, "json")
			.error(
					function() {
						information("There is something wrong when get all the well base data!")
					});
}

function deleteWellBaseData(id, row) {
}