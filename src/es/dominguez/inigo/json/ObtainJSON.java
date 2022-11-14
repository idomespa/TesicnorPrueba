package es.dominguez.inigo.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import es.dominguez.inigo.clases.Omdb;
import es.dominguez.inigo.clases.Peliculas;
public class ObtainJSON {

	/*
	 * 	Clase encargada de recibir la url y crear el objeto pelicula para añadirla despues a la base de datos
	 * 
	 * @author Iñigo Dominguez
	 * @date 14-11-2022	
	 */
	public ArrayList<Peliculas> obtieneJson(String urlGetJSON)
	{
		JsonElement json=null;
		ArrayList<Peliculas> arPel = null;
	    try
	    {
	        URL url = new URL(urlGetJSON);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        if (conn.getResponseCode() != 200) 
	        {
	            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        }
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = br.read()) != -1)
	        {
	          sb.append((char) cp);
	        }
	        String output = sb.toString();
	        JSONObject jsonObj = new JSONObject(output);

	        JSONArray ja_data = jsonObj.getJSONArray("Search");
	        arPel = new ArrayList<>();
	        for(int i=0; i<ja_data.length(); i++) {
	          JSONObject js = ja_data.getJSONObject(i);
	          Peliculas peli = new Peliculas();
	          peli.setTitle(js.getString("Title"));
	          peli.setYear(js.getInt("Year"));
	          peli.setImdbID(js.getString("imdbID"));
	          peli.setType(js.getString("Type"));
	          peli.setPoster(js.getString("Poster"));
	          arPel.add(peli);
	        }
	        conn.disconnect();
	        
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
	    return arPel;
	}
}
