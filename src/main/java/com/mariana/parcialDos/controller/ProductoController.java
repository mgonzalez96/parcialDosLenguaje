package com.mariana.parcialDos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mariana.parcialDos.dto.Producto;
import com.mariana.parcialDos.service.ProductoService;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	//---------------- CRUD CON BD -------------------------------------//

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la base de datos parcialDos
	 */
	@PostMapping("/agregarProductoBD")
	public ResponseEntity<Integer> agregarProductoBD(@RequestBody Producto producto) throws Exception {
		return ResponseEntity.ok(productoService.agregarProductoBD(producto));
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos creados en la base de datos parcialDos
	 */
	@GetMapping("/listAllProductoBD")
	public ResponseEntity<List<Producto>> listAllProductoBD() throws Exception {
		return ResponseEntity.ok(productoService.listAllProductoBD());
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo de la BD parcialDos
	 */
	@PostMapping("/obtenerProductoByIdBD")
	public ResponseEntity<Producto> obtenerProductoByIdBD(@RequestBody Producto producto) throws Exception {
		return ResponseEntity.ok(productoService.obtenerProductoByIdBD(producto));
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto de la BD parcialDos
	 */
	@PutMapping("/actualizarProductoBD")
	public ResponseEntity<Integer> actualizarProductoBD(@RequestBody Producto producto) throws Exception {
		return ResponseEntity.ok(productoService.actualizarProductoBD(producto));
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto de la tabla Producto en la BD parcialDos
	 */
	@DeleteMapping("/eliminarProductoBD/{codigo}")
	public ResponseEntity<Integer> eliminarProductoBD(@PathVariable Integer codigo) throws Exception {
		return ResponseEntity.ok(productoService.eliminarProductoBD(codigo));
	}
	
	//------------------------ CRUD SIN BD -----------------------------//
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	@PostMapping("/agregarProducto")
	public ResponseEntity<Integer> agregarProducto(@RequestBody @Validated Producto producto) throws Exception {
		return ResponseEntity.ok(productoService.agregarProducto(producto));
	}
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	@GetMapping("/listAllProducto")
	public ResponseEntity<List<Producto>> listAllProducto() throws Exception {
		return ResponseEntity.ok(productoService.listAllProducto());
	}
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	@PostMapping("/obtenerProductoById")
	public ResponseEntity<Producto> obtenerProductoById(@RequestBody Producto producto) throws Exception {
		return ResponseEntity.ok(productoService.obtenerProductoById(producto));
	}
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	@PutMapping("/actualizarProducto")
	public ResponseEntity<String> actualizarProducto(@RequestBody Producto producto) throws Exception {
		return ResponseEntity.ok(productoService.actualizarProducto(producto));
	}
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	@DeleteMapping("/eliminarProducto/{codigo}")
	public void eliminarProducto(@PathVariable Integer codigo) throws Exception {
		productoService.eliminarProducto(codigo);
	}

}
