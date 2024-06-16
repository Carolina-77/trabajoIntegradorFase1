package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    static final String URL = "jdbc:mysql://localhost:3306/SMCOMPUTACION";
    static final String USUARIO = "root";
    static final String CONTRASEÑA = "valen2812";
    static Connection miConexion = null;

    public static Connection conectar() {
	try {

	    miConexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
	    System.out.println("Conexion exitosa");

	} catch (SQLException e) {

	    System.out.println("Error de conexion a la base de datos");
	    e.printStackTrace();

	} finally {

	    System.out.println("conexion realizada exitosamente");
	}

	return miConexion;

    }

}
