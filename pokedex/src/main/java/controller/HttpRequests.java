package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import models.Pokemon;

public class HttpRequests {

	static ArrayList<Pokemon> listaPokemons = new ArrayList<Pokemon>();
	private static String mainApiUrl = "https://pokeapi.co/api/v2/pokemon?limit=1";
	private static String pokemonApiUrl = "https://pokeapi.co/api/v2/pokemon/1/";

	public HttpRequests() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
		//System.out.println("HTTP Request Example ");
		// Making Get Request
		//System.out.println(sendGetRequest(mainApiUrl).toString());
		// Making Post Request
		// sendPOSTRequest();
		// Parse Json Reponse
		//System.out.println(getPokemonName(pokemonApiUrl));
		//System.out.println("\n\n\n\n\n\n");
		getPokemonAbilities(pokemonApiUrl);
		getPokemonExp(pokemonApiUrl);
		getPokemonForms(pokemonApiUrl);
		getPokemonSpawnPlaces(pokemonApiUrl);
		getPokemonHeight(pokemonApiUrl);
		getPokemonbasicSprites(pokemonApiUrl);
		//System.out.println("Las stats del pokemon son:");
		for (int i : getPokemonStats(pokemonApiUrl)) {
			//System.out.println(i);
		}
		for (String string : getPokemonTypes(pokemonApiUrl)) {
			//System.out.println(string);
		}

	}

	public static String sendGetRequest(String apiURL) { // Me ha obligado a hacerla estática y no se el porqué
		try {
			URL url = new URL(apiURL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");

			// adding header
			String line = "";
			InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder response = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}
			bufferedReader.close();
			// System.out.println("Response : " + response.toString());

			return response.toString();
		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
		}
		return null;
	}

	public static void sendPOSTRequest() {
		try {
			String post_data = "key1=value1&key2=value2";

			URL url = new URL("https://pokeapi.co/api/v2/pokemon");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			// adding header
			httpURLConnection.setRequestProperty("Auth", "Token");
			httpURLConnection.setRequestProperty("Data1", "Value1");
			httpURLConnection.setDoOutput(true);

			// Adding Post Data
			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(post_data.getBytes());
			outputStream.flush();
			outputStream.close();

			System.out.println("Response Code " + httpURLConnection.getResponseCode());

			String line = "";
			InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder response = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}
			bufferedReader.close();
			System.out.println("Response : " + response.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Making POST Request");
		}
	}

	public static String[] getPokemonBasicData() {

		String[] basicData = new String[2];

		try {

			String jsonString = sendGetRequest(mainApiUrl);
			JSONObject obj = new JSONObject(jsonString);
			JSONArray arr = obj.getJSONArray("results");

			for (int i = 0; i < arr.length(); i++)

			{

				basicData[0] = arr.getJSONObject(i).getString("name");
				basicData[1] = arr.getJSONObject(i).getString("url");

			}

			return basicData;
		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}
		
		return basicData;

	}
	public static ArrayList<String> getPokemonURLs(String url) {

		ArrayList<String> urlsArray = new ArrayList<String>();

		try {

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);
			JSONArray arr = obj.getJSONArray("results");
			
			for (int i = 0; i < arr.length(); i++)
				
			{

				
				urlsArray.add(arr.getJSONObject(i).getString("url"));

			}

			return urlsArray;
		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}
		
		return urlsArray;

	}
	
	public static String getPokemonName(String url) {

		String Pokemonname = null;

		try {

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);
			Pokemonname = obj.getString("name");

			return Pokemonname;
		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}
		
		return Pokemonname;

	}

	public static ArrayList<String> getPokemonAbilities(String url) {

		// Devuelve el nombre de las habilidades del pokemon

		try {
			String abilitie;
			ArrayList<String> abilities = new ArrayList<String>();

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			JSONArray arr = obj.getJSONArray("abilities");

			for (int i = 0; i < arr.length(); i++)

			{
				abilitie = arr.getJSONObject(i).getJSONObject("ability").getString("name");
				System.out.println(abilitie);
				abilities.add(abilitie);
			}

			return abilities;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return null;

	}

	public static int getPokemonExp(String url) {

		// Si devuelve -1 es que dio error

		try {
			int pokemonExp;

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			System.out.println("La experiencia del pokemon introducido es: " + obj.get("base_experience"));

			return (int) obj.getInt("base_experience");

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return -1;
	}

	public static ArrayList<String> getPokemonForms(String url) {

		try {
			String form;
			ArrayList<String> forms = new ArrayList<String>();

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			JSONArray arr = obj.getJSONArray("forms");

			for (int i = 0; i < arr.length(); i++)

			{
				form = arr.getJSONObject(i).getString("name");
				//System.out.println(form);
				forms.add(form);
			}

			return forms;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return null;
	}

	public static ArrayList<String> getPokemonVersions(String url) {

		try {
			String version;
			ArrayList<String> versions = new ArrayList<String>();

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			JSONArray arr = obj.getJSONArray("game_indices");

			for (int i = 0; i < arr.length(); i++)

			{
				version = arr.getJSONObject(i).getJSONObject("version").getString("name");
				//System.out.println(version);
				versions.add("Pokemon " + version);
			}

			return versions;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return null;
	}

	public static ArrayList<String> getPokemonSpawnPlaces(String url) {

		try {
			String ecounterPlace;
			ArrayList<String> ecounterPlaces = new ArrayList<String>();

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			String enconuntersurl = (String) obj.get("location_area_encounters");

			String ecountersString = sendGetRequest(enconuntersurl);
			JSONArray encountersJSON = new JSONArray(ecountersString);

			for (int i = 0; i < encountersJSON.length(); i++)

			{
				ecounterPlace = encountersJSON.getJSONObject(i).getJSONObject("location_area").getString("name");
				//System.out.println(ecounterPlace);
				ecounterPlaces.add("Pokemon " + ecounterPlace);
			}

			return ecounterPlaces;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return null;
	}

	public static int getPokemonHeight(String url) {

		// Si devuelve -1 es que dio error

		try {
			int pokemonExp;

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			//System.out.println("La altura del pokemon introducido es: " + obj.get("height"));

			return (int) obj.getInt("height");

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return -1;
	}

	public static ArrayList<String> getPokemonbasicSprites(String url) {

		try {

			ArrayList<String> Sprites = new ArrayList<String>();

			String jsonString = sendGetRequest(url);
			JSONObject obj = new JSONObject(jsonString);

			try {
				Sprites.add(obj.getJSONObject("sprites").getString("back_default"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("back_female"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("back_shiny"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("back_shiny_female"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("front_default"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("front_female"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("front_shiny"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Sprites.add(obj.getJSONObject("sprites").getString("front_shiny_female"));
			} catch (Exception e) {
				// TODO: handle exception
			}

			for (String s : Sprites) {
				//System.out.println(s);
			}

			return Sprites;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return null;
	}

	public static int[] getPokemonStats(String url) {

		int[] pokemonStats = new int[6];
		
		// pokemonStats[0] = HP
		// pokemonStats[1] = Attack
		// pokemonStats[2] = Defense
		// pokemonStats[3] = Special - Attack
		// pokemonStats[4] = Special - Defense
		// pokemonStats[5] = Speed
		
		try {

			String jsonString = sendGetRequest(url);

			JSONObject obj = new JSONObject(jsonString);
			JSONArray arr = obj.getJSONArray("stats");

			for (int i = 0; i < arr.length(); i++) {

				pokemonStats[i] = arr.getJSONObject(i).getInt("base_stat");
			}

			return pokemonStats;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return pokemonStats;
	}

	public static ArrayList<String> getPokemonTypes(String url) {

		ArrayList<String> pokemonTypes = new ArrayList<String>();



		try {

			String jsonString = sendGetRequest(url);

			JSONObject obj = new JSONObject(jsonString);
			JSONArray arr = obj.getJSONArray("types");

			for (int i = 0; i < arr.length(); i++) {

				pokemonTypes.add((String) arr.getJSONObject(i).getJSONObject("type").get("name"));
			}

			return pokemonTypes;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return pokemonTypes;
	}

	public static int getPokemonWeight(String url) {

		int pokemonWeight = 0;

		try {

			String jsonString = sendGetRequest(url);

			JSONObject obj = new JSONObject(jsonString);

			pokemonWeight = obj.getInt("weight");

			return pokemonWeight;

		} catch (Exception e) {
			System.out.println("Error in Making Get Request");
			System.out.println("The error is: " + e);
		}

		return pokemonWeight;
	}

}
