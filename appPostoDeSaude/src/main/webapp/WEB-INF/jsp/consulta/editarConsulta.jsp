<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- CSS only -->
    <title>Editar Consulta</title>
</head>
<body>
    <h1>Editar Consulta</h1>
    <a href="/app_postoDeSaude/consulta/home">HOME</a>
    <form:form method="post" action="/app_postoDeSaude/editarConsulta/editar" modelAttribute="consulta">

        <h2>Paciente: ${consulta.paciente.nome}, CPF: ${consulta.paciente.cpf}</h2>
        <form:input path="paciente.id" value="${paciente.id}" type="hidden" />
        <h2>Medico: ${consulta.medico.nome}, especialidade: ${consulta.medico.especialidade}</h2>
        <form:input path="medico.id" value="${medico.id}" type="hidden" />
        <br>
        <form:label path="data">Data da Consulta: </form:label>
        <form:input path="data" value="${consula.date}" type="date"/>
        <br>
        <form:label path="hora">Horas da consulta: </form:label>
        <form:input path="hora" value="${consulta.hora}" type="time" />
        <br>
        <form:label path="caso">Caso: </form:label>
        <form:textarea path="caso" value="${consula.caso}" type="text"/>

        <form:input path="id" value="${consulta.id}" type="hidden"/>

        <br>
        <button type="submit" class="btn btn-primary" value="cadastrar">
            Editar
        </button>
    </form:form>
</body>
</html>
