<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Панель админитратора</title>
</head>
<body>
<h1 style="text-align: center">Изменить информацию о пользователе</h1>
<hr>
<form style="text-align: center;word-spacing: 7px" method="post">
    ${user.getId()}
    <label for="login">Логин:</label>
    <input id="login" type="text" name="login" value="${user.getLogin()}">
    <label id="password">Пароль:</label>
    <input id="password" type="password" name="password" value="${user.getPassword()}">
    <label for="role">Роль:</label>
    <select name="role" size="1" id="role">
        <option>user</option>
        <option>admin</option>
    </select>
    <input type="hidden" name="id" value="${user.getId()}">
    <input type="submit" value="Сохранить" formaction="/admin/updt">
</form>
<p></p>
<form style="text-align: center" method="get" action="/admin">
    <input type="submit" value="Назад">
</form>
</body>
</html>
