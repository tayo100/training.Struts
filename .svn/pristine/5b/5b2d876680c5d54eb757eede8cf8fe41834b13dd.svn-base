function copyBudget(source, count, idIndex) {
	copyBudgetInternal(source, idIndex);
}

function copyBudgetInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copyTrainer(source, count, idIndex) {
	copyTrainerInternal(source, idIndex);
}

function copyTrainerInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	//alert(name);
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio'))).concat(
			$A(c.getElementsByTagName('div')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		//i.id = null;
		
		if(i.hasAttribute("onfocus")==true){
			var pos = i.getAttribute("onfocus").indexOf("_");
			for ( var repIndex = 0; repIndex < idIndex; repIndex++)
				pos = i.getAttribute("onfocus").indexOf("_", pos + 1);
				
				var oldTrainer = "trainer_0_";
				var newTrainer = "trainer_" + index + "_";
				//alert(i.getAttribute("onfocus"));
				//i.setAttribute("onfocus", i.getAttribute("onfocus").substring(0, pos) + "_" + index + "_" + i.getAttribute("onfocus").substring(i.getAttribute("onfocus").indexOf("_", pos + 1) + 1, 3200).replace(oldTrainer,newTrainer));
				i.setAttribute("onfocus", i.getAttribute("onfocus").replace(/trainer_0_/gi,newTrainer));
				//alert("REPLACE THIS: " + oldTrainer + " WITH THIS: " + newTrainer);
				//alert(i.getAttribute("onfocus"));
		}
		
		var pos = i.id.indexOf("_");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.id.indexOf("_", pos + 1);

		i.id = i.id.substring(0, pos) + "_" + index + "_"
				+ i.id.substring(i.id.indexOf("_", pos + 1) + 1, 100);
		
		// update proper index
		if(i.hasAttribute("name")==true){
			var pos = i.name.indexOf("[");
			for ( var repIndex = 0; repIndex < idIndex; repIndex++)
				pos = i.name.indexOf("[", pos + 1);
	
			i.name = i.name.substring(0, pos) + "[" + index + "]"
					+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		}
		
		if(i.hasAttribute("value")==true){
			i.value='';
		}
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copyLanguage(source, count, idIndex) {
	copyLanguageInternal(source, idIndex);
}

function copyLanguageInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('select')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copyChildren(source, count, idIndex) {
	copyChildrenInternal(source, idIndex);
}

function copyChildrenInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copyEducation(source, count, idIndex) {
	copyEducationInternal(source, idIndex);
}

function copyEducationInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}
function copyEmployment(source, count, idIndex) {
	copyEmploymentInternal(source, idIndex);
}

function copyEmploymentInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copyDuty(source, count, idIndex) {
	copyDutyInternal(source, idIndex);
}

function copyDutyInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copySkill(source, count, idIndex) {
	copySkillInternal(source, idIndex);
}

function copySkillInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}

function copyConstraint(source, count, idIndex) {
	copyConstraintInternal(source, idIndex);
}

function copyConstraintInternal(source, idIndex) {
	if (!Element.visible(source)) {
		Element.show(source);
		return;
	}
	var rx = /\[(\d+)\]/g;
	rx.lastIndex = 0;
	var name = source.getElementsByTagName('input')[0].name;
	var rm = rx.exec(name);
	for ( var rxi = 0; rxi < idIndex; rxi++) {
		rm = rx.exec(name);
	}
	var index = parseInt(rm[1]) + 1;

	var c = $(source.cloneNode(true));
	var ii = $A(c.getElementsByTagName('input')).concat(
			$A(c.getElementsByTagName('textarea'))).concat(
			$A(c.getElementsByTagName('select'))).concat(
			$A(c.getElementsByTagName('radio')));
	for ( var j = 0; j < ii.length; j++) {
		var i = ii[j];
		i.id = null;
		// update proper index
		var pos = i.name.indexOf("[");
		for ( var repIndex = 0; repIndex < idIndex; repIndex++)
			pos = i.name.indexOf("[", pos + 1);

		i.name = i.name.substring(0, pos) + "[" + index + "]"
				+ i.name.substring(i.name.indexOf("]", pos + 1) + 1, 100);
		i.value='';
	}
	source.parentNode.insertBefore(c, source.nextSibling);
	Element.show(c);
}