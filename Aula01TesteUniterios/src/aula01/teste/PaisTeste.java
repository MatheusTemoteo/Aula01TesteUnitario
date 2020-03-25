package aula01.teste;

import static org.junit.Assert.assertEquals;
import aula01.Pais;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, copia;
	static int id = 0;


	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais (id, "Alemanha", "83,5", "73,5");
		copia = new Pais ( );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais(1, "Brasil", "209,3" , "8.511.000" );
				Pais novo = new Pais(1,null,0,0);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setNome("");
		pais.setPopulacao("");
		pais.setArea("");
		copia.setNome("");
		copia.setPopulacao("");
		copia.setArea("");
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais, copia);
	}
}