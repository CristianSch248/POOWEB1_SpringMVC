<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>

        <title>Login</title>
    </head>
    <body>
        <div>
            <h1>login</h1>
            <form method="post" action="/app_postoDeSaude/login/login">
                <label path="email">E-Mail:</label>
                <input name="email" type="text" required/>
                <br>
                <label path="senha">Senha: </label>
                <input name="senha" type="password" required/>
                <br>
                <input type="submit" value="LOGIN">
            </form>
            <c:if test="${loginFalhou}">
                <p style="color: red">Usuário ou senha incorretos!</p>
            </c:if>
        </div>
    </body>
</html>