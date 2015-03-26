function OilTable() {
}

OilTable.prototype = function() {
	appendRowToTable = function(table, data) {
		var targetIndex = table.rows().indexes().length;
		data.splice(-1, 0, targetIndex + 1);
		table.row.add(data).draw();
	}
	return {
		appendRowToTable : appendRowToTable
	};
}();