<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 16/08/2022
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Historico de Atendimento</title>
</head>
<body>
<a href="/app_postoDeSaude/medico/home">HOME</a>
<form method="post" action="/app_postoDeSaude/medico/historico">
        <label path="medico">Medico: </label>
        <select name="id" required="true">
            <option selected disabled>Selecione o médico</option>
            <c:forEach items="${medicos}" var="m">
                <option value="${m.id}">${m.nome} - ${m.especialidade}</option>
            </c:forEach>
        </select>
        <br>
        <button type="submit" class="btn btn-primary" value="cadastrar">
            Mostrar Histórico
        </button>
    </form>
    <c:if test="${not empty consultas != null}">
        <h1>${consulta.medico.nome}</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Paciente:</th>
                        <th>Caso:</th>
                        <th>Data:</th>
                        <th>Hora:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${consultas}" var="consulta">
                        <tr>
                            <td>${consulta.paciente.nome}</td>
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
