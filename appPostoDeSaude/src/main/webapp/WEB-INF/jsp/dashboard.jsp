<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->

        <title>Dashboard</title>
    </head>
    <body>
        <h1>Dashboard</h1>
        <ul>
            <a href="/app_postoDeSaude/dashboard/cadastrarPaciente">Cadastrar Paciente</a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/listarPaciente">Listar Paciente</a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/cadastrarMedico">Cadastrar Medicos</a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/listarMedico">Listar Medicos</a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/cadastrarConsulta">Cadastrar Consulta</a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/listarConsultas">listar Consulta</a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/historicoAtendimento">Historico de Atendimento dos medicos </a>
            <br>
            <br>
            <a href="/app_postoDeSaude/dashboard/historicoConsulta">Historico de Consultas dos Pacientes</a>
            <br>
            <br>
        </ul>
        <a href="/app_postoDeSaude/login/LogOut">LogOut</a>
    </body>
</html>
