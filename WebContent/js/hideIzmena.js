$(document).ready(function() {
	$("#changePassForm").hide();
	$("#changeInfoForm").hide();
	$("#rezervacijaForm").hide();
});

function showChangePassForm(e) {

	$("#changePassForm").show();
	$("#btnChangePass").hide();

	$("#message").hide();
	$("#messageFail").hide();
	
	hideChangeInfoForm(e);
}

function hideChangePassForm(e) {

	$("#changePassForm").hide();
	document.forms["changePassForm"].reset();
	$("#btnChangePass").show();
}



function showChangeInfoForm(e) {
	
	$("#changeInfoForm").show();
	$("#btnChangeInfo").hide();

	$("#message").hide();
	$("#messageFail").hide();
	
	hideChangePassForm(e);
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
	
	hideRezervacijaForm(e);
}

function hideRezervacijaForm(e) {
	
	$("#rezervacijaForm").hide();
	document.forms["rezervacijaForm"].reset();
	$("#btnRezervacija").show();
}