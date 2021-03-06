<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Novo Usu?rio</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body class="container">
	<p><a href="entrada?acao=Logout" class="btn btn-info">Voltar ? tela de Login</a></p>
	
	<form action="${linkEntradaServlet}" method="post" class="row align-items-center">

		<div class="col-6">
		<label class="form-label">Primeiro Nome:</label>
		<input type="text" name="primeiroNome" class="form-control"/>
		</div>
		
		<div class="col-6">
		<label class="form-label">Ultimo Nome:</label>
		<input type="text" name="ultimoNome" class="form-control"/>
		</div>
		
		<div class="col-12">
		<label class="form-label">Usuario:</label>
		<input type="text" name="usuario" class="form-control"/>
		</div>
		
		<div class="col-12">
		<label class="form-label">Senha:</label>
		<input type="password" name="senha" class="form-control"/>
		</div>

		<input type="hidden" name="acao" value="NovoUsuario" />
		<p></p>
		<div class="d-grid gap-2 col-6 mx-auto">
			<input type="submit" class="btn btn-lg btn-primary" />
		</div>
	</form>

	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>