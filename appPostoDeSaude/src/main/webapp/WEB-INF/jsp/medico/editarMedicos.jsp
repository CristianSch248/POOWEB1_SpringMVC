<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <!-- CSS only -->

        <title>Editar Medicos</title>
    </head>
    <body>
        <h1>Editar Informações do Medico</h1>
        <a href="/app_postoDeSaude/editarMedico/home">HOME</a>
        <form:form method="post" action="/app_postoDeSaude/editarMedico/editar" modelAttribute="medico">
            <form:label path="nome">Nome: </form:label>
            <form:input path="nome" value="${medico.nome}" type="text" required="true"/>
            <br>
            <form:label path="especialidade">Especialidade: </form:label>
            <form:input path="especialidade" value="${medico.especialidade}" type="text" required="true"/>
            <br>

            <form:input path="id" value="${medico.id}" type="hidden"/>

            <button type="submit" class="btn btn-primary" value="cadastrar">
                editar
            </button>
        </form:form>
        <a href="/app_postoDeSaude/dashboard/listarMedico">Listar Pacientes</a>
    </body>
</html>
