package mainAPP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class main {

	public static void main(String[] args) {

		
		  
		  String url =
		  "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_414700429a65082"; String
		  username = "b0124af284507d"; String password = "c7610f50";
		  
		  try { Connection connection =
		  DriverManager.getConnection(url,username,password);
		  
		  System.out.println("La conexión fue correcta");
		  
		 // String sql = "INSERT INTO users (username,password) VALUES (?, ?)";
		  
		  // statement.setString(1, "test"); 
			 // statement.setString(2, "test1");
		  
		  String sqlPokemon = "INSERT INTO `heroku_414700429a65082`.`pokemon` (`name`, `profileUrl`, `healthpoints`, `attackpoints`, `specialattackpoints`, `specialdefensepoints`, `speed`, `height`, `weight`, `basicexp`, `abilities`, `sprites`, `forms`, `spawnpoints`, `types`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		  PreparedStatement statement = connection.prepareStatement(sqlPokemon);
		  
		  statement.setString(1, "test"); 
		  statement.setString(2, "test1");
		  statement.setString(3, "test1");
		  statement.setString(4, "test1");
		  statement.setString(5, "test1");
		  statement.setString(6, "test1");
		  statement.setString(7, "test1");
		  statement.setString(8, "test1");
		  statement.setString(9, "test1");
		  statement.setString(10, "test1");
		  statement.setString(11, "test1");
		  statement.setString(12, "test1");
		  statement.setString(13, "test1");
		  statement.setString(14, "test1");
		  statement.setString(15, "test1");

		  
		  int rows = statement.executeUpdate();
		  
		  if (rows > 0) { System.out.println("A rows has been inserted"); }
		  
		  
		  statement.close(); connection.close();
		  
		  } catch (SQLException e) { System.out.println("Oops algo salio mal...");
		  e.printStackTrace(); }
		 
		  
		

		/*
		 * 
		 * final String POST_API_URL = "https://pokeapi.co/api/v2/pokemon/";
		 * 
		 * HttpClient client = HttpClient.newHttpClient();
		 * 
		 * HttpRequest request = HttpRequest.newBuilder() .GET() .header("accept",
		 * "application/json") .uri(URI.create(POST_API_URL)) .build();
		 * 
		 * 
		 * HttpResponse<String> response = null;
		 * 
		 * try { response = client.send(request, HttpResponse.BodyHandlers.ofString());
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println(response.body());
		 */
		/*
		 * //parse objets
		 * 
		 * ObjectMapper mapper = new ObjectMapper();
		 * 
		 * //List<models.Pokemons> pokemons = null;
		 * 
		 * try {
		 * 
		 * Collection<models.Pokemons> readValues = new ObjectMapper().readValue(
		 * response.body().toString(), new TypeReference<Collection<models.Pokemons>>()
		 * { } );
		 * 
		 * readValues.forEach(System.out::println);
		 * 
		 * //pokemons = mapper.readValue(response.body(), new
		 * TypeReference<List<models.Pokemons>>() {}); } catch (JsonMappingException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (JsonProcessingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * //pokemons.forEach(System.out::println);
		 */
		String string;

		JSONObject json = new JSONObject();

		json.put("name", "student");
		json.put("Health", "10");
		json.put("Attack", "25");
		json.put("Speed", "Toda!!!");

		String message = json.toString();

		System.out.println(message);

		System.out.println("Hola");
	}

}
