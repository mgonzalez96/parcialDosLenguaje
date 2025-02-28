package com.mariana.parcialDos.service;

import java.util.List;

import com.mariana.parcialDos.dto.Producto;

public interface ProductoService {

	//---------------- CRUD CON BD -------------------------------------//
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la base de datos parcialDos
	 */
	public Integer agregarProductoBD(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos creados en la base de datos parcialDos
	 */
	public List<Producto> listAllProductoBD() throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo de la BD parcialDos
	 */
	public Producto obtenerProductoByIdBD(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto de la BD parcialDos
	 */
	public Integer actualizarProductoBD(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto de la tabla Producto en la BD parcialDos
	 */
	public Integer eliminarProductoBD(Integer codigo) throws Exception;
	
	//------------------------ CRUD SIN BD -----------------------------//
	
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	public Integer agregarProducto(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	public List<Producto> listAllProducto() throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	public Producto obtenerProductoById(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	public String actualizarProducto(Producto producto) throws Exception;

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	public void eliminarProducto(Integer codigo) throws Exception;
	

}
