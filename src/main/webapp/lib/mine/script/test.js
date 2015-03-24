var pageReady = function() {
	var table = $("#table1").DataTable();
	table.row.add([ 3, 4 ]).draw().node();
}
$(document).ready(pageReady);