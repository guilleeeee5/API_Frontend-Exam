package es.ufv.dis.final22.back.grc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SpringBootTest
class GrcApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void CrearProductoTest(){
		Producto Juancho = new Producto("Juancho", "nombre" ,(float)3.56 ,"12783747384");
		Assert.assertNotNull(Juancho);
	}
	@Test
	void AniadirProductoTest(){
		DataHanding data = new DataHanding();
		Producto Juancho = new Producto("Juancho", "nombre" ,(float)3.56 ,"12783747384");
		int contador = 0;
		LeerJson reader = new LeerJson();

		ArrayList<Producto> listaAux = reader.LeerFicheroJson1("template.json");

		listaAux = data.AnadirObjeto1(Juancho,"template.json");

		for(Producto i : listaAux)
		{
			if (data.CompararObjetos(i,Juancho))
			{
				contador = 1;
			}
		}
		if (contador == 1)
		{
			assertTrue(contador == 1);
		}
		else
		{
			fail(" No añado correctamente un objeto de tipo Producto");
		}
	}



}
