<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Опросник</title>
</head>
<body>
<form action="ResultServlet" method="post">
    <h2>Вопрос 1: Какой напиток вы предпочитаете?</h2>
    <input type="radio" name="question1" value="Coffee"> Кофе
    <input type="radio" name="question1" value="Tea"> Чай<br>

    <h2>Вопрос 2: Какой вид кофе вам нравится больше всего?</h2>
    <input type="radio" name="question2" value="Latte"> Латте
    <input type="radio" name="question2" value="Cappuccino"> Капучино<br>
    <br/>

    <input type="submit" value="Показать результат">
</form>
</body>
</html>
