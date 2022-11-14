package es.dominguez.inigo.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	private Connection connex = null;

	public Connection Conectar() {
		
		try {
			String conexion="jdbc:mysql://localhost:8889/tesicnor_peliculas";
			connex =DriverManager.getConnection(conexion,"estandar","1234");
		} catch (SQLException e) {
			Utils.escribirLog("Error de conexion"+e.getMessage());
			e.printStackTrace();
			System.err.println("Error de conexion");
		}

		return connex;
	}

	public void Desconectar() {
		try {
			connex.close();
		} catch (SQLException e) {
			Utils.escribirLog("Error de desconexion"+e.getMessage());
			e.printStackTrace();
			
		}
	}
	

}
