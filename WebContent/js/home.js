$(document).ready(function() {

	$('#leftNavigation').height($('#homePageVideos').height());
	$("#leftNavigation").hide();

	$("#btnFilter").click(function() {
		$("#leftNavigation").toggle();
		$('#leftNavigation').height($('#homePageVideos').height());
		$('videoContainer').css('flaot:left');
	});
	
	
});