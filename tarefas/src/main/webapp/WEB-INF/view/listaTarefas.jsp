<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,dev.ramide.tarefas.modelo.Tarefa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Tarefas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<c:import url="nav.jsp" />
	<p>
		<c:if test="${not empty tarefa}">Tarefa ${tarefa} cadastrada com
		 sucesso!</c:if>
	</p>
	<div class="container">
	<h1 class="text-start fs-1">Suas tarefas:</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Nome</th>
				<th scope="col">Descrição</th>
				<th scope="col">Status</th>
				<th scope="col">Ações</th>
			</tr>
		</thead>

		<tbody>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>	
				<td>${tarefa.nome}</td>
				<td>${tarefa.descricao}</td>
				<td>${tarefa.status}</td>
				<td><a class="btn btn-warning btn-sm" href="/tarefas/entrada?acao=MostraTarefa&id=${tarefa.id}">editar</a>
				<a class="btn btn-danger btn-sm" href="/tarefas/entrada?acao=RemoveTarefa&id=${tarefa.id}">remover</a></td>		
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="entrada?acao=NovaTarefaForm" class="btn btn-secondary">Adicionar nova tarefa</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>