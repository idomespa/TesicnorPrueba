package es.dominguez.inigo.clases;

import java.util.List;

public class Peliculas {
	private String title;
	private int year;
	private String imdbID;
	private String type;
	private String poster;
	private int valoracion;
	
	
	
	public Peliculas(String title, int year, String imdbID, String type, String poster,int valoracion) {
		super();
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
		this.type = type;
		this.poster = poster;
		this.valoracion=valoracion;
	}
	public Peliculas() {
	}
	public Peliculas(int valoracion) {
		this.valoracion=valoracion;
	}
	


	@Override
	public String toString() {
		return "Peliculas [title=" + title + ", year=" + year + ", imdbID=" + imdbID + ", type=" + type + ", poster="
				+ poster + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
}
