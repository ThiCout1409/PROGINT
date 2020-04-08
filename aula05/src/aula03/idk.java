package aula03;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class ManterpaisController
*/
@WebServlet("/Manterpais.do")
public class idk extends HttpServlet {
private static final long serialVersionUID = 1L;
/**

* @see HttpServlet#doGet(HttpServletRequest request,
HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
doPost(request, response);
}
/**
* @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {

String pNome = request.getParameter("nome");
String pPopulacao = request.getParameter("Populacao");
String pArea = request.getParameter("Area");
String acao = request.getParameter("acao");
//instanciar o javabean
pais pais = new pais();
pais.setNome(pNome);
pais.setPopulacao(pPopulacao);
pais.setArea(pArea);
//instanciar o service
paisDAO cs = new paisDAO();
RequestDispatcher dispatcher = null;
switch(acao){
case "Incluir":
cs.create(pais);
pais = cs.read(pais.getId());
//manda parametro para o JSP via request
request.setAttribute("pais", pais);
dispatcher =

request.getRequestDispatcher("pais.jsp");

break;
case "Listar":
ArrayList<pais> paiss = cs.trespaises();
request.setAttribute("paiss", paiss);
dispatcher =

request.getRequestDispatcher("ListaDepaiss.jsp");

}
//despachar para o JSP correto
dispatcher.forward(request, response);
}
}