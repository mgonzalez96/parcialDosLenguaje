package com.mariana.parcialDos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mariana.parcialDos.dto.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoRactivoServiceImpl implements ProductoRactivoService {

	public List<Producto> listaProducto = new ArrayList<>();

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	public Mono<Integer> agregarProducto(Producto producto) {
		return Mono.fromCallable(() -> {
			listaProducto.add(producto);
			if (!listaProducto.isEmpty()) {
				return 1;
			} else {
				return 0;
			}
		}).onErrorResume(e -> {
			System.err.println("Exception ProductoRactivoServiceImpl agregarProducto: " + e.toString());
			return Mono.just(0);
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	@Override
	public Flux<Producto> listAllProducto() throws Exception {
		return Flux.fromIterable(listaProducto).onErrorResume(e -> {
			System.err.println("Exception ProductoRactivoServiceImpl listAllProducto: " + e.toString());
			return Flux.empty();
		});

	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	@Override
	public Mono<Producto> obtenerProductoById(Producto producto) {
		return Mono.fromCallable(() -> {
			if (!listaProducto.isEmpty()) {
				for (Producto prod : listaProducto) {
					if (prod.getProdcodi().equals(producto.getProdcodi())) {
						return prod;
					}
				}
			}
			return null;
		}).onErrorResume(e -> {
			System.err.println("Exception ProductoRactivoServiceImpl obtenerProductoById: " + e.toString());
			return Mono.empty();
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	@Override
	public Mono<String> actualizarProducto(Producto producto) throws Exception {
		return Mono.fromCallable(() -> {
			Producto productoActualizado = new Producto();
			for (Producto prod : listaProducto) {
				if (prod.getProdcodi().equals(producto.getProdcodi())) {
					prod.setProdnomb(producto.getProdnomb());
					prod.setProdprec(producto.getProdprec());
					productoActualizado = prod;
					break;
				}
			}
			return productoActualizado.toString();
		}).onErrorResume(e -> {
			System.err.println("Exception ProductoRactivoServiceImpl agregarProducto: " + e.toString());
			return Mono.just("No se actualizó el producto");
		});
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	@Override
	public void eliminarProducto(Integer codigo) {
		Mono.fromRunnable(() -> {
			listaProducto.removeIf(producto -> producto.getProdcodi().equals(codigo));
			listaProducto.forEach(prod -> System.out.println(prod.toString()));
		}).onErrorResume(e -> {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar producto", e);
		});
	}

}
