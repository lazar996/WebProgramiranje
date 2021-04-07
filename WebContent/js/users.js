$(document).ready(function() {
	
	$("#userFilterPanel").hide();
	$("#userSortPanel").hide();

	$("#btnUsersFilter").click(function() {
		$("#userFilterPanel").toggle();
		$("#userSortPanel").toggle();
	});
});