<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->
        <title>Pacientes</title>
    </head>
    <body>
    <h1>Paciantes Cadastrados</h1>
    <a href="/app_postoDeSaude/paciente/home">HOME</a>
        <table>
            <thead>
                <th>Nome</th>
                <th>Idade</th>
                <th>sexo</th>
                <th>CPF</th>
                <th>telefone</th>
            </thead>
            <tbody>
                <c:forEach items="${pacientes}" var="paciente">
                    <tr>
                        <td>${paciente.nome}</td>
                        <td>${paciente.idade}</td>
                        <td>${paciente.sexo}</td>
                        <td>${paciente.cpf}</td>
                        <td>${paciente.telefone}</td>
                        <td><a href='/app_postoDeSaude/paciente/editar?id=${paciente.id}'>Editar</a></td>
                        <td><a href='/app_postoDeSaude/paciente/excluir?id=${paciente.id}'>Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
