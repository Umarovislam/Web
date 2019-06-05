<%--
  Created by IntelliJ IDEA.
  User: Islam
  Date: 31.05.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>CSS Template</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<header>
  <h2>Заказ гостиницы.</h2>
</header>

<section>
  <nav>
    <ul>
      <li><form action="home" method="get">
        <button name="command" value="checks">Get not closed checks</button>
        <p><button name="command" value="Nums">Nums</button></p>
        <p><button name="command" value="cookies">Cookies</button></p>

      </form>
      </li>

    </ul>
  </nav>
  <article>
    <p>Клиент заполняет Заявку, указывая количество мест в номере, класс апартаментов и время пребывания. </p>
    <p> Администратор просматривает поступившую Заявку, выделяет наиболее подходящий из доступных Номеров, после чего система выставляет Счет Клиенту.</p>
    <p> Оплата Счета Клиентом регистрируется системой, также Администратор может просмотреть неоплаченные Счета.</p>
  </article>
</section>

<footer>
  <p>Footer</p>
</footer>

</body>
</html>
