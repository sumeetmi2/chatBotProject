<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	
	function doonbodyload(){
		if('1' == '<%=request.getAttribute("redirect")%>'){
			document.forms[0].submit();			
		}
		if('1' == '<%=request.getAttribute("feedbackFlag")%>'){
			document.forms[0].actionType.value='msg';
		}
	}
	
	function feedback(id){
		document.forms[0].feedbackIntent.value=id;
		document.forms[0].actionType.value='feedback';
		document.forms[0].response.value="0";
		document.forms[0].submit();
	}

</script>
</head>
<body onload="javascript:doonbodyload()">
	<form:form method="POST" action="/DoEngine/bot">
		<form:input type ="hidden" path="sessionId" value="${sessionId}"/>
		<form:input type ="hidden" path="response" value="${response}"/>
		<form:input type ="hidden" path="actionType" value="${actionType}"/>
		<form:input type ="hidden" path="feedbackIntent" value="${feedbackIntent}"/>
		<form:input type ="hidden" path="feedbackExpression" value="${feedbackExpression}"/>
		<table>
			<tr>
				<td>Hi this is jarvis . How may I be able to assist you?</td>
			</tr>
			<tr>
				<td><form:label path="currentChat.message">Message</form:label></td>
				<td><form:input path="currentChat.message" value="${currentChat.message}"/></td>
				<form:input type="hidden" path="currentChat.id" value="Human"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
	</table><table>
			<tr>
			<td>
			<%int cnt =0; %>
				<c:forEach items="${chats}" var="chat" varStatus="vs">
					<form:input type ="hidden" path="chats[${vs.index}].message" value="${chat.message}"/>
					<form:input type ="hidden" path="chats[${vs.index}].id" value="${chat.id}"/>
					${chat.id}:${chat.message}<br/>
				</c:forEach>
			</td>
			</tr>
		</table>
	</form:form>
</body>
</html>