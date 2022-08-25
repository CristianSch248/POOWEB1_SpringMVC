<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->

        <title>Listar Medicos</title>
    </head>
    <body>
        <h1>Medicos Cadastrados</h1>
        <a href="/app_postoDeSaude/editarMedico/home">HOME</a>
        <table>
            <thead>
                <th>Nome</th>
                <th>Especialidade</th>
            </thead>
            <tbody>
                <c:forEach items="${medicos}" var="medico">
                    <tr>
                        <td>${medico.nome}</td>
                        <td>${medico.especialidade}</td>
                        <td><a href="/app_postoDeSaude/medico/editar?id=${medico.id}">Editar</a></td>
                        <td><a href="/app_postoDeSaude/medico/excluir?id=${medico.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
