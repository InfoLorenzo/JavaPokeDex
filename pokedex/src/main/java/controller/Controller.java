package controller;

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
			jsonPokeAbilities.put(urlPics);
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

	public static void main(String[] args) {
		for (Pokemon P : generatePokemons("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=10")) {
			System.out.println(P);
		}
	}

}
