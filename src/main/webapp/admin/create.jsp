<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Панель админитратора</title>
    </head>
    <body>
        <h1 style="text-align: center">Добавить нового пользователя</h1>
        <hr>
        <form style="text-align: center" method="post" action="/admin/add">
            <label for="login">Логин:</label>
            <input id="login" type="text" name="login">
            <label for="password">Пароль:</label>
            <input id="password" type="password" name="password">
            <label for="role">Роль:</label>
            <select name="role" size="1" id="role">
                <option>user</option>
                <option>admin</option>
            </select>
            <input type="submit" value="Добавить">
        </form>
        <p></p>
        <form style="text-align: center" method="get" action="/admin">
        <input type="submit" value="Назад">
        </form>
    </body>
</html>