package es.dominguez.inigo.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.json.Utils;


public class Update {
public boolean insertar(Conexion con, int valoracion,String imdbID) {
		
		String sql = "UPDATE  Peliculas SET valoracion = ? WHERE imdbID=?";
		boolean ret= false;
		
		PreparedStatement sentencia;
		
		try {
			sentencia = con.Conectar().prepareStatement(sql);
			sentencia.setInt(1, valoracion);
			sentencia.setString(2, imdbID);
			if (sentencia.executeUpdate() == 1) {
				ret = true;
			}
			

			
		} catch (SQLException e) {
			Utils.escribirLog("Mensaje :" + e.getMessage());
			System.out.println("HA OCURRIDO UNA EXCEPCIÓNN:");
			System.out.println("Mensaje:    " + e.getMessage());
			System.out.println("SQL estado: " + e.getSQLState());
			System.out.println("Cód error:  " + e.getErrorCode());
			ret=false;
		}
		return ret;
		
		
	}
}
