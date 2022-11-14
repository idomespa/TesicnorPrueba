package es.dominguez.inigo.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.json.Utils;
import es.dominguez.inigo.main.*;


public class Insertar {
public boolean insertar(Conexion con, String titulo, int year, String type, String imdbID, String Poster) {
		
		String sql = "INSERT INTO  peliculas (Titulo, Year, type, imdbID,Poster) VALUES "
				+ "(?, ?, ?, ?, ?);";
		boolean ret= false;
		
		PreparedStatement sentencia;
		
		try {
			sentencia = con.Conectar().prepareStatement(sql);
			sentencia.setString(1, titulo);
			sentencia.setInt(2, year);
			sentencia.setString(3, type);
			sentencia.setString(4, imdbID);
			sentencia.setString(5, Poster);
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
