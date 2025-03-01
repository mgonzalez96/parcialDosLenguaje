package com.mariana.parcialDos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.mariana.parcialDos.dto.Producto;
import com.mariana.parcialDos.service.ProductoRactivoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@RequestMapping("/api/v1/productoReactivo")
@RequestMapping("/api/v1")
public class ProductoReactivoController {

	@Autowired
	ProductoRactivoService prdRactivoService;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	@PostMapping(value = "/agregarProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Integer> agregarProducto(@RequestBody Producto producto) throws Exception {
		return prdRactivoService.agregarProducto(producto).onErrorResume(e -> {
			System.err.println("Exception ProductoReactivoController agregarProducto: " + e.toString());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al agregar producto", e);
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	@GetMapping(value = "/listAllProducto", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Producto> listAllProducto() throws Exception {
		return prdRactivoService.listAllProducto().onErrorResume(e -> {
			System.err.println("Exception ProductoReactivoController listAllProducto: " + e.toString());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al listar los productos", e);
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	@PostMapping(value = "/obtenerProductoById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Producto> obtenerProductoById(@RequestBody Producto producto) throws Exception {
		return prdRactivoService.obtenerProductoById(producto).onErrorResume(e -> {
			System.err.println("Exception ProductoReactivoController obtenerProductoById: " + e.toString());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Error al obtener el producto por código", e);
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	@PutMapping(value = "/actualizarProducto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> actualizarProducto(@RequestBody Producto producto) throws Exception {
		return prdRactivoService.actualizarProducto(producto).onErrorResume(e -> {
			System.err.println("Exception ProductoReactivoController actualizarProducto: " + e.toString());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar el producto", e);
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	@DeleteMapping(value = "/eliminarProducto/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarProducto(@PathVariable Integer codigo) throws Exception {
		prdRactivoService.eliminarProducto(codigo);
	}

}
