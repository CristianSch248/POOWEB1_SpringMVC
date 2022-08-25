<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 16/08/2022
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Historico de Consultas</title>
    </head>
    <body>
    <a href="/app_postoDeSaude/paciente/home">HOME</a>
        <form method="post" action="/app_postoDeSaude/paciente/historico">
            <label path="paciente">Paciente: </label>
            <select name="id" required="true">
                <option selected disabled>Selecione o paciente</option>
                <c:forEach items="${pacientes}" var="p">
                    <option value="${p.id}">${p.nome} - ${p.cpf}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary" value="cadastrar">
                Mostrar Histórico
            </button>
        </form>
        <c:if test="${not empty consultas != null}">
            <h1>${consulta.paciente.nome}</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>Medico: </th>
                            <th>Caso: </th>
                            <th>Data: </th>
                            <th>Hora: </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${consultas}" var="consulta">
                            <tr>
                                <td>${consulta.medico.nome}</td>
                                <td>${consulta.caso}</td>
                                <td>${consulta.data}</td>
                                <td>${consulta.hora}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>
