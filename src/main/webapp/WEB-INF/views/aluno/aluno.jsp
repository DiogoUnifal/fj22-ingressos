<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.aluno']}"/>

        <form action='/admin/aluno' method="post">
            <input type="hidden" name="id" value="${aluno.id}">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" class="form-control" value="${aluno.nome}">
                <c:forEach items="${bindingResult.getFieldErrors('nome')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>

           


            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
        </div>
    </jsp:body>
</ingresso:template>
