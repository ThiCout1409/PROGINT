package aula02;

public class paisfunc {


		public static void create(paisTO to) {
			paisDAO.create(to);
		}
		
		public static paisTO read(int id) {
			return paisDAO.read(id);
		}
		
		public static void update(int id, paisTO to) {
			paisDAO.update(id, to);
		}
		
		public static void delete(int id) {
			paisDAO.delete(id);
		}
		
		public static paisTO maiorPopulacao() {
			return paisDAO.maiorPopulacao();
		}
		
		public static paisTO menorArea() {
			return paisDAO.menorArea();
		}
		
		public static pais[] trespaises() {
			return paisDAO.trespaises();
		}
	}