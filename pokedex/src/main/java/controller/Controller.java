package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Pokemon;
import views.LoginView;
import views.MainWindow;
import views.modals.LoginUnsuccessful;
import controller.HttpRequests;

public class Controller {

	private static LoginUnsuccessful failedRequestDataModal;

	public Controller() {

	}

	public static String[] userlogin = new String[2];

	private static Connection connectToDatabase() {

		String databaseURL = "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_414700429a65082";
		String databaseUsername = "b0124af284507d";
		String databasePassword = "c7610f50";

		Connection connection;

		try {
			connection = DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);

			System.out.println("La conexión fue correcta");
			return connection;
		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Hubo un error");
		}

		return null;

	}

	public static void registerUser(String nickname, String username, String password) {

		String sqlPokemon = "INSERT INTO `heroku_414700429a65082`.`users` (`username`, `password`, `nickname`) VALUES (?, ?,?);";

		PreparedStatement statement = null;
		try {
			statement = connectToDatabase().prepareStatement(sqlPokemon);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, nickname);
		} catch (Exception e) {
			System.out.println("Oops algo salio mal...");
			e.printStackTrace();
		}

		try {
			statement.executeUpdate();
			System.out.println("El usuario ha sido insertado correctamente");
		} catch (SQLException e) {
			System.out.println("Oops algo salio mal...");
			e.printStackTrace();
		}
	}

	public static boolean checkUserExist(String username) {

		String sqlPokemon = "SELECT `username`, `nickname` FROM `heroku_414700429a65082`.`users` WHERE `username`='"
				+ username + "';";

		PreparedStatement statement = null;

		try {
			statement = connectToDatabase().prepareStatement(sqlPokemon);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("El usuario existe en la base de datos");
				System.out.println();

				while (rs.next()) {
					System.out.println("---------------");
					System.out.println(rs.getString("username"));
					System.out.println("---------------");

				}
				return true;
			} else {
				System.out.println("El usuario no existe en la base de datos");
			}

		} catch (SQLException e) {
			System.out.println("Oops algo salio mal...");
			e.printStackTrace();
		}

		return false;
	}

	public static boolean checkUserLogin(String username, String password) {

		if (checkUserExist(username)) {

			String sqlPokemon = "SELECT `username`, `password`,`nickname` FROM `heroku_414700429a65082`.`users` WHERE `username`='"
					+ username + "' AND `password`='" + password + "';";

			PreparedStatement statement = null;

			try {
				statement = connectToDatabase().prepareStatement(sqlPokemon);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					System.out.println("Los datos son correctos");
					System.out.println();

					userlogin[0] = rs.getString("username");
					userlogin[1] = rs.getString("nickname");

					System.out.println("Username: " + userlogin[0]);
					System.out.println("Nickname: " + userlogin[1]);

					return true;
				} else {
					failedRequestDataModal = new LoginUnsuccessful();
					failedRequestDataModal.newScreen();
					System.out.println("Los datos no son correctos");
					return false;
				}

			} catch (SQLException e) {
				System.out.println("Oops algo salio mal...");
				e.printStackTrace();
			}
		} else {
			failedRequestDataModal = new LoginUnsuccessful();
			failedRequestDataModal.newScreen();
		}

		return false;
	}

	public static boolean isEmpty(String textInput) {

		if (textInput.equalsIgnoreCase("") || textInput.equalsIgnoreCase(" ") || textInput == null) {
			return true;
		}

		return false;
	}

	public static ArrayList<Pokemon> generatePokemons(String apilistofPokemons) {

		ArrayList<Pokemon> PokeLista = new ArrayList<Pokemon>();
		Pokemon poke;

		for (String pokemonProfileApiUrl : HttpRequests.getPokemonURLs(apilistofPokemons)) {
			System.out.println("Url a usar: " + pokemonProfileApiUrl);

			poke = new Pokemon(

					HttpRequests.getPokemonName(pokemonProfileApiUrl), pokemonProfileApiUrl,
					HttpRequests.getPokemonAbilities(pokemonProfileApiUrl),
					HttpRequests.getPokemonSpawnPlaces(pokemonProfileApiUrl),
					HttpRequests.getPokemonbasicSprites(pokemonProfileApiUrl),
					HttpRequests.getPokemonTypes(pokemonProfileApiUrl),
					HttpRequests.getPokemonStats(pokemonProfileApiUrl),
					HttpRequests.getPokemonExp(pokemonProfileApiUrl),
					HttpRequests.getPokemonHeight(pokemonProfileApiUrl),
					HttpRequests.getPokemonWeight(pokemonProfileApiUrl),
					HttpRequests.getPokemonForms(pokemonProfileApiUrl)

			);

			System.out.println("Pokemon creado");

			System.out.println("Sus datos son: ");

			System.out.println("Nombre: " + poke.getPokemonName());

			System.out.println("Perfil API: " + poke.getPokemonURL());

			System.out.println("Experiencia básica: " + poke.getPokemonExpBase());

			System.out.println("Altura: " + poke.getPokemonHeight());

			System.out.println("Peso: " + poke.getPokemonWeight());

			System.out.println("Habilidades: " + poke.getPokemonAbilities());

			System.out.println("Fotos: " + poke.getPokemonPicsURL());

			System.out.println("Punto de Spawn: " + poke.getPokemonSpawnPoints());

			int[] arr = poke.getPokemonStats();
			for (int i = 0; i < poke.getPokemonStats().length; i++) {
				switch (i) {
				case 0:
					System.out.println("Vida: " + arr[i]);
					break;
				case 1:
					System.out.println("Ataque: " + arr[i]);
					break;
				case 2:
					System.out.println("Defensa: " + arr[i]);
					break;
				case 3:
					System.out.println("Ataque especial: " + arr[i]);
					break;

				case 4:
					System.out.println("Defensa especial: " + arr[i]);
					break;

				case 5:
					System.out.println("Velocidad: " + arr[i]);
					break;
				}
			}

			System.out.println("Es de tipo: " + poke.getPokemonTypes());
			System.out.println("Formas: " + poke.getPokemonForms());

			PokeLista.add(poke);

			System.out.println("\n\n\n\n\n\n\n\n\n");

			JSONArray jsonPokeAbilities = new JSONArray();

			for (String abilities : poke.getPokemonAbilities()) {
				jsonPokeAbilities.put(abilities);
			}

			System.out.println(jsonPokeAbilities.toString());

			JSONArray jsonPokePics = new JSONArray();

			for (String urlPics : poke.getPokemonPicsURL()) {
				jsonPokePics.put(urlPics);
			}

			System.out.println(jsonPokePics.toString());

		}

		return PokeLista;

	}

	public static void addPokemonToDatabase(String name, String pokeprofileURL, int healthPoints, int attackPoints,
			int specialAttackPoints, int specialDefensePoints, int speed, int height, int weight, int basicExp,
			String abilities, String sprites, String forms, String spawnPoints, String types) {

		String url = "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_414700429a65082";
		String username = "b0124af284507d";
		String password = "c7610f50";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);

			System.out.println("La conexión fue correcta");

			String sqlPokemon = "INSERT INTO `heroku_414700429a65082`.`pokemon` (`name`, `profileUrl`, `healthpoints`, `attackpoints`, `specialattackpoints`, `specialdefensepoints`, `speed`, `height`, `weight`, `basicexp`, `abilities`, `sprites`, `forms`, `spawnpoints`, `types`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sqlPokemon);

			statement.setString(1, name);
			statement.setString(2, pokeprofileURL);
			statement.setInt(3, healthPoints);
			statement.setInt(4, attackPoints);
			statement.setInt(5, specialAttackPoints);
			statement.setInt(6, specialDefensePoints);
			statement.setInt(7, speed);
			statement.setInt(8, height);
			statement.setInt(9, weight);
			statement.setInt(10, basicExp);
			statement.setString(11, abilities);
			statement.setString(12, sprites);
			statement.setString(13, forms);
			statement.setString(14, spawnPoints);
			statement.setString(15, types);

			int rows = statement.executeUpdate();

			if (rows > 0) {
				System.out.println("A rows has been inserted");
			}

			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Oops algo salio mal...");
			e.printStackTrace();
		}
	}

	public static String[] getPokemonDatafromDB(int id) {
		String sqlPokemon = "SELECT `name`, `healthpoints`, `attackpoints`, `specialattackpoints`, `specialdefensepoints`, `speed`, `height`, `weight`, `basicexp` FROM `heroku_414700429a65082`.`pokemon` WHERE `ID`='"
				+ id + "';";

		PreparedStatement statement = null;
		String[] pokemonData = new String[9];
		try {
			statement = connectToDatabase().prepareStatement(sqlPokemon);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("El pokemon existe en la base de datos");
				System.out.println();

				pokemonData[0] = rs.getString("name");
				pokemonData[1] = rs.getString("healthpoints");
				pokemonData[2] = rs.getString("attackpoints");
				pokemonData[3] = rs.getString("specialattackpoints");
				pokemonData[4] = rs.getString("specialdefensepoints");
				pokemonData[5] = rs.getString("speed");
				pokemonData[6] = rs.getString("height");
				pokemonData[7] = rs.getString("weight");
				pokemonData[8] = rs.getString("basicexp");
				// pokemonData[9] = rs.getString("abilities");
				// pokemonData[10] = rs.getString("types");
				// pokemonData[11] = rs.getString("sprites");

				System.out.println("---------------");
				System.out.println("Pokemon Name: " + pokemonData[0]);
				System.out.println("Pokemon healthpoints: " + pokemonData[1]);
				System.out.println("Pokemon attackpoints: " + pokemonData[2]);
				System.out.println("Pokemon specialattackpoints: " + pokemonData[3]);
				System.out.println("Pokemon specialdefensepoints: " + pokemonData[4]);
				System.out.println("Pokemon speed: " + pokemonData[5]);
				System.out.println("Pokemon height: " + pokemonData[6]);
				System.out.println("Pokemon weight: " + pokemonData[7]);
				System.out.println("Pokemon basicexp: " + pokemonData[8]);
				System.out.println("---------------");

				return pokemonData;

			} else {
				System.out.println("El pokemon no existe en la base de datos");
			}

		} catch (SQLException e) {
			System.out.println("Oops algo salio mal...");
			e.printStackTrace();
		}

		return null;
	}

	public static String[] getPokemonArrayfromDB(int id,String arrayName) {
		String sqlPokemon = "SELECT `"+ arrayName +"` FROM `heroku_414700429a65082`.`pokemon` WHERE `ID`='"
				+ id + "';";

		PreparedStatement statement = null;
		String[] pokemonArray;
		String resultString;
		try {
			statement = connectToDatabase().prepareStatement(sqlPokemon);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				resultString = rs.getString(arrayName).substring(1,rs.getString(arrayName).length()-1);
				
				pokemonArray = resultString.split(", ");
				for (String string : pokemonArray) {
					System.out.println(string);
				}
				return pokemonArray;
			}
			
		} catch (Exception e) {
			System.out.println("Oops algo salio mal " + e);
		}
		return null;
	}
	
	public static String[][] getPokemonSpritesDivided(String[] SpritesInput) {
		int contador1 = 0;
		int contador2 = 0;
		int contador3 = 0;
		int contador4 = 0;

		String[][] pokemonSpritesDivided = new String[4][8];
		
		//[0] - Male Shiny
		//[1] - Male default
		//[2] - Female Shiny
		//[3] - Female default
		

		for (int i = 0; i < SpritesInput.length; i++) {
			
			
			if (SpritesInput[i].contains("female")) {
				if (SpritesInput[i].contains("shiny")) {
					System.out.println("Mujer shiny: " + SpritesInput[i]);
					pokemonSpritesDivided[2][contador1] = SpritesInput[i];
					contador1++;
					
				}else{
					System.out.println("Mujer default: " + SpritesInput[i]);
					pokemonSpritesDivided[3][contador2] = SpritesInput[i];
					contador2++;
				}
			}else {
				if (SpritesInput[i].contains("shiny")) {
					System.out.println("Hombre shiny: " + SpritesInput[i]);
					pokemonSpritesDivided[0][contador3] = SpritesInput[i];
					contador3++;
				}else {
					System.out.println("Hombres default: " + SpritesInput[i]);
					pokemonSpritesDivided[1][contador4] = SpritesInput[i];
					contador4++;
				}
			}
		
		}
		
			
			
			
			
		
		
		return pokemonSpritesDivided;
	}

	public static void main(String[] args) {

		System.out.println("Main del controller iniciado");
		getPokemonDatafromDB(1111);
		getPokemonArrayfromDB(1111,"abilities");
		getPokemonSpritesDivided(getPokemonArrayfromDB(1131,"sprites"));
		getPokemonArrayfromDB(1111,"types");
	}

}
