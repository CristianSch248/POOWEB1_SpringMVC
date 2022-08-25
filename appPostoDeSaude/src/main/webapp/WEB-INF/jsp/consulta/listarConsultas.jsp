<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- CSS only -->
    <title>Consultas</title>
</head>
<body>
    <a href="/app_postoDeSaude/consulta/home">HOME</a>
    <table>
        <thead>
            <th>Paciente</th>
            <th>Caso</th>
            <th>data</th>
            <th>hora</th>
            <th>Medico</th>
            <th>ativo</th>
        </thead>
        <tbody>
            <c:forEach items="${consultas}" var="consulta">
                <tr>
                    <td>${consulta.paciente.nome}</td>
                    <td>${consulta.caso}</td>
                    <td>${consulta.data}</td>
                    <td>${consulta.hora}</td>
                    <td>${consulta.medico.nome}</td>
                    <td>${consulta.status_consulta}</td>
                    <td><a href="/app_postoDeSaude/consulta/editar?id=${consulta.id}">Editar Consulta</a></td>
                    <td><a href="/app_postoDeSaude/consulta/excluir?id=${consulta.id}">Finalizar Consulta</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
