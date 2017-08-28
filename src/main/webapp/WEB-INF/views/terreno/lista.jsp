<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<ingresso:template>
	<jsp:body>
		<div class=" col-md-6 col-md-offset-3">
		<table class="table table-hover ">
			<thead>
				<tr>
					<th>Descrição</th>
					<th>Quadra</th>
					<th>Frente (m)</th>
					<th>Largura (m)</th>
					<th colspan="2" class="text-center">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="terreno" items="${terrenos}">
					<tr>
						<td>${terreno.descricao}</td>
						<td>${terreno.quadra}</td>
						<td>${terreno.frente}</td>
						<td>${terreno.largura}</td>
						<td>
                        <a href="/admin/terreno/${terreno.id}" class="btn btn-info">Alterar</a>
                    </td>
						<td>
							<a onclick="excluir(${terreno.id})" class="btn btn-danger">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-md-6 col-md-offset-3">
			<a href="/admin/terreno" class="btn btn-block btn-info">Novo</a>
		</div>
		</div>
		<script>
			function excluir(id) {
				var url = window.location.href;
				$.ajax({
					url:"/admin/terreno/" + id,
					type: 'DELETE',
					success: function (result) {
						console.log(result);

						window.location.href = url;
					}
				});
			}
		</script>
	</jsp:body>
</ingresso:template>