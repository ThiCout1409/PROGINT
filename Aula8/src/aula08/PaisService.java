package aula08;

import java.util.ArrayList;

public class PaisService {

	public static void create(Pais pais) {
		PaisDAO.create(pais);
	}
	
	public static Pais read(int id) {
		return PaisDAO.read(id);
	}
	
	public static Pais read(String nome) {
		return PaisDAO.read(nome);
	}
	
	public static void update(int id, Pais pais) {
		PaisDAO.update(id, pais);
	}
	
	public static void delete(int id) {
		PaisDAO.delete(id);
	}
	
	public static ArrayList<Pais> listaPaises(){
		return PaisDAO.listaPaises();
	}
	
	public static ArrayList<Pais> listaPaises(String chave){
		return PaisDAO.listaPaises(chave);
	}
}
