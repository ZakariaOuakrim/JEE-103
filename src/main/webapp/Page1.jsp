<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Welcome <%= session.getAttribute("login") != null ? session.getAttribute("login") : request.getParameter("login") %></h2>
    <form action="logout.execute" method="post">
        <button type="submit">Logout</button>
    </form>
</body>
</html>