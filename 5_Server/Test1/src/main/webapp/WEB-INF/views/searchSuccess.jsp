<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>회원정보</h1>
	<table border=1>
		<tr>
			<th>회원번호</th>		
			<th>회원아이디</th>		
			<th>회원이름</th>		
			<th>회원나이</th>		
		</tr>
		<tr>
			<th>${user.userNo}</th>		
			<th>${user.userId}</th>		
			<th>${user.userName}</th>		
			<th>${user.userAge}</th>		
		</tr>
	</table>
	<a href="index.jsp">메인페이지로 돌아가기</a>

</body>
</html>