<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Панель админитратора</title>
</head>
<body>
<p style="text-align: left">Привет, ${login} вы вошли как ${role}! </p>
<form style="text-align: left" method="post" action="/logout">
    <input type="submit" value="Выйти">
</form>
<h2 style="text-align: center">Список пользователей</h2>
<hr>
<table style="margin-left: auto;margin-right: auto;width: 500px">
    <tr>
        <th>ID</th>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Роль</th>
        <th>Действие</th>
    </tr>
    <c:forEach var='user' items="${users}">
        <tr>
            <td style="text-align: center">${user.getId()}</td>
            <td style="text-align: center">${user.getLogin()}</td>
            <td style="text-align: center">${user.getPassword()}</td>
            <td style="text-align: center">${user.getRole()}</td>
            <td style="text-align: center">
                <form>
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Удалить" formmethod="post" formaction="/admin/del">
                    <input type="submit" value="Редактировать" formmethod="get" formaction="/admin/updt">
                </form>
            </td>
        </tr>
    </c:forEach></table>
<form style="text-align: center" method="get" action="/admin/add">
    <input type="submit" value="Добавить">
</form>
</body>
</html>