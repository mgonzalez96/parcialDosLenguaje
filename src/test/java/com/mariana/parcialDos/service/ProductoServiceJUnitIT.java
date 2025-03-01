package com.mariana.parcialDos.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.mariana.parcialDos.dto.Producto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@EnableAutoConfiguration
class ProductoServiceJUnitIT {

	@Autowired
	ProductoServiceImpl productoServiceImpl;

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

	// ------------- TEST CONEXION BD ------------------------------//

	@Test
	@Order(1)
	void agregarProductoBD() throws Exception {
		Producto producto = new Producto();
		producto.setProdcodi(1);
		producto.setProdnomb("Producto Test");
		producto.setProdprec(1000);
		assertNotNull(productoServiceImpl.agregarProductoBD(producto), "Producto creado correctamente");
	}

	@Test
	@Order(2)
	void listAllProductoBD() throws Exception {
		List<Producto> lista = new ArrayList<>();
		lista = productoServiceImpl.listAllProductoBD();
		assertTrue(!lista.isEmpty(), "Productos consultados correctamente");
	}

	@Test
	@Order(3)
	void obtenerProductoByIdBD() throws Exception {
		Producto producto = new Producto();
		producto.setProdcodi(1);
		assertNotNull(productoServiceImpl.obtenerProductoByIdBD(producto), "Producto consultado correctamente");
	}

	@Test
	@Order(4)
	void actualizarProductoBD() throws Exception {
		Producto producto = new Producto();
		producto.setProdcodi(1);
		producto.setProdnomb("Producto Test Update");
		producto.setProdprec(5000);
		assertNotNull(productoServiceImpl.actualizarProductoBD(producto), "Producto actualizado correctamente");
	}

	@Test
	@Order(5)
	void eliminarProductoBD() throws Exception {
		assertNotNull(productoServiceImpl.eliminarProductoBD(1), "Producto eliminado correctamente");
	}

	// ---------------- TEST SIN BD --------------------------------//

	@Test
	@Order(6)
	void agregarProducto() throws Exception {
		Producto producto = new Producto();
		producto.setProdcodi(1);
		producto.setProdnomb("Producto Test");
		producto.setProdprec(1000);
		assertNotNull(productoServiceImpl.agregarProducto(producto), "Producto creado correctamente");
	}

	@Test
	@Order(7)
	void listAllProducto() throws Exception {
		List<Producto> lista = new ArrayList<>();
		lista = productoServiceImpl.listAllProducto();
		assertTrue(!lista.isEmpty(), "Productos consultados correctamente");
	}

	@Test
	@Order(8)
	void obtenerProductoById() throws Exception {
		Producto producto = new Producto();
		producto.setProdcodi(1);
		assertNotNull(productoServiceImpl.obtenerProductoById(producto), "Producto consultado correctamente");
	}

	@Test
	@Order(9)
	void actualizarProducto() throws Exception {
		Producto producto = new Producto();
		producto.setProdcodi(1);
		producto.setProdnomb("Producto Test Update");
		producto.setProdprec(5000);
		assertNotNull(productoServiceImpl.actualizarProducto(producto), "Producto actualizado correctamente");
	}

	@Test
	@Order(10)
	void eliminarProducto() throws Exception {
		productoServiceImpl.eliminarProducto(1);
		assertNotNull("Producto eliminado correctamente");
	}

}
