
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title></title>

</head>
<body style="height: 90%">

	<style>
/* table tr td { 
border: 1px solid black;
} */
body {
	background-color: rgb(249, 249, 249) !important;
}

.title {
	max-width: 350px;
	margin: auto;
	margin-top: -20px !important;
}

.container {
	max-width: 350px;
	outline: 1px solid rgb(216, 222, 226);
	background-color: white;
	margin-top: 20px;
	padding: 30px;
	padding-bottom: 20px !important;
}

.dividercontainer {
	max-width: 350px;
	margin: auto;
}

@font-face {
	font-family: 'NanumGothic';
	src: url(/pas/resources/fonts/NANUMGOTHIC.TTF) format('truetype');
}

@font-face {
	font-family: 'FEDERALESCORTHALFITAL';
	src: url(/pas/resources/fonts/FEDERALESCORTHALFITAL.TTF);
}

#titleLogo {
	font-family: 'FEDERALESCORTHALFITAL';
	color: #337ab7;
}

body {
	font-family: NanumGothic !important;
	overflow: hidden;
}

.divider {
	position: relative;
	width: 100%;
	height: 1px;
	background: #ddd;
	margin: 20px auto;
}

.divider:after {
	content: 'OR';
	width: 30px;
	height: 30px;
	line-height: 30px;
	border-radius: 15px;
	font-size: 12px;
	color: #666;
	background: #fff;
	border: 1px solid #f0f0f0;
	display: block;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -15px;
	margin-left: -15px;
	text-align: center;
}
/* .modal-title{
background-color:#f1550e !important;
} */
</style>






	<!-- Bootstrap Core CSS -->
	<link
		href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
		rel="stylesheet">


	<!-- jQuery -->
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<%--  --%>




	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<link
		href="<%=request.getContextPath()%>/resources/css/jquery.modal.css"
		type="text/css" rel="stylesheet" />
	<link
		href="<%=request.getContextPath()%>/resources/css/jquery.modal.theme-xenon.css"
		type="text/css" rel="stylesheet" />
	<link
		href="<%=request.getContextPath()%>/resources/css/jquery.modal.theme-atlant.css"
		type="text/css" rel="stylesheet" />

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/alert.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery.modal.js"></script>
	<style>
#mloader {
	position: fixed;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 99999;
	background-color: #000;
	opacity: 0.7;
	display: none;
}

#mloader .masterkey_blink {
	font-size: 20px;
	font-weight: bold;
	margin: 10% 45%;
	-webkit-animation: masterkey_blink 1s linear infinite;
}

@
-webkit-keyframes masterkey_blink { 15% {
	color: white;
}
40%
{
color












:






 






black












;
}
75%
{
color












:






 






white












;
}
}
</style>

	<div id="mloader">
		<div class="masterkey_blink">LOADING...</div>
	</div>

	<script>
$(function(){
	$('.modal-text').html('<img src="/pas/resources/img/fail.png"/>');
	
})
	
</script>


	<script type="text/javascript">
	$(function() {
		$("#login").click(function() {
			var email = $("#card_Id").val();
			
			var pwd = $('#card_Pwd').val();
		
			var dataList={'card_Id':email, 'card_Pwd':pwd};
		
			$.ajax({
				
				type : 'POST',
				url : '/dangyeol/main/login',
				dataType : 'json',
				contentType : "application/json; charset=UTF-8",
				data : JSON.stringify(dataList),
				success : function(result) {
					if (result == true) { 
                        location.href="<%=request.getContextPath()%>/main/home"
                        	
											}else{
												alert("로그인 실패");
											} 
										}
									});
                        		});
						});
		$(function() {
			$("#searchPwd").click(function() {
				var sendEmail = $('#sendEmail').val();
				$.ajax({
					type : 'POST',
					url : 'simpleMessage',
					dataType : 'json',
					data : {
						'sendEmail' : sendEmail
					},
					success : function(result) {
						if (result == "1") {
							successBox("해당 이메일로 임시 비밀번호를 발송하였습니다.");
						} else {
							warningBox("존재하지않는 이메일입니다.");
						}
					}
                 
				});
			});
			});
			
	
	
	
	$(function() {
			$("#searchEmail").click(function() {
				var sendName = $('#sendName').val();
				var sendPhone = $('#sendPhone').val();
				
				var dataList = {'sendName':sendName , 'sendPhone':sendPhone}
				$.ajax({
					type : 'POST',
					url : 'searchEmail',
					dataType : 'json',
					contentType:'application/json',
					data : JSON.stringify(dataList),
					success : function(data) {
						if (data.id != null) {
							if(data.id==""){
								warningBox("회원정보가 맞지않습니다.");
							}else{
								successBox("해당 아이디는 "+data.id+"입니다.");
							}
						}
					}
				});
			});
			});
	
	
	
</script>



	<div class="container2" style="margin-bottom: 5%;">

		<h3 id="titleLogo"
			style="font-family: 'FEDERALESCORTHALFITAL' !important; text-align: right; margin-right: 46px;">
			단결</h3>
		<div class="title">


			<h2 style="font-weight: bold;">로그인</h2>
			<hr style="color: rgb(216, 222, 226); margin-top: 5px;">
		</div>

		<div class="container" style="margin-top: 0px;">

			<div id="1">
				<div class="form-group">
					<label for="usr">Email:</label> <input type="text"
						class="form-control" id="card_Id">
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="card_Pwd">
				</div>

				<center>
					<input type="button" class="btn btn-success" value="로그인" id="login" />
				</center>
				<%-- <jsp:include page="CAPTCHA.jsp" /> --%>
				<%-- 	<c:import url="CAPTCHA.jsp"/> --%>
			</div>
			<%-- <!-- 
			 --><script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script> --%>
			<div id="2" style="display: none">
				<form>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="login_mem_Email" name="login_mem_Email"
							placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" id="login_mem_Pass" name="login_mem_Pass"
							placeholder="Enter password">
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<input type="button" id="login" class="btn btn-default btn-block"
						value="들어가기" name="login1"> <input type="button"
						style="display: none;" class="btn btn-default btn-block"
						id="adminBtn" value="ADMIN" onclick="admin_go()">
				</form>

			</div>
		</div>
		<div class="dividercontainer">
			<div class="divider"></div>
		</div>
		<div class="container" style="padding: 20px;">
			<span style="text-align: center">단결에 처음 방문하셨다면 <a
				href="<%=request.getContextPath()%>/index#about">새 계정을 만드세요.</a></span> <br>
			<br> <a href="javscript:void(0);"><span
				style="text-align: center" id="forget1">이메일 계정을 잊으셨습니까?</span></a><br>
			<br> <a href="javscript:void(0);"><span
				style="text-align: center" id="forget"> 비밀번호를 찾고 싶습니다.</span></a>
		</div>
		<div class="container" id="hiddenDiv" style="display: none">
			<form>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="sendEmail" name="sendEmail"
						placeholder="Enter email">
				</div>
				<input type="button" id="searchPwd"
					class="btn btn-default btn-block" value="임시비밀번호발급">
			</form>
		</div>

		<div class="container" id="hiddenEmail" style="display: none">
			<form>
				<div class="form-group">
					<label for="Name">Name:</label> <input type="text"
						class="form-control" id="sendName" name="sendName"
						placeholder="Enter Name">
				</div>
				<div class="form-group">
					<label for="Phone">Phone:</label> <input type="text"
						class="form-control" id="sendPhone" name="sendPhone"
						placeholder="010-xxxx-xxxx">
				</div>

				<input type="button" id="searchEmail"
					class="btn btn-default btn-block" value="이메일 찾기">
			</form>
		</div>

	</div>

</body>
<script>
	function admin_go(){
		
		location.href="<%=request.getContextPath()%>
	/admin/adminLogin";
	}
	$(document).ready(function() {
		$('#forget').click(function() {
			$("#hiddenEmail").hide();
			$("#hiddenDiv").show();
		})
		$('#forget1').click(function() {
			$("#hiddenDiv").hide();
			$("#hiddenEmail").show();
		})
	});
</script>
</html>