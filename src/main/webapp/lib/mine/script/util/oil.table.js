function getRow(obj) {
	return obj.parentNode.parentNode;
}
function getTbody(obj) {
	return getRow(obj).parentNode;
}
function getTable(obj) {
	return getTbody(obj).parentNode;
}
function getColumn(obj, columnIndex) {
	var row = getRow(obj);
	var tbody = getTbody(obj);
	var value = $(tbody).children("tr").eq(row.rowIndex - 1).children("td").eq(
			columnIndex).text();
	return value;
}
function extractRowData(data, tableModel, actionButton) {
	var dataArray = new Array();
	dataArray = getRowData(data, tableModel, dataArray);
	if (actionButton != null)
		dataArray.push(actionButton);
	return dataArray;
}
function extractRowDataActionBefore(data, tableModel, actionButton) {
	var dataArray = new Array();
	if (actionButton != null) {
	}
	dataArray.push(actionButton);
	dataArray = getRowData(data, tableModel, dataArray);
	return dataArray;
}
function getRowData(data, tableModel, dataArray) {
	for (var i = 0; i < tableModel.length; i++) {
		for ( var key in data) {
			if (key == tableModel[i]) {
				dataArray.push(formatToData(key, data[key]));
			}

		}
	}
	return dataArray;
}

// this need to change
function formatToData(key, data) {
	if (key.indexOf("DateTime") >= 0) {
		var time = new Date(data);
		time.setTime(data);
		return time;
	} else
		return data;
}