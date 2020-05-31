package aula08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;

		String acao = request.getParameter("acao");

		if(acao.equals("Login")) {

			String login = request.getParameter("login");  
			String senha = request.getParameter("senha");

			Usuario user = new Usuario();
			user.setLogin(login);
			user.setSenha(senha);

			user = LoginService.validarUsuario(user);

			if(user.getNome() == null) {
				dispatcher = request.getRequestDispatcher("index.jsp");
				Log log = new Log();
				log.abrir(Log.NOME_REJEITADO);
				log.escrever("Login rejeitado. Credenciais: Login = " + login);
				log.fechar();
			}else {
				dispatcher = request.getRequestDispatcher("Lista.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("nome", user.getNome());
				Log log = new Log();
				log.abrir(Log.NOME_ACEITO);
				log.escrever("Login Aceito. Credenciais: Login = " + login);
				log.fechar();
			}

			
		}else if(acao.equals("Cadastre-se")){
			
			String login = request.getParameter("login");  
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			
			Usuario user = new Usuario();
			user.setLogin(login);
			user.setSenha(senha);
			user.setNome(nome);
			
			
			LoginDAO.criar(user);
			
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		dispatcher.forward(request, response);
        
	}

}