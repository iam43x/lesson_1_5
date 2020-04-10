<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<h1 style="text-align: center">Привет, ${login} вы вошли как ${role}!</h1>
<form method="post" action="/logout">
    <input type="submit" value="Выйти">
</form>
</body>
</html>