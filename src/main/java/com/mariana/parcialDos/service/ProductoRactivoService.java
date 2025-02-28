package com.mariana.parcialDos.service;

import com.mariana.parcialDos.dto.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRactivoService {
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	public Mono<Integer> agregarProducto(Producto producto) throws Exception;
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	public Flux<Producto> listAllProducto() throws Exception;
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	public Mono<Producto> obtenerProductoById(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	public Mono<String> actualizarProducto(Producto producto) throws Exception;

	/**
	 * @return 
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	public void eliminarProducto(Integer codigo) throws Exception;

}
