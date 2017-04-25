/**
 * Intended to validate the announcement date field Date: 21/08/2014 Add-on:
 * Works with moment.js for further validation -Chuks
 */

function __date() {
	var e = document.getElementById("deadline").value, t = document.getElementById("error");
	if (e) {
		if (e >= moment().format("DD/MM/YYYY")) {
			t.style.display = "none";
			return true;
		}
		return false;
	} else {
		t.style.display = "block";
		return false;
	}
}

function __state(value) {
	var changed = document.getElementById('searches');
	if ((changed.value === 'Trainer' || value === 'Trainer') || (changed.value === 'Organization' || value === 'Organization')) {
		var elems = document.getElementsByClassName('hides');
		for ( var i = 0; i < elems.length; i++) elems[i].style.display = "none";
		
		var elemsType = document.getElementsByClassName('hideType');
		for ( var i = 0; i < elemsType.length; i++) elemsType[i].style.display = "none";
		
		var elemsNat = document.getElementsByClassName('hideNationality');
		for ( var i = 0; i < elemsNat.length; i++) elemsNat[i].style.display = "none";
		
		var e = document.getElementById('advanced/search_traineeType');
		e.selectedIndex=0;
	} else {
		var elems = document.getElementsByClassName('hides');
		var td = document.getElementById('natloc');
		
		for ( var i = 0; i < elems.length; i++) elems[i].style.display = "";
				
		var elemsT = document.getElementsByClassName('hideType');
		for ( var i = 0; i < elemsT.length; i++) elemsT[i].style.display = "";
		
		if (changed.value === 'Trainee'){
			var e = document.getElementById('advanced/search_tpType');
			e.selectedIndex=0;
			
			var elemsG = document.getElementsByClassName('tpType');
			for ( var i = 0; i < elemsG.length; i++) elemsG[i].style.display = "none";
			
			var elemsTr = document.getElementsByClassName('traType');
			for ( var i = 0; i < elemsTr.length; i++) elemsTr[i].style.display = "";

			var elemsG = document.getElementsByClassName('hideType');
			for ( var i = 0; i < elemsG.length; i++) elemsG[i].style.display = "";
			
			var elemsNat = document.getElementsByClassName('hideNationality');
			for ( var i = 0; i < elemsNat.length; i++) elemsNat[i].style.display = "";
			//document.getElementById('natloc').textContent = "Nationality:";
		}else if (changed.value === 'TrainingProgram'){
			var e = document.getElementById('advanced/search_traineeType');
			e.selectedIndex=0;
			
			var el = document.getElementById('advanced/search_tpType');
			el.selectedIndex=0;
			
			var elemsG = document.getElementsByClassName('hideType');
			for ( var i = 0; i < elemsG.length; i++) elemsG[i].style.display = "none";
			
			var elemsNat = document.getElementsByClassName('hideNationality');
			for ( var i = 0; i < elemsNat.length; i++) elemsNat[i].style.display = "none";
			//document.getElementById('natloc').textContent = "Location:";
		}else if (changed.value === 'TrainingProposal'){
			var e = document.getElementById('advanced/search_traineeType');
			e.selectedIndex=0;
			
			var elemsG = document.getElementsByClassName('traType');
			for ( var i = 0; i < elemsG.length; i++) elemsG[i].style.display = "none";
			
			var elemsTr = document.getElementsByClassName('tpType');
			for ( var i = 0; i < elemsTr.length; i++) elemsTr[i].style.display = "";
			
			var elemsG = document.getElementsByClassName('hideType');
			for ( var i = 0; i < elemsG.length; i++) elemsG[i].style.display = "";
			
			var elemsNat = document.getElementsByClassName('hideNationality');
			for ( var i = 0; i < elemsNat.length; i++) elemsNat[i].style.display = "none";
		}
	}
}