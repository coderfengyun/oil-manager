function createRadioGroup(items,name,containerId){
	for ( var i = 0; i < items.length; i++) {
		var radio = createRadio(items[i],items[i],name,items[i]);
		$("#" + containerId).append(radio);
	}
}

/**
 * @param id synchronize the radio, label and div
 * @param text show in the web
 * @param name this is same in a radio group
 * @param value 
 * @returns 
 */
function createRadio (id,text,name,value) {
	var line = $("<div style='cursor:pointer;' name='"+name+"'>");
	if(text=="Controller"||text=="DataGenerator"||text=="DataSender")
		text=$.i18n.prop(text);
	line.click(function(){
		document.getElementById(id).checked = true;
	})
	var input = $("<input type='radio' name="+name+" id="+id+">");
	input.attr("value",value);
	input.attr("text",text);
	var span = $("<label for="+id+" style='cursor:pointer;'>");
	span.html(text);
	line.append(input);
	line.append(span);
	line.addClass("line");
	return line;
}

/**
 * @param items
 * @param textAttr the key of text which is show in the web
 * @param valueAttr the key of value which is store in the web
 * @param idAttr
 * @param name
 * @param containerId
 */
function createRadioGroupByAttribute(items,textAttr,valueAttr,idAttr, name,containerId){
	for ( var i = 0; i < items.length; i++) {
		var radio = createRadio(items[i][idAttr],items[i][textAttr],name,items[i][valueAttr]);
		$("#" + containerId).append(radio);
	}
}

function information(text){
	noty({text: text,type:'information',layout:'center',maxVisible: 1});
	setTimeout("document.body.removeChild(noty_center_layout_container)",2000);
}
