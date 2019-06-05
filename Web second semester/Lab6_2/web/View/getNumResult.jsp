<%--
  Created by IntelliJ IDEA.
  User: Islam
  Date: 03.06.2019
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="style.css" rel='stylesheet' type='text/css'>
    <title>JSP Page</title>
</head>
<body>
<header>
    <h2> Свободные номера </h2>
</header>

<section>
    <nav>
        <ul>
            <li>
                <a class="active" href = "">Home</a>
            </li>
            <li>
                <a href = "">Get Not closed Checks </a>
            </li>
        </ul>
    </nav>
    <article>
        <c:choose>
            <c:when test="${not empty numsAction}">
                <c:forEach var="num" items="${numsAction}">
                    <p>
                            ${num}
                    </p>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>empty</p>
            </c:otherwise>
        </c:choose>
    </article>
</section>
<footer>
    <p>Footer</p>
</footer>

</body>
</html>
