$(document).ready(function() {

	
	$('#changeInfoForm').hide();
	$('#rezervacijaForm').hide();

	$("#btnDelete").click(function() {

		var clicked = window.confirm("Da li ste sigurni?");

		if (clicked == true) {
			$("#deleteForm").submit();
		} else {
			return false;
		}
	});

	
	
	$('#btnChangeInfo').click(function() {
		$('#changeInfoForm').toggle();
		$('#userFollowers').hide();
		$('#userComments').hide();
		$('#userVideos').hide();
		$('.videoAdminEditForm').hide();
	});
	
});


function hideChangeInfoForm(e) {
	$('#changeInfoForm').hide();
}

function hideRezervacijaForm(e) {
	$('#rezervacijaForm').hide();
}