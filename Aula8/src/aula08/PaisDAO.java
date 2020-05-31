package aula08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO {

	public static void create (Pais pais){
		String sqlInsert = "INSERT INTO pais(idPais, Nome, Populacao, Area) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong(3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
			stm.execute();
			
			conn.close();
			
			System.out.println("Pais " + pais.getNome() + " adicionado com sucesso!");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static Pais read (int id) {
		
		String sqlSelect = "SELECT * FROM Pais WHERE idPais = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			stm.setInt(1, id);
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
	
				if(rs.next()) 
					return new Pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar o pais");
		
		return new Pais();
	}
	
	public static Pais read (String nome) {
		
		String sqlSelect = "SELECT * FROM Pais WHERE nome = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			stm.setString(1, nome);
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
	
				if(rs.next()) 
					return new Pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar o pais");
		
		return new Pais();
	}
	
	public static void delete(int id) {
		
		String sqlDelete = "DELETE FROM pais.pais WHERE idPais = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			
			stm.setInt(1, id);
			stm.execute();
			
			conn.close();
			
			System.out.println("Pais deletado com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void update (int id, Pais paisNovo) {
		
		String sqlUpdate = "UPDATE pais SET Nome = ?, Populacao = ?, Area = ? WHERE idPais = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			
			stm.setString(1, paisNovo.getNome());
			stm.setLong(2, paisNovo.getPopulacao());
			stm.setDouble(3, paisNovo.getArea());
			stm.setInt(4, id);
			stm.execute();
			
			conn.close();
			
			System.out.println("O pais foi atualizado para " + paisNovo);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				
		
	}
	
	public static ArrayList<Pais> listaPaises(){
		
		String sqlListaPaises = "SELECT * FROM pais.pais";
		ArrayList<Pais> paises = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlListaPaises);){
			
			try(ResultSet rs = stm.executeQuery();){
				
				while(rs.next()) 
					paises.add(new Pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4)));
						
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paises;
	}
	
	public static ArrayList<Pais> listaPaises(String chave) {
		ArrayList<Pais> paises = new ArrayList<>();
		
		String sqlSelect = "SELECT * FROM pais.pais where upper(nome) like ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					paises.add(new Pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4)));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return paises;
	}
	
}