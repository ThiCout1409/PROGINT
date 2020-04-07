<%@pagelanguage="java"contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@pageimport="pais"%>
<!DOCTYPEhtml>
<html>
<head>
<metahttp-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>Pais</title>

</head>
<body>
<%Pais Pais = (Pais)request.getAttribute("Pais"); %>
Id: <%=Pais.getId() %><br>
Nome: <%=Pais.getNome() %><br>
Populacao: <%=Pais.getPopulacao() %><br>
Area: <%=Pais.getArea() %><br>
</body>
</html>