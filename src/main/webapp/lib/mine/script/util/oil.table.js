function OilTable() {
}

OilTable.prototype = function() {
	appendRowToTable = function(table, data) {
		var targetIndex = table.rows().indexes().length;
		data.splice(0, 0, targetIndex + 1);
		return table.row.add(data).draw().node();
	}
	return {
		appendRowToTable : appendRowToTable
	};
}();