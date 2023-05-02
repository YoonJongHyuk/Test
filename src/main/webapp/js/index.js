$(function(){
	//alert(initPage);
	if(initPage == "null")
		initPage = "userlogin";
	//$('#contentrightdiv > div').hide();
	//$('#contentrightdiv > #' + initPage + 'div').show();
	$('.mgrmenu').click(function () {
   		var nextpage = $(this).attr('nextpage');
   		var param = $(this).attr('param');
   		location.href = "/" + nextpage + ".jsp?param=" + param;
   	});
   	
	$('#modifyul').hide();
	//$('#contentrightdiv > #' + initPage + 'div').show();
   	
   	$('#loginclick').click(function () {
   		$('#loginul').hide();
   		$('#modifyul').show();
   	});
   	$('#modifyclick').click(function () {
   		$('#modifyul').hide();
   		$('#loginul').show();
   	});
});