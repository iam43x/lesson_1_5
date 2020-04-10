<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h1 style="text-align: center">Зарегистрируйтесь</h1>
<hr>
<form style="text-align: center" method="post" action="/reg">
    <label for="login">Логин:</label>
    <input id="login" type="text" name="login">
    <label for="password">Пароль:</label>
    <input id="password" type="password" name="password">
    <input type="submit" value="Регистрация">
</form>
<p></p>
<form style="text-align: center" method="get" action="/">
    <input type="submit" value="Назад">
</form>
</body>
</html>