<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->

        <title>Cadastrar Paciente</title>
    </head>
    <body>
        <h1>Cadastrar Paciente</h1>
        <a href="/app_postoDeSaude/paciente/home">HOME</a>
        <form:form method="post" action="/app_postoDeSaude/paciente/cadastrar" modelAttribute="paciente">
            <form:label path="nome">Nome: </form:label>
            <form:input path="nome" type="text" required="true"/>
            <br>
            <form:label path="idade">Idade: </form:label>
            <form:input path="idade" type="number" required="true"/>
            <br>
            <form:label path="sexo">Sexo: </form:label>
            <label>
            <input type="radio"
                    class="form-control"
                    id="masculino"
                    name="sexo"
                    value="Masculino"
                    required>
            Masculino
            </label>
            <label>
            <input type="radio"
                  class="form-control"
                  id="feminino"
                    name="sexo"
                value="Feminino"
               required>
            Feminino
            </label>
            <br>
            <form:label path="cpf">cpf: </form:label>
            <form:input path="cpf" type="cpf" required="true"/>
            <br>
            <form:label path="telefone">telefone: </form:label>
            <form:input path="telefone" type="telefone" required="true"/>
            <br>
            <button type="submit" class="btn btn-primary" value="cadastrar">
                Cadastrar
            </button>
        </form:form>
    </body>
</html>
