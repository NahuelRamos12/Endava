package com.endavel.eventsdava.init;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.persistance.EventsRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
		this.eventsRepository = eventsRepository;
		try {
			respuesta = httpGet(url);
			eventsRepository.saveAll(getListEvents(respuesta));
			System.out.println("La respuesta es:\n" + respuesta);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
	}
	
	public static List<Event> getListEvents(String json){
		
		JSONArray jsonArray = new JSONArray(json);
		List<Event> list = new ArrayList<>();

		for (int index = 0; index < jsonArray.length(); index++) {

		    JSONObject posibleEvent = jsonArray.getJSONObject(index);

		    String name = posibleEvent.getString("name");
		    String type = posibleEvent.getString("type");
		    
		    String dateTime = posibleEvent.getString("dateTime");
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");	    	    	    
		    LocalDateTime localdatetime = LocalDateTime.parse(dateTime, formatter);
		    
		    LocalDate date = localdatetime.toLocalDate();
		    LocalTime time = localdatetime.toLocalTime();
		    		   		  
		    Integer price = posibleEvent.getInt("price");		    
		    String location = posibleEvent.getString("location");
		    String description = posibleEvent.getString("description");
		    
		    Event event = new Event(name, type, date, time, price, location, description);

		    list.add(event);		
		}
		
		return list;
	}
	
	public static String httpGet(String url) throws Exception {
		
		StringBuilder result = new StringBuilder();
		
		URL newUrl = new URL(url);
	
		HttpURLConnection conexion = (HttpURLConnection) newUrl.openConnection();
		conexion.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		
		while ((linea = rd.readLine()) != null) {
			result.append(linea);
		}
		
		rd.close();
		return result.toString();
	}
}
