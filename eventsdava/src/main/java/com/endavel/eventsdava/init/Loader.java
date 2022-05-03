package com.endavel.eventsdava.init;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.persistance.EventsRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Component;

@Component
public class Loader {

	private EventsRepository eventsRepository;

	String url = "https://626964ebaa65b5d23e841fb7.mockapi.io/api/v1/event";
	String respuesta = "";

	public Loader(EventsRepository eventsRepository) {
		super();
		this.eventsRepository = eventsRepository;
		
		try {
			respuesta = peticionHttpGet(url);
			System.out.println("La respuesta es:\n" + respuesta);
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
		}				
		
		eventsRepository.saveAll(null);
	}

	
	public static List<Event> getListEvents(String json){
		
		JSONArray arregloJson = new JSONArray(json);

		// Nota: creamos la lista para ejemplos ilustrativos, no es necesaria
		List<Event> list = new ArrayList<>();
		// Iterar 
		for (int indice = 0; indice < arregloJson.length(); indice++) {
		    // Obtener objeto a través del índice
		    JSONObject posibleEvent = arregloJson.getJSONObject(indice);

		    // Acceder como accedíamos al jsonObject
		    String name = posibleEvent.getString("name");
		    String type = posibleEvent.getString("type");
		    String dateTime = posibleEvent.getString("dateTime");
		    Integer price = posibleEvent.getInt("price");		    
		    String location = posibleEvent.getString("location");
		    String description = posibleEvent.getString("description");
		   
		    // Luego de eso podemos crear la clase y obtener los beneficios
		    // de la POO o usar los datos como nos plazca
		    
		    //Event event = new Event(name, type, price, location, description);

		   
		    // Agregar a la lista, solo para ilustrar
		    //list.add(event);		
		}
		
		return list;
	}
	
	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
}
