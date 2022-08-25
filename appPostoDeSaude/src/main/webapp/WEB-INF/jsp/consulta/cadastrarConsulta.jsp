<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Consulta</title>
    </head>
    <body>
        <h1>CONSULTA</h1>
        <a href="/app_postoDeSaude/consulta/home">HOME</a>
        <form:form method="post" action="/app_postoDeSaude/consulta/cadastrar" modelAttribute="consulta">

            <%-- PACIENTE --%>
            <form:label path="paciente">Paciente: </form:label>
            <form:select path="paciente.id" required="true">
                <option selected disabled>Selecione o paciente</option>
                <c:forEach items="${pacientes}" var="p">
                    <option value="${p.id}">${p.nome} - ${p.cpf}</option>
                </c:forEach>
            </form:select>
            <br>

            <%-- MÉDICO --%>
            <form:label path="medico">Medico: </form:label>
            <form:select path="medico.id" required="true">
                <option selected disabled>Selecione o médico</option>
                <c:forEach items="${medicos}" var="m">
                    <option value="${m.id}">${m.nome} - ${m.especialidade}</option>
                </c:forEach>
            </form:select>
            <br>

            <%-- DATA DA CONSULTA --%>
            <form:label path="data">Data da Consulta: </form:label>
            <form:input path="data" type="date"/>
            <br>

            <%-- HORA DA CONSULTA --%>
            <form:label path="hora">Horas da consulta: </form:label>
            <form:input path="hora" type="time" />
            <br>

            <%-- CASO --%>
            <form:label path="caso">Caso: </form:label><br>
            <form:textarea path="caso" type="text"/>
            <br>
            <button type="submit" class="btn btn-primary" value="cadastrar">
                Marcar
            </button>
        </form:form>
    </body>
</html>
