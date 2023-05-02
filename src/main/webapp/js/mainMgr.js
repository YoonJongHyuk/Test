$(function(){
	//alert(initPage);
	if(initPage == "null")
		initPage = "list";
	//$('#contentrightdiv > div').hide();
	//$('#contentrightdiv > #' + initPage + 'div').show();
	$('.mgrmenu').click(function () {
   		var nextpage = $(this).attr('nextpage');
   		var param = $(this).attr('param');
   		location.href = "/" + nextpage + ".jsp?param=" + param;
   	});
   	$('#listbtn').click(function () {
   		//location.href = "/document/DocumentList.do";
   		getList();
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


function getList() {
		alert("getList");
	   $.ajax({
	       url:'/document/getDocumentVOListJson.do', //request 보낼 서버의 경로
	       type:'post', // 메소드(get, post, put 등)
	       data:{}, //보낼 데이터
	       dataType: "json",
	       success: function(data) {
	           //서버로부터 정상적으로 응답이 왔을 때 실행
	           alert("정상수신");
	           
	           var liString = "";
	           
	           $(data.faqVOList).each(function () {
	           	var id = this.id;
	           	var title = this.title;
	           	var star = this.star;
	           	var appendix = this.appendix;
	           	liString += "<li class='bgonoff' onclick=\"documentModify('" + id + "');\">" + title + " </li>"
	           	liString += "<li class=\"contentli\">"
	           	liString += "<ul>"
	           	liString += "<li class=\"cookimage\">"
	           	liString += appendix
	           	liString += "</li>"
	           	liString += "<li class=\"cookcontent\">"
	           	liString += star
	           	liString += "</li>"
	           	liString += "</ul>"
	           	liString += "</li>"
	           });
	           
				$('#contentul').html(liString);
	       },
	       error: function(err) {
	           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
	           objErr = err;
	          alert("오류발생 , error="+err.state());
	       }
	   });
}