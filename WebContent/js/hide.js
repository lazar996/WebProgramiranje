$(document).ready(function() {
	
	$("#changeInfoForm").hide();
	$("#rezervacijaForm").hide();
});



function showChangeInfoForm(e) {
	
	$("#changeInfoForm").show();
	$("#btnChangeInfo").hide();

	$("#message").hide();
	$("#messageFail").hide();
	
}

function hideChangeInfoForm(e) {
	
	$("#changeInfoForm").hide();
	document.forms["changeInfoForm"].reset();
	$("#btnChangeInfo").show();
}



function showRezervacijaForm(e) {
	
	$("#rezervacijaForm").show();
	$("#btnRezervacija").hide();

	$("#message").hide();
	$("#messageFail").hide();
	
	
}

function hideRezervacijaForm(e) {
	
	$("#rezervacijaForm").hide();
	document.forms["rezervacijaForm"].reset();
	$("#btnRezervacija").show();
}