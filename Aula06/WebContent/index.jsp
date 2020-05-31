<%@pagelanguage="java"contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@tagliburi="http://java.sun.com/jsp/jstl/core"prefix="c"%>
<!DOCTYPEhtml>
<htmllang="pt-br">
<head>
<metacharset="utf-8">
<metahttp-equiv="X-UA-Compatible"content="IE=edge">
<metaname="viewport"content="width=device-width, initial-scale=1">
<title>cerveja.biz - CriarCliente</title>
<linkhref="css/bootstrap.min.css"rel="stylesheet">
<linkhref="css/style.css"rel="stylesheet">
</head>
<body>
<!-- Barra superior comos menus denavegacao -->
<c:importurl="Menu.jsp"/>
<!-- Container Principal -->
<divid="main"class="container">
<h3class="page-header">IncluirCliente</h3>

6

<!-- Formularioparainclusaodeclientes -->
<formaction="ManterCliente.do"method="post">
<!-- area decampos do form -->
<divclass="row">
<divclass="form-group col-md-12">
<labelfor="nome">Nome</label>

<inputtype="text"class="form-
control"name="nome"id="nome"requiredmaxlength="100"placeholder="nome completo">

</div>
</div>
<divclass="row">
<divclass="form-group col-md-6">
<labelfor="fone">Celular</label>

<inputtype="tel"class="form-
control"name="fone"id="fone"maxlength="15"pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\

d{4}"placeholder="opcional; celular com ddd no formato (99) 99999-9999">
</div>
<divclass="form-group col-md-6">
<labelfor="email">E-Mail</label>

<inputtype="email"class="form-
control"name="email"id="email"requiredmaxlength="60"placeholder="email obrigatório">

</div>
</div>
<hr/>
<divid="actions"class="row">
<divclass="col-md-12">

<buttontype="submit"class="btn btn-
primary"name="acao"value="Criar">Salvar</button>

<ahref="index.html"class="btn btn-default">Cancelar</a>
</div>
</div>
</form>
</div>
<scriptsrc="js/jquery.min.js"></script>
<scriptsrc="js/bootstrap.min.js"></script>
</body>
</html>