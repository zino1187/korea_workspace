<%@page import="com.koreait.fashionshop.common.MessageData"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	MessageData messageData= (MessageData)request.getAttribute("messageData");

%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
<%if(messageData.getResultCode()==1){%>
	alert("<%=messageData.getMsg()%>");
	location.href="<%=messageData.getUrl()%>";
<%}else{%>
	alert("<%=messageData.getMsg()%>");
<%}%>

</script>
</head>
<body>
</body>
</html>