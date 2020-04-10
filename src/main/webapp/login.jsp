<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить пользователя</title>
</head>
<body>
<h1 style="text-align: center">Войдите</h1>
<hr>
<p style="text-align: center">${message}</p>
<form style="text-align: center;word-spacing: 6px" method="post" action="/">
    <label for="login">Логин:</label>
    <input id="login" type="text" name="login">
    <label for="password">Пароль:</label>
    <input id="password" type="password" name="password">
    <input type="submit" value="Войти">
</form>
<p></p>
<form style="text-align: center" method="get" action="/reg">
    <input type="submit" value="Регистрация">
</form>
</body>
</html>