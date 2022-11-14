package es.dominguez.inigo.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.dominguez.inigo.clases.Peliculas;
import es.dominguez.inigo.json.Conexion;
import es.dominguez.inigo.json.Utils;



public class Obtener {
	public ArrayList<Peliculas> listarPelis(Conexion con) {
		ArrayList<Peliculas> listarPelis = new ArrayList<>();
		
		String sql = "select * from Peliculas";
		
		
		java.sql.PreparedStatement sentencia;
		try {
			sentencia = con.Conectar().prepareStatement(sql);
			ResultSet filas = sentencia.executeQuery();
			

			while (filas.next()) {
				String titulo = filas.getString(1);
				int year = filas.getInt(2);
				String type = filas.getString(4);
				String imdbID = filas.getString(3);
				String poster = filas.getString(5);
				int valoracion = filas.getInt(6);
				
								
				listarPelis.add(new Peliculas(titulo,year,type,imdbID,poster,valoracion));
			}
			
		} catch (SQLException e) {
			System.out.println("HA OCURRIDO UNA EXCEPCIÓNN:");
			System.out.println("Mensaje:    " + e.getMessage());
			System.out.println("SQL estado: " + e.getSQLState());
			System.out.println("Cód error:  " + e.getErrorCode());
			Utils.escribirLog("Mensaje :" + e.getMessage());

		}

		return listarPelis;
	}
}
