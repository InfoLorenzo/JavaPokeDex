package models;

public class Pokemon {

	private String pokemonName;
	private String pokemonURL;
	private int pokemonExpBase;
	
	
	public int getPokemonExpBase() {
		return pokemonExpBase;
	}

	public void setPokemonExpBase(int pokemonExpBase) {
		this.pokemonExpBase = pokemonExpBase;
	}

	public Pokemon(String pokemon_name, String pokemon_url ,  int pokemon_exp_base) {
		this.pokemonName = pokemon_name;
		this.pokemonURL = pokemon_url;
		this.pokemonExpBase = pokemon_exp_base;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Pokemons [getPokemonName()=" + getPokemonName() + ", getPokemonURL()=" + getPokemonURL() + "]";
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public String getPokemonURL() {
		return pokemonURL;
	}

	public void setPokemonURL(String pokemonURL) {
		this.pokemonURL = pokemonURL;
	}

}
