<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page</h2>
<form action="valid.execute" method="post">
    <div>
        <label for="login">Login:</label>
        <input type="text" id="login" name="login" required>
    </div>
    <br>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <br>
    <div>
        <button type="submit">OK</button>
    </div>
</form>
</body>
</html>