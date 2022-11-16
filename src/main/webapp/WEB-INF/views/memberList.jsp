<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>가입날짜</td>
		</tr>
		<c:forEach items="${mbList}" var="member"> <!-- items="mbList"  모델에서 넘어온 이름 TestController var="member" 아무거나 써줘도됨 -->
		<tr>
			<td>${member.mid }</td>
			<td>${member.mname}</td>
			<td>${member.mpw}</td>
			<td>${member.memail}</td>
			<td>${member.mdate}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>