<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%
	int personID = Integer.parseInt(request.getParameter("pID"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 수정폼</h1>
	<p>
		아래 항목을 수정하고 "수정" 버튼을 클릭하세요.
	</p>

	<form action="/pb02/pbc" method="get">
		<input type = "hidden" name = "action" value = "update">
		<input type = "hidden"  name = "pID" value= <%=personID%>>
		이름(name) : <input type="text" name="name"  value=""> <br>
		핸드폰(hp) : <input type="text" name="hp"  value=""> <br>
		회사(company) : <input type="text" name="company"  value=""> <br> 
		<button type="submit">수정</button>
	</form>

	<br>
	<a href="/pb02/pbc?action=list">리스트 바로가기</a>
</body>
</html>