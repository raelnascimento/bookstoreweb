<%-- 
    Document   : Login
    Created on : 10 de mai de 2022, 16:54:05
    Author     : devsys-a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bookstore Website</title>
    </head>
    <body>
        <div class="container">
            <div class="responsive">
                <div style="text-align: center">
                    <h1>Admin Login</h1>
                    <form action="login" method="post">
                        <label for="email">Email:</label>
                        <input name="email" size="30" />
                        <br><br>
                        <label for="password">Password:</label>
                        <input type="password" name="password" size="30" />

                        <!-- Esse atributo MESSAGE será utilizado como retorno de mensagem ao usuário caso login inválido. -->

                        <br>${message}<br><br>
                        <button type="submit">Login</button>
                    </form>
                </div>
                <jsp:include page="./contents/rodape.jsp"/>
            </div>
        </div>
    </body>
</html>