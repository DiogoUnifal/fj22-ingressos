<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">
        <c:set var="bindingResult" value="${requestScope['org.springframework.validation.BindingResult.terreno']}"/>

        <form action='/admin/terreno' method="post">
            <input type="hidden" name="id" value="${terreno.id}">

            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <input id="descricao" type="text" name="descricao" class="form-control" value="${terreno.descricao}">
                <c:forEach items="${bindingResult.getFieldErrors('descricao')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>
            
            <div class="form-group">
                <label for="quadra">Quadra:</label>
                <input id="quadra" type="text" name="quadra" class="form-control" value="${terreno.quadra}">
                <c:forEach items="${bindingResult.getFieldErrors('quadra')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>
            
            <div class="form-group">
                <label for="frente">Frente (m):</label>
                <input id="frente" type="text" name="frente" class="form-control" value="${terreno.frente}">
                <c:forEach items="${bindingResult.getFieldErrors('frente')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>
            
            <div class="form-group">
                <label for="frente">Largura (m):</label>
                <input id="largura" type="text" name="largura" class="form-control" value="${terreno.largura}">
                <c:forEach items="${bindingResult.getFieldErrors('largura')}" var="error">
                    <span class="text-danger">${error.defaultMessage}</span>
                </c:forEach>
            </div>

           


            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
        </div>
    </jsp:body>
</ingresso:template>
