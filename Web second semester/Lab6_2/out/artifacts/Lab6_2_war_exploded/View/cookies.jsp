<%-- 
    Document   : cookies
    Created on : 26.05.2019, 16:29:50
    Author     : Islam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="style.css" rel='stylesheet' type='text/css'>
        <title>Cookie Page</title>
    </head>
    <body>
    <header>
        <h2> Cookies </h2>
    </header>

    <section>
        <nav>
            <ul>
                <li><form action="home" method="get">
                    <button name="command" value="checks">Get not closed checks</button>

                    <p><button name="command" value="cookies">Cookies</button></p>
                </form>
                </li>
            </ul>
        </nav>
        <article>
            <p>
                ${cookiesAction1}
            </p>
        </article>
    </section>

    <footer>
        <p>Footer</p>
    </footer>
    </body>
</html>
