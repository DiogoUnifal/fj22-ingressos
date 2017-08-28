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
					
					<th colspan="2" class="text-center">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="quadra" items="${quadras}">
					<tr>
						<td>${quadra.descricao}</td>
						
						<td>
                        <a href="/admin/quadra/${quadra.id}" class="btn btn-info">Alterar</a>
                    </td>
						<td>
							<a onclick="excluir(${quadra.id})" class="btn btn-danger">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-md-6 col-md-offset-3">
			<a href="/admin/quadra" class="btn btn-block btn-info">Novo</a>
		</div>
		</div>
		<script>
			function excluir(id) {
				var url = window.location.href;
				$.ajax({
					url:"/admin/quadra/" + id,
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