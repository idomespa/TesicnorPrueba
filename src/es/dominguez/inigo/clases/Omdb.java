package es.dominguez.inigo.clases;

import java.util.List;

public class Omdb {
	private int totalResult;
	private boolean responde;
	private List<Peliculas> peliculas = null;

	public Omdb(List<Peliculas>peliculas,int totalResult,boolean responde) {
		this.peliculas=peliculas;
		this.setResponde(responde);
		this.setTotalResult(totalResult);
	}
	public List<Peliculas> getPeliculas() {
		return peliculas;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	public boolean isResponde() {
		return responde;
	}
	public void setResponde(boolean responde) {
		this.responde = responde;
	}
}
