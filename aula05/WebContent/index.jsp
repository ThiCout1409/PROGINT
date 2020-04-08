<%@pagelanguage="java"contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@pageimport="model.Pais"%>
<!DOCTYPEhtml>
<htmllang="pt-br">
<head>
<metacharset="utf-8">
<metahttp-equiv="X-UA-Compatible"content="IE=edge">
<metaname="viewport"content="width=device-width, initial-scale=1">
<title>VisualizarPais</title>
<linkhref="css/bootstrap.min.css"rel="stylesheet">
<linkhref="css/style.css"rel="stylesheet">
</head>

<body>
<%Pais Pais=(Pais)request.getAttribute( "Pais"); %>
<!-- Barra superior comos menus denavegação -->
<!-- Container Principal -->
<divid="main"class="container">
<h3class="page-header">VisualizarPais #<%=pais.getId() %></h3>
<divclass="row">
<divclass="col-md-12">
<p><strong>Nome</strong>
</p>
<p>

<%=Pais.getNome() %>
</p>
</div>
</div>
<divclass="row">
<divclass="col-md-6">
<p><strong>População</strong>
</p>
<p>

<%=Pais.getPopulacao() %>
</p>
</div>
<divclass="col-md-6">
<p><strong>Area</strong>
</p>
<p>

<%=Pais.getArea() %>
</p>
</div>
</div>
<hr/>
<divid="actions"class="row">
<divclass="col-md-12">
<ahref="index.html"class="btn btn-default">Voltar</a>
</div>
</div>
</div>
<scriptsrc="js/jquery.min.js"></script>
<scriptsrc="js/bootstrap.min.js"></script>
</body>
</html>