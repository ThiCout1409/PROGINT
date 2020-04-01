package aula01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final String database = "pais";
	private static final String username = "root";
	private static final String password = "1234";

	private static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=" + username + "&password=" + password);
	}
	
	public static void create (pais pais){
		String sqlInsert = "INSERT INTO pais(idpais, Nome, Populacao, Area) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong(3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
			stm.execute();
			
			conn.close();
			
			System.out.println("pais " + pais.getNome() + " adicionado com sucesso!");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static pais read (String nome) {
		
		String sqlSelect = "SELECT * FROM pais WHERE Nome = ?";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			stm.setString(1, nome);
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
	
				if(rs.next()) 
					return new pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar o pais");
		
		return new pais();
	}
	
	public static void delete(String nome) {
		
		String sqlDelete = "DELETE FROM pais.pais WHERE Nome = ?";
		
		try(Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			
			stm.setString(1, nome);
			stm.execute();
			
			conn.close();
			
			System.out.println("pais " + nome + " deletado com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void update (String nomeAntigo, pais paisNovo) {
		
		String sqlUpdate = "UPDATE pais SET Nome = ?, Populacao = ?, Area = ? WHERE nome = ?";
		
		try(Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			
			stm.setString(1, paisNovo.getNome());
			stm.setLong(2, paisNovo.getPopulacao());
			stm.setDouble(3, paisNovo.getArea());
			stm.setString(4, nomeAntigo);
			stm.execute();
			
			conn.close();
			
			System.out.println("O pais " + nomeAntigo + " foi atualizado para " + paisNovo);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				
		
	}
	
	public static pais maiorPopulacao() {
		String sqlMaiorPopulacao = "SELECT * FROM pais.pais ORDER BY Populacao DESC LIMIT 1";
		
		try(Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlMaiorPopulacao);){
			
			try(ResultSet rs = stm.executeQuery()){
				
				if(rs.next())
					return new pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar");
		return new pais();
		
	}
	
	public static pais menorArea() {
		
		String sqlMenorArea = "SELECT * FROM pais.pais ORDER BY Area ASC LIMIT 1";
		
		try(Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlMenorArea);){
			
			try(ResultSet rs = stm.executeQuery();){
				
				if(rs.next())
					return new pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
					
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar");
		return new pais();
	}
	
	public static pais[] trespaises() {
		
		String sqlTrespaises = "SELECT * FROM pais.pais";
		pais paises[] = new pais[3];
		
		try(Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlTrespaises);){
			
			try(ResultSet rs = stm.executeQuery()){
				
				for(int i = 0; i < 3; i++) {
					if(rs.next()) {
						paises[i] = new pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
					}
					else
						System.out.println("Nao foi possivel ler o pais " + i);
				}
				
				return paises;
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paises;
	}
	
}