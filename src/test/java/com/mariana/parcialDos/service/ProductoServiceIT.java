package com.mariana.parcialDos.service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import com.mariana.parcialDos.dto.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@TestMethodOrder(OrderAnnotation.class)
public class ProductoServiceIT {

	@Autowired
	ProductoRactivoServiceImpl productoRactivoService;

	@BeforeEach
	public void setUp() throws Exception {
		productoRactivoService = new ProductoRactivoServiceImpl();
		productoRactivoService.listAllProducto().subscribe();
	}

	@Test
	@Order(1)
	public void agregarProducto() throws Exception {
		Producto producto = new Producto(1, "Producto 1", 1000);
		Mono<Integer> resultado = productoRactivoService.agregarProducto(producto);

		StepVerifier.create(resultado).expectNext(producto.getProdcodi()).verifyComplete();
	}

	@Test
	@Order(2)
	public void testListAllProducto() throws Exception {
		Producto producto1 = new Producto(1, "Producto 1", 100.0);
		Producto producto2 = new Producto(2, "Producto 2", 200.0);
		productoRactivoService.agregarProducto(producto1).block();
		productoRactivoService.agregarProducto(producto2).block();

		Flux<Producto> productosFlux = productoRactivoService.listAllProducto();

		StepVerifier.create(productosFlux).expectNext(producto1).expectNext(producto2).verifyComplete();
	}

	@Test
	@Order(3)
	public void obtenerProductoById() throws Exception {
		Producto producto = new Producto(1, "Producto 1", 100.0);
		productoRactivoService.agregarProducto(producto).block();

		Mono<Producto> productoMono = productoRactivoService.obtenerProductoById(producto);

		StepVerifier.create(productoMono).expectNext(producto).verifyComplete();
	}

	@Test
	@Order(4)
	public void actualizarProducto() throws Exception {
		Producto producto = new Producto(1, "Producto 2", 1000);
		productoRactivoService.agregarProducto(producto).block();

		Producto productoActualizado = new Producto(1, "Producto Actualizado", 15000);
		Mono<String> resultado = productoRactivoService.actualizarProducto(productoActualizado);

		StepVerifier.create(resultado).expectNext(productoActualizado.toString()).verifyComplete();
	}

	@Test
	@Order(5)
	public void eliminarProducto() throws Exception {
		Producto producto = new Producto(1, "Producto 1", 3500);
		productoRactivoService.agregarProducto(producto).block();

		productoRactivoService.eliminarProducto(producto.getProdcodi());

		Flux<Producto> productosFlux = productoRactivoService.listAllProducto();

		StepVerifier.create(productosFlux).expectNext(producto).verifyComplete();
	}

}
