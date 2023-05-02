<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.user.service.UserVO" %>
<%@ page import="egovframework.document.service.DocumentVO" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta charset="UTF-8">
<title>mainMgr.jsp</title>

<link rel="stylesheet" href="/css/mainMgr.css" />
<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
<!-- <script type="text/javascript" src="/js/jquery.mobile-1.4.5.min.js"></script> -->
<script>

var initPage = "<%= request.getParameter("param")%>";
</script>
<script type="text/javascript" src="/js/mainMgr.js"></script>
<script>
	function initScreen() {
		//alert(initPage + " call");
	}
</script>
</head>
<body onLoad="initScreen();">
<div id="viewpoint"> <!-- start of viewpoint -->
<div id="header"> <!-- start of header -->
<script>
function memberLogout() {
    var useridField = document.memberloginfrm.userid;
    if(useridField && useridField.value) {
        document.memberloginfrm.userid.focus();
        return;
    }
    document.memberloginfrm.submit();
}
</script>
	<form name="memberloginfrm" id="memberloginfrm" target="_self" action="/user/userLogout.do"
		style="width: 100%; background-color: lightgray; bottom: 0px; position: absolute;" class="usermgrfrm">
		<ul>
			<li><span id="listbtn" class="mgrfrmbutton">목록</span></li>
			<li onclick="memberLogout();"><span id="loginbtn" class="usermgrfrmbutton">로그아웃</span></li>
		</ul>
	</form>

</div> <!-- end of header -->
<div id="content"> <!-- start of content -->
	<ul id="contentul">
<% 
	if(request.getAttribute("resultList") != null) {

		List<DocumentVO> list = (List<DocumentVO>)request.getAttribute("resultList");
		for(int i=0; i<list.size() ; i++) {
			DocumentVO vo = (DocumentVO)list.get(i);
%>
				<li class="bgonoff" onclick="documentModify('<%= vo.getId()%>');"><%= vo.getTitle()%></li>
				<li class="contentli">
					<ul>
						<li class="cookimage">
							<%= vo.getAppendix() %>
						</li>
						<li class="cookcontent">
							<%= vo.getStar() %>
						</li>
					</ul>
				</li>
<% 
		}
	}
%>
	</ul>

</div> <!-- end of content -->
</div> <!-- end of viewpoint -->
</body>
</html>