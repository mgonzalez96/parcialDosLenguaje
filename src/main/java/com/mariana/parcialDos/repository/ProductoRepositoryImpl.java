package com.mariana.parcialDos.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.mariana.parcialDos.dto.Producto;

@Repository
public class ProductoRepositoryImpl extends JdbcDaoSupport {

	public ProductoRepositoryImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Agrega un producto a la lista de productos
	 */
	public Integer agregarProductoBD(Producto producto) throws Exception {
		try {
			String SQL = " INSERT INTO public.producto( "
					+ "	prodcodi, prodnomb, prodprec) "
					+ "	VALUES (?, ?, ?) ";

			PreparedStatementSetter setter = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, producto.getProdcodi());
					ps.setString(2, producto.getProdnomb());
					ps.setDouble(3, producto.getProdprec());
				}
			};
			return getJdbcTemplate().update(SQL, setter);
		} catch (Exception e) {
			System.err.println("Exception ProductoRepositoryImpl agregarProductoBD: " + e.toString());
			e.printStackTrace();
			throw new Exception("Producto ya existe");
		}
	}
//----------------------------------------------------------------------------

	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Muestra todos los productos en la lista
	 */
	public List<Producto> listAllProductoBD() throws Exception {
		try {
			String SQL = " SELECT * FROM public.producto ";
			return getJdbcTemplate().query(SQL, listAllProductoMapper);
		} catch (Exception e) {
			System.err.println("Exception ProductoRepositoryImpl listAllProductoBD: " + e.toString());
			throw new Exception("No existen productos");
		}
	}

	private RowMapper<Producto> listAllProductoMapper = new RowMapper<Producto>() {
		@Override
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			var producto = new Producto();
			producto.setProdcodi(rs.getInt(1));
			producto.setProdnomb(rs.getString(2));
			producto.setProdprec(rs.getDouble(3));
			return producto;
		}
	};

//----------------------------------------------------------------------------
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Retorna un producto por codigo
	 */
	public Producto obtenerProductoByIdBD(Producto producto) throws Exception {
		try {
			String SQL = " SELECT prodcodi, prodnomb, prodprec  " + "	FROM public.producto  "
					+ " WHERE prodcodi = ? ";
			return getJdbcTemplate().queryForObject(SQL, obtenerProductoByIdRowMapper, producto.getProdcodi());
		} catch (Exception e) {
			System.err.println("Exception ProductoRepositoryImpl obtenerProductoByIdBD: " + e.toString());
			throw new Exception("Producto no existe, valide el código ingresado");
		}
	}

	private RowMapper<Producto> obtenerProductoByIdRowMapper = new RowMapper<Producto>() {
		@Override
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			var producto = new Producto();
			producto.setProdcodi(rs.getInt(1));
			producto.setProdnomb(rs.getString(2));
			producto.setProdprec(rs.getDouble(3));
			return producto;
		}
	};

//------------------------------------------------------------------------------
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Actualiza los datos de un producto
	 */
	public Integer actualizarProductoBD(Producto producto) throws Exception {
		try {
			String SQL = " UPDATE public.producto   " + "	SET prodnomb=?, prodprec=?   " + "	WHERE prodcodi=? ";

			PreparedStatementSetter setter = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, producto.getProdnomb());
					ps.setDouble(2, producto.getProdprec());
					ps.setInt(3, producto.getProdcodi());
				}
			};
			return getJdbcTemplate().update(SQL, setter);
		} catch (Exception e) {
			System.err.println("Exception ProductoRepositoryImpl actualizarProductoBD: " + e.toString());
			throw new Exception("Producto no existe");
		}
	}

//------------------------------------------------------------------------------
	/**
	 * @Autor: Mariana Acevedo
	 * @Fecha: 26/02/2025
	 * @Descripcion: Elimina un producto
	 */
	public Integer eliminarProductoBD(Integer codigo) throws Exception {
		try {
			String SQL = " DELETE FROM public.producto WHERE prodcodi=? ";

			PreparedStatementSetter setter = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, codigo);
				}
			};
			return getJdbcTemplate().update(SQL, setter);
		} catch (Exception e) {
			System.err.println("Exception ProductoRepositoryImpl eliminarProductoBD: " + e.toString());
			throw new Exception("Producto no existe");
		}
	}
}
