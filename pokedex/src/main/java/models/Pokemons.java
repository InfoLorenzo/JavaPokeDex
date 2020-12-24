package models;

public class Pokemons {

	private String pokemonName;
	private String pokemonURL;

	public Pokemons() {
		// TODO Auto-generated constructor stub
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
