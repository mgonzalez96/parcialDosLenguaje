package com.mariana.parcialDos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariana.parcialDos.dto.Producto;
import com.mariana.parcialDos.repository.ProductoRepositoryImpl;

@Service
public class ProductoServiceImpl implements ProductoService {

	public List<Producto> listaProducto = new ArrayList<>();

	@Autowired
	ProductoRepositoryImpl productoRepositoryImpl;

	// ---------------- CRUD CON BD -------------------------------------//

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la base de datos parcialDos
	 */
	@Override
	public Integer agregarProductoBD(Producto producto) throws Exception {
		return productoRepositoryImpl.agregarProductoBD(producto);
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos creados en la base de datos parcialDos
	 */
	@Override
	public List<Producto> listAllProductoBD() throws Exception {
		return productoRepositoryImpl.listAllProductoBD();
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo de la BD parcialDos
	 */
	@Override
	public Producto obtenerProductoByIdBD(Producto producto) throws Exception {
		return productoRepositoryImpl.obtenerProductoByIdBD(producto);
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto de la BD parcialDos
	 */
	@Override
	public Integer actualizarProductoBD(Producto producto) throws Exception {
		return productoRepositoryImpl.actualizarProductoBD(producto);
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto de la tabla Producto en la BD parcialDos
	 */
	@Override
	public Integer eliminarProductoBD(Integer codigo) throws Exception {
		return productoRepositoryImpl.eliminarProductoBD(codigo);
	}

	// ------------------------ CRUD SIN BD -----------------------------//

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	@Override
	public Integer agregarProducto(Producto producto) throws Exception {
		try {
			listaProducto.add(producto);
			if (!listaProducto.isEmpty()) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.err.println("Exception ProductoServiceImpl agregarProducto: " + e.toString());
			return 0;
		}
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	@Override
	public List<Producto> listAllProducto() throws Exception {
		try {
			return listaProducto;
		} catch (Exception e) {
			System.err.println("Exception ProductoServiceImpl listAllProducto: "+e.toString());
			return new ArrayList<>();
		}		
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	@Override
	public Producto obtenerProductoById(Producto producto) throws Exception {
		try {
			Producto product = new Producto();
			if (!listaProducto.isEmpty()) {
				for (Producto prod : listaProducto) {
					if (prod.getProdcodi() == producto.getProdcodi()) {
						product = prod;
						break;
					}
				}
				return product;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("Exception ProductoServiceImpl obtenerProductoById: " + e.toString());
			return null;
		}
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	@Override
	public String actualizarProducto(Producto producto) throws Exception {
		Producto producto2 = new Producto();
		try {
			for (Producto prod : listaProducto) {
				if (prod.getProdcodi() == producto.getProdcodi()) {
					prod.setProdnomb(producto.getProdnomb());
					prod.setProdprec(producto.getProdprec());
					producto2 = prod;
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Exception ProductoServiceImpl actualizarProducto: " + e.toString());
			return "";
		}
		return producto2.toString();
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	@Override
	public void eliminarProducto(Integer codigo) throws Exception {
		try {
			listaProducto.removeIf(producto -> producto.getProdcodi() == codigo);

			for (Producto prod : listaProducto) {
				System.out.println(prod.toString());
			}
		} catch (Exception e) {
			System.err.println("Exception ProductoServiceImpl eliminarProducto: " + e.toString());
		}
	}

}
