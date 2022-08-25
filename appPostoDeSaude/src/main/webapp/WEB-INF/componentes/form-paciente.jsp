<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 31/07/2022
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form method="post" action="/app_postoDeSaude/paciente/cadastrar" modelAttribute="paciente">
    <form:label path="nome">Nome: </form:label>
    <form:input path="nome" value="${paciente.nome}" type="text" />
    <br>
    <form:label path="idade">Idade: </form:label>
    <form:input path="idade" value="${paciente.idade}" type="number" />
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
    <form:input path="cpf" value="${paciente.cpf}" type="cpf" />
    <br>
    <form:label path="telefone">telefone: </form:label>
    <form:input path="telefone" value="${paciente.telefone}" type="telefone" />
    <br>
    <button type="submit" class="btn btn-primary" value="cadastrar">
        Cadastrar
    </button>
</form:form>