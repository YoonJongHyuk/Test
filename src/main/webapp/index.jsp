<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.user.service.UserVO" %>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>

<link rel="stylesheet" href="/css/index.css" />
<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
<!-- <script type="text/javascript" src="/js/jquery.mobile-1.4.5.min.js"></script> -->
<script>

var initPage = "<%= request.getParameter("param")%>";
</script>
<script type="text/javascript" src="/js/index.js"></script>
<script>
	function initScreen() {
		//alert(initPage + " call");
	}
</script>
</head>
<body onLoad="initScreen();">
<div id="viewpoint"> <!-- start of viewpoint -->
<div id="header"> <!-- start of header -->
	<div>
	
	</div>
</div> <!-- end of header -->
<div id="content"> <!-- start of content -->
	<div id="login">
<script>
function memberLogin() {
	if(document.memberloginfrm.userid.value.trim().length < 5) {
		alert("아이디는 5자 이상이어야 합니다.");
		document.memberloginfrm.userid.focus();
		return;
	}
	document.memberloginfrm.submit();
}
</script>
		<form name="memberloginfrm" id="memberloginfrm"
			target="_self" action="/user/checkUserLogin.do" class="usermgrfrm">
			<ul id="loginul">
				<li class="loginli">
					<ul>
						<li class="lifristbox">
							<h3>로그인</h3>
						</li>
						<li>
							<input type="text" name="userid" maxlength="25" placeholder="아이디" size="20" autocomplete="username" id="loginidinput">
						</li>
					</ul>
				</li>
				<li class="loginli">
					<ul>
						<li class="lifristbox" id="loginclick">
							<h3>회원가입</h3>
						</li>
						<li>
							<input type="password" name="userpass" maxlength="25" placeholder="열쇠글" size="20" autocomplete="current-password" id="loginpassinput">
						</li>
					</ul>
				</li>
				<li onclick="memberLogin();"><span id="loginbtn" class="usermgrfrmbutton">로그인</span></li>
			</ul>
		</form>
<script>
function memberJoin() {
	document.memberjoinfrm.action = "/user/userJoin.do";
	document.memberjoinfrm.submit();
}
</script>
		<form name="memberjoinfrm" id="memberjoinfrm"
			target="_self" action="/user/checkUserLogin.do" class="usermgrfrm">
			<ul id="modifyul">
				<li class="loginli">
					<ul>
						<li class="lifristbox" id="modifyclick">
							<h3>모디파이</h3>
						</li>
						<li>
							<input type="text" name="userid" maxlength="25" placeholder="아이디" size="20" autocomplete="username" id="joinidinput">
						</li>
					</ul>
				</li>
				<li class="loginli">
					<ul>
						<li class="lifristbox">
							<h3>입니다</h3>
						</li>
						<li>
							<input type="password" name="userpass" maxlength="25" placeholder="열쇠글" size="20" autocomplete="current-password" id="joinpassinput">
						</li>
					</ul>
				</li>
				<li class="loginli">
					<ul>
						<li class="lifristbox"></li>
						<li>
							<input type="text" name="username" maxlength="25" placeholder="닉네임" size="20" autocomplete="current-password" id="joinnameinput">
						</li>
					</ul>
				</li>
				<li onclick="memberJoin();"> <span id="loginbtn" class="usermgrfrmbutton">회원가입</span></li>
			</ul>
		</form>
	</div>
</div> <!-- end of content -->
</div> <!-- end of viewpoint -->
</body>
</html>