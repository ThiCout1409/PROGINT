package aula08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static Usuario validar (Usuario user){
		
		String sqlInsert = "SELECT * from usuario where login=? and senha=?";
		Usuario u = new Usuario();
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, user.getLogin());
			stm.setString(2, user.getSenha());
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
				
				if(rs.next()) {
					u.setId(rs.getInt(1));
					u.setNome(rs.getString(2));
					u.setSenha(rs.getString(3));
					u.setLogin(rs.getString(4));
				}
					
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return u;
	}
	
	public static void criar (Usuario user){
		String sqlInsert = "INSERT INTO usuario(Nome, Senha, Login) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, user.getNome());						
			stm.setString(2, user.getSenha());
			stm.setString(3, user.getLogin());
			stm.execute();
			
			conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}