package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import entities.Producto;

public class ProductoDaoImplementa implements ProductoDao {

    @Override
    public void insertar(Producto producto) throws SQLException {

	Connection miConexion = ConexionBD.conectar();

	try {

	    String miQuery = " INSERT INTO producto(nombreProducto, descripcion, precioVenta, stock)  VALUES (?, ?, ?, ?) ";

	    PreparedStatement miStmt = miConexion.prepareStatement(miQuery);

	    miStmt.setString(1, producto.getNombreProducto());
	    miStmt.setString(2, producto.getDescripcion());
	    miStmt.setDouble(3, producto.getPrecioVenta());
	    miStmt.setInt(4, producto.getStock());

	    miStmt.executeUpdate();
	    System.out.println("Datos guardados correctamente");

	    // miConexion.commit();

	    miConexion.setAutoCommit(false);

	    miConexion.rollback();

	    miStmt.close();
	    miConexion.close();

	} catch (SQLException e) {

	    e.printStackTrace();
	}

    }

    @Override
    public void eliminar(int codigoProducto) {

	Connection miConexion = ConexionBD.conectar();

	try {

	    String miQuery = " DELETE FROM producto WHERE codigoProducto= ? ";

	    PreparedStatement miStmt = miConexion.prepareStatement(miQuery);

	    miStmt.setInt(1, codigoProducto);

	    miStmt.executeUpdate();
	    System.out.println("Datos borrados correctamente");

	    miConexion.setAutoCommit(false);

	    miConexion.rollback();

	    miStmt.close();
	    miConexion.close();

	} catch (SQLException e) {

	    e.printStackTrace();
	}

    }

    @Override
    public void actualizar(Producto producto) {

	Connection miConexion = ConexionBD.conectar();

	try {

	    String miQuery = "UPDATE producto SET nombreProducto=?, descripcion=?, precioVenta=?, stock=? WHERE codigoProducto=?";

	    PreparedStatement miStmt = miConexion.prepareStatement(miQuery);

	    miStmt.setString(1, producto.getNombreProducto());
	    miStmt.setString(2, producto.getDescripcion());
	    miStmt.setDouble(3, producto.getPrecioVenta());
	    miStmt.setInt(4, producto.getStock());
	    miStmt.setInt(5, producto.getCodigoProducto());

	    miStmt.executeUpdate();
	    System.out.println("Datos modificados correctamente");

	    miConexion.setAutoCommit(false);

	    miConexion.rollback();

	    miStmt.close();
	    miConexion.close();

	} catch (SQLException e) {
	    System.out.println("Error al intentar actualizar");
	    e.printStackTrace();
	}

    }

    @Override
    public Producto mostrarporcodigoProducto(int codigoProducto) {

	Connection miConexion = ConexionBD.conectar();

	try {

	    String miQuery = "SELECT * FROM producto WHERE codigoProducto = ?";

	    PreparedStatement miStmt = miConexion.prepareStatement(miQuery);

	    miStmt.setInt(5, codigoProducto);

	    ResultSet rs = miStmt.executeQuery();
	    if (rs.next()) {
		return new Producto(rs.getInt("codigoProducto"), rs.getString("nombreProducto"),
			rs.getString("descripcion"), rs.getDouble("precioVenta"), rs.getInt("stock"));
	    }

	    miStmt.close();
	    miConexion.close();

	} catch (SQLException e) {
	    System.out.println("Error al intentar actualizar");
	    e.printStackTrace();
	}

	return null;
    }

    @Override
    public List<Producto> obtenerTodos() {

	Connection miConexion = ConexionBD.conectar();

	try {

	    List<Producto> productos = new ArrayList<>();

	    String miQuery = "SELECT * FROM producto";

	    Statement miStmt = miConexion.createStatement();

	    ResultSet rs = miStmt.executeQuery(miQuery);

	    while (rs.next()) {
		productos.add(new Producto(rs.getInt("codigoProducto"), rs.getString("nombreProducto"),
			rs.getString("descripcion"), rs.getDouble("precioVenta"), rs.getInt("stock")));
	    }

	    miStmt.close();
	    miConexion.close();

	} catch (SQLException e) {
	    System.out.println("Error al intentar actualizar");
	    e.printStackTrace();
	}

	return null;
    }

}
