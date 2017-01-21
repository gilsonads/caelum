<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>


<!DOCTYPE html>
<html>

<head>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<h1> Adiciona Contato</h1>
<hr />
<form action="AdicionaContato">
Nome:<input type ="text" name="nome" /><br/>
E-mail:<input type = "text" name="email" /><br />
Endereço:<input type = "text" name="endereco" /><br />
Data Nascimento: <caelum:campoData id="dataNascimento" /><br />

<!--  Data Nascimento: <input type="text" name="dataNascimento" /><br />-->

<input type = "submit" value = "Gravar"/>
</form>
<c:import url ="rodape.jsp"/>
</body>
</html>