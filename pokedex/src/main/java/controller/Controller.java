package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import models.Pokemon;
import views.MainWindow;
import controller.HttpRequests;

public class Controller {

	public Controller() {

	}

	public static void switchPanels(JLayeredPane layeredPane, JPanel panel) {

		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	};

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

	public static void addPokemonToDatabase(String name, String pokeprofileURL,int healthPoints, int attackPoints, int specialAttackPoints, int specialDefensePoints, int speed, int height, int weight, int basicExp, String abilities, String sprites, String forms, String spawnPoints, String types) {
		
		String url = "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_414700429a65082";
		String username = "b0124af284507d";
		String password = "c7610f50";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);

			System.out.println("La conexión fue correcta");

			// String sql = "INSERT INTO users (username,password) VALUES (?, ?)";

			// statement.setString(1, "test");
			// statement.setString(2, "test1");

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

	public static void main(String[] args) {
		
		for (Pokemon P : generatePokemons("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=1")) {
			
			addPokemonToDatabase(
					P.getPokemonName(),
					P.getPokemonURL(),
					P.getPokemonStats()[0],
					P.getPokemonStats()[1],
					P.getPokemonStats()[2],
					P.getPokemonStats()[3],
					P.getPokemonStats()[4],
					P.getPokemonExpBase(),
					P.getPokemonHeight(),
					P.getPokemonWeight(),
					P.getPokemonAbilities().toString(),
					P.getPokemonPicsURL().toString(),
					P.getPokemonForms().toString(),
					P.getPokemonSpawnPoints().toString(),
					P.getPokemonTypes().toString()
					);

		}
	
	}

}
