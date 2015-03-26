function information(text) {
	noty({
		text : text,
		type : 'information',
		layout : 'center',
		maxVisible : 1
	});
	setTimeout("document.body.removeChild(noty_center_layout_container)", 2000);
}
