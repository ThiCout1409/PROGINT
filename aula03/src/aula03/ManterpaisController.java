package aula03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.pais;
import service.paisService;
@WebServlet("/Manterpais.do")
public class ManterpaisController extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException { doPost(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
}

String pNome = request.getParameter("nome");
long parseLong(pPoulacao) = request.getParameter("populacao");
double pArea = request.getParameter("area");
//instanciar o javabean
pais pais = new pais();
pais.setNome(pNome);
pais.setPopulacao(pPopulacao);
pais.setArea(pArea);
//instanciar o service
paisService cs = newpaisService();
cs.criar(pais);
pais = cs.carregar(pais.getId());
PrintWriter out = response.getWriter();
out.println("<html><head><title>paisCadastrado</title></head><body>");
out.println( "id: "+pais.getId()+"<br>");
out.println( "nome: "+pais.getNome()+"<br>");
out.println( "fone: "+pais.getArea()+"<br>");
out.println( "e-mail: "+pais.getPopulacao()+"<br>");
out.println("</body></html>");
}
}