package aula01;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testpaisTest {

	pais principal, copia, menorArea;
	static int id = 5;
	
	@Before
	public void setup() {
		System.out.println("Setup");
		principal = new pais (id, "Franca", 60390560, 301338.0);
		copia = new pais (id, "Franca", 60390560, 301338.0);
	}
	
	@Test
	public void testRead() {
		System.out.println("Carregar teste");
		pais fixture = new pais (1 , "Uganda", 40006700, 241038.0);
		pais novo = new pais ();
		
		novo = MySQL.read("Uganda");
		
		assertEquals(fixture, novo);
	}
	
	@Test
	public void testCreate() {
		System.out.println("Criar teste");
		MySQL.create(principal);
		
		assertEquals(principal, copia);
		
		
	}
	
	@Test
	public void test3Update() {
		System.out.println("Atualizar teste");
		principal.setPopulacao(666);
		copia.setPopulacao(666);
		MySQL.update("Franca", principal);
		
		assertEquals(principal, copia);
	}
	
	@Test
	public void testDel() {
		System.out.println("Apagar teste");
		
		MySQL.delete("Franca");
		principal = MySQL.read("Franca");
		pais vazio = new pais(); 
		
		assertEquals(principal, vazio);
		
		
	}
	
	@Test
	public void testMenorA() {
		System.out.println("Menor area teste");
		principal.setArea(1.0);
		copia.setArea(1.0);
		
		MySQL.create(principal);
		
		copia = MySQL.menorArea();
		
		assertEquals(principal, copia);
		
		MySQL.delete("Franca");
	}
	
	@Test
	public void testMaiorPop() {
		System.out.println("Maior Populacao teste");
		principal.setPopulacao(999999);
		copia.setPopulacao(999999);
		
		MySQL.create(principal);
		
		copia = MySQL.maiorPopulacao();
		
		assertEquals(principal, copia);
		
		MySQL.delete("USA");
		
	}
	
	@Test
	public void test7Trespaises() {
		
		pais vetor[] = MySQL.trespaises();
		pais pais[] = {new pais(1, "Croacia", 40006700, 241038.0), new pais(2, "USA", 210147125, 8515767.0), new pais(3, "China", 37373000, 9984670.0)};
		assertArrayEquals(pais, vetor);
	}
	
}
