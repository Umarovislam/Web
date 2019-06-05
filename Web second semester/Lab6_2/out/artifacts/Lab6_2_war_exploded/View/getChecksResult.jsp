<%-- 
    Document   : getChecksResult
    Created on : 26.05.2019, 16:32:38
    Author     : Islam
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="style.css" rel='stylesheet' type='text/css'>
        <title>JSP Page</title>
    </head>
    <body>
    <header>
        <h2> Чеки </h2>
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
                    <c:when test="${not empty checksAction}">
                        <c:forEach var="check" items="${checksAction}">
                            <p>
                                    ${check}
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
