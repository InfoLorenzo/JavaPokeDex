package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Pokemon {

	private String pokemonName;
	private String pokemonURL;
	private ArrayList<String> pokemonAbilities;
	private ArrayList<String> pokemonSpawnPoints;
	private ArrayList<String> pokemonPicsURL;
	private ArrayList<String> pokemonTypes;
	private ArrayList<String> pokemonForms;
	private int[] pokemonStats;
	private int pokemonExpBase;
	private int pokemonHeight;
	private int pokemonWeight;
	

	public Pokemon(String pokemon_name, String pokemon_url ) {
		this.pokemonName = pokemon_name;
		this.pokemonURL = pokemon_url;
	}
	
	public ArrayList<String> getPokemonForms() {
		return pokemonForms;
	}

	public void setPokemonForms(ArrayList<String> pokemonForms) {
		this.pokemonForms = pokemonForms;
	}

	/**
	 * @param pokemonName
	 * @param pokemonURL
	 * @param pokemonAbilities
	 * @param pokemonSpawnPoints
	 * @param pokemonPicsURL
	 * @param pokemonTypes
	 * @param pokemonStats
	 * @param pokemonExpBase
	 * @param pokemonHeight
	 */
	
	public Pokemon(String pokemonName, String pokemonURL, ArrayList<String> pokemonAbilities,
			ArrayList<String> pokemonSpawnPoints, ArrayList<String> pokemonPicsURL, ArrayList<String> pokemonTypes,
			int[] pokemonStats, int pokemonExpBase, int pokemonHeight, int pokemonWeight, ArrayList<String> pokemonForms) {
		this.pokemonName = pokemonName;
		this.pokemonURL = pokemonURL;
		this.pokemonAbilities = pokemonAbilities;
		this.pokemonSpawnPoints = pokemonSpawnPoints;
		this.pokemonPicsURL = pokemonPicsURL;
		this.pokemonTypes = pokemonTypes;
		this.pokemonStats = pokemonStats;
		this.pokemonExpBase = pokemonExpBase;
		this.pokemonHeight = pokemonHeight;
		this.pokemonWeight = pokemonWeight;
		this.pokemonForms = pokemonForms;
	}

	public int getPokemonWeight() {
		return pokemonWeight;
	}

	public void setPokemonWeight(int pokemonWeight) {
		this.pokemonWeight = pokemonWeight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "Pokemon [pokemonName=" + pokemonName + ", pokemonURL=" + pokemonURL + ", pokemonAbilities="
				+ pokemonAbilities + ", pokemonSpawnPoints=" + pokemonSpawnPoints + ", pokemonPicsURL=" + pokemonPicsURL
				+ ", pokemonTypes=" + pokemonTypes + ", pokemonForms=" + pokemonForms + ", pokemonStats="
				+ Arrays.toString(pokemonStats) + ", pokemonExpBase=" + pokemonExpBase + ", pokemonHeight="
				+ pokemonHeight + ", pokemonWeight=" + pokemonWeight + ", pokemonForms= " + pokemonForms +"]";
	}
	
	public int getPokemonExpBase() {
		return pokemonExpBase;
	}

	public void setPokemonExpBase(int pokemonExpBase) {
		this.pokemonExpBase = pokemonExpBase;
	}

	public ArrayList<String> getPokemonAbilities() {
		return pokemonAbilities;
	}

	public void setPokemonAbilities(ArrayList<String> pokemonAbilities) {
		this.pokemonAbilities = pokemonAbilities;
	}

	public ArrayList<String> getPokemonSpawnPoints() {
		return pokemonSpawnPoints;
	}

	public void setPokemonSpawnPoints(ArrayList<String> pokemonSpawnPoints) {
		this.pokemonSpawnPoints = pokemonSpawnPoints;
	}

	public ArrayList<String> getPokemonPicsURL() {
		return pokemonPicsURL;
	}

	public void setPokemonPicsURL(ArrayList<String> pokemonPicsURL) {
		this.pokemonPicsURL = pokemonPicsURL;
	}

	public ArrayList<String> getPokemonTypes() {
		return pokemonTypes;
	}

	public void setPokemonTypes(ArrayList<String> pokemonTypes) {
		this.pokemonTypes = pokemonTypes;
	}

	public int[] getPokemonStats() {
		return pokemonStats;
	}

	public void setPokemonStats(int[] pokemonStats) {
		this.pokemonStats = pokemonStats;
	}

	public int getPokemonHeight() {
		return pokemonHeight;
	}

	public void setPokemonHeight(int pokemonHeight) {
		this.pokemonHeight = pokemonHeight;
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
