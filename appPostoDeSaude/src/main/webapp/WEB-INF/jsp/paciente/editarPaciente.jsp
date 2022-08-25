<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->

        <title>Editar Paciente</title>
    </head>
    <body>
        <h1>Editar Informacoes do Paciente</h1>
        <a href="/app_postoDeSaude/editarPaciente/home">HOME</a>
        <form:form method="post" action="/app_postoDeSaude/editarPaciente/editar" modelAttribute="paciente">
            <form:label path="nome">Nome: </form:label>
            <form:input path="nome" value="${paciente.nome}" type="text" required="true"/>
            <br>
            <form:label path="idade">Idade: </form:label>
            <form:input path="idade" value="${paciente.idade}" type="number" required="true"/>
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
            <form:input path="cpf" value="${paciente.cpf}" type="cpf" required="true"/>
            <br>
            <form:label path="telefone">telefone: </form:label>
            <form:input path="telefone" value="${paciente.telefone}" type="telefone" required="true"/>

            <form:input path="id" value="${paciente.id}" type="hidden"/>

            <br>
            <button type="submit" class="btn btn-primary" value="cadastrar">
                Editar
            </button>
        </form:form>
        <a href="/app_postoDeSaude/dashboard/listarPaciente">Listar Pacientes</a>
    </body>
</html>
