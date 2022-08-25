<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->
        <title>Cadastrar Medicos</title>
    </head>
    <body>
        <h1>Cadastrar Medico</h1>
        <a href="/app_postoDeSaude/medico/home">HOME</a>
        <form:form method="post" action="/app_postoDeSaude/medico/cadastrar" modelAttribute="medico">
            <form:label path="nome">Nome: </form:label>
            <form:input path="nome" type="text" required="true"/>
            <br>
            <form:label path="especialidade">Especialidade: </form:label>
            <form:input path="especialidade" type="text" required="true"/>
            <br>
            <button type="submit" class="btn btn-primary" value="cadastrar">
                Cadastrar
            </button>
        </form:form>
    </body>
</html>
