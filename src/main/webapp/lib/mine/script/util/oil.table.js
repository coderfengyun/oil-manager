function OilTable() {
}

OilTable.prototype = function() {
			appendRowToTable = function(table, data) {
				var targetIndex = table.rows().indexes().length;
				data.splice(0, 0, targetIndex + 1);
				return table.row.add(data).draw().node();
			},

			init = function() {
				$("#" + this.tableName)
						.dataTable(
								{
									"language" : {
										"search" : $.i18n
												.prop('dataTable.search'),
										"lengthMenu" : "_MENU_"
												+ $.i18n
														.prop('dataTable.number_per_page'),
										"emptyTable" : $.i18n
												.prop('dataTable.no_data_in_table'),
										"info" : "_START_"
												+ $.i18n.prop('dataTable.to')
												+ "_END_"
												+ $.i18n
														.prop('dataTable.total')
												+ "_TOTAL_"
												+ $.i18n
														.prop('dataTable.record'),
										"paginate" : {
											"previous" : $.i18n
													.prop('dataTable.previous-page'),
											"next" : $.i18n
													.prop('dataTable.next-page'),
										},
										"infoEmpty" : $.i18n.prop('no-entries'),
									}
								});
			}

	return {
		appendRowToTable : appendRowToTable,
		init : init
	};
}();