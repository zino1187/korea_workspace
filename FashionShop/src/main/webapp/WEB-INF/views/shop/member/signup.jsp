<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Home</title>
	<%@ include file="../inc/header.jsp" %>
	<style>

	input[type=text], select, textarea , input[type=password]{
	  width: 100%;
	  padding: 12px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	  margin-top: 6px;
	  margin-bottom: 16px;
	  resize: vertical;
	}
	
	input[type=button] {
	  background-color: #4CAF50;
	  color: white;
	  padding: 12px 20px;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	
	input[type=button]:hover {
	  background-color: #45a049;
	}
	
	.container {
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}
	</style>	
	<script>
	$(function(){
		//회원가입 처리 
		$("input[type='button']").click(function(){
			regist();
		});	
	});
	
	function regist(){
		$("#member_form").attr({
			action:"/shop/member/regist",
			method:"post"
		});
		$("#member_form").submit();
	}
	</script>		
</head>

<body>
    	<%@include file="../inc/top.jsp" %>
        <!-- ****** Top Discount Area End ****** -->
		<div class="container">        
			<form id="member_form">
				<input type="text" 		name="user_id" 	placeholder="Your ID..">
				<input type="text" 		name="name" 		placeholder="Your name..">
				<input type="password" name="password" 	placeholder="Your password..">
				<input type="text" 		name="email_id" 	placeholder="이메일 아이디">
				<select name="email_server">
					<option value="gmail.com">gmail.com</option>
					<option value="daum.net">daum.net</option>
					<option value="naver.com">naver.com</option>
				</select>
				<input type="text" 		name="zipcode" 	placeholder="우편번호">
				<input type="text" 		name="addr" 		placeholder="주소입력">
				<input type="button" 	value="가입">
			</form>		       
		</div>	
        <!-- ****** Footer Area Start ****** -->
        <%@ include file="../inc/footer.jsp" %>
        <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->
</body>

</html>