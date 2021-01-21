package views;

import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.w3c.dom.css.Counter;

import controller.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JTextField;

public class PokedexView extends JPanel {

	private int pokemonMinID = 1111;
	private int pokemonMaxID = 3101;
	private int pokemonID = pokemonMinID;
	private boolean shiny = false;
	private String[] pokemonData = Controller.getPokemonDatafromDB(pokemonID);
	//private String[] pokemonData = {"name","22","22","22","22","22","22","22","22"};
	private String[] pokemonAbilities = Controller.getPokemonArrayfromDB(pokemonID, "abilities");
	private String[] pokemonSprites = Controller.getPokemonArrayfromDB(pokemonID, "sprites");
	private String[] pokemonTypes = Controller.getPokemonArrayfromDB(pokemonID, "types");
	private String[][] pokemonImageDefault = new String[2][];
	private String[][] pokemonImageShiny = new String[2][];
	private String[] pokemonImage;
	private int imagesCounter = 0;
	private JLabel lblPokemonName;
	private JLabel lblHealthPointsNumber;
	private JLabel lblAttackNumber;
	private JLabel lblSpecialAttackNumber;
	private JLabel lblSpecialDefenseNumber;
	private JLabel lblSpeedNumber;
	private JLabel lblHeightNumber;
	private JLabel lblWeightNumber;
	private JLabel lblAbilitie1;
	private JLabel lblAbilitie2;
	private JLabel lblAbilitie3;
	private JLabel lblType1;
	private JLabel lblType2;
	private JLabel lblPokemonPic;
	private JButton btnPreviousPokemon;
	private JButton btnNextPokemon;
	private int heightDataLabels = 15;
	private int widthDataLabels = 100;
	private int heightDataTitles = 30;
	private int widthDataTitles = 230;
	private int heightNumberLabels = 15;
	private int widthNumberLabels = 40;
	private int titlefontSize = 15;
	private int textfontSize = 12;
	private boolean editModeStatus = false;
	private boolean creatorModeStatus = false;
	private JTextField textFieldHP;
	private JTextField textFieldHeight;
	private JTextField textFieldSpecialAttack;
	private JTextField textFieldSpecialDefense;
	private JTextField textFieldAttack;
	private JTextField textFieldWeight;
	private JTextField textFieldSpeed;
	private JTextField textFieldAbility1;
	private JTextField textFieldAbility2;
	private JTextField textFieldAbility3;
	private JTextField textFieldType1;
	private JTextField textFieldType2;
	private JButton btnEditActualPokemon;
	private JTextField textFieldPokemonName;
	private JTextField textFieldPokemonDefaultFrontSprite;
	private JTextField textFieldPokemonDefaultBackSprite;
	private JTextField textFieldPokemonShinyFrontSprite;
	private JTextField textFieldPokemonShinyBackSprite;
	private ArrayList<String> abilities;
	private ArrayList<String> sprites;
	private ArrayList<JLabel> pokemondataViewTextLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> pokemonabilitiesViewTextLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> pokemontypesViewTextLabels = new ArrayList<JLabel>();
	private ArrayList<JLabel> pokemonTitlesViewTextLabels = new ArrayList<JLabel>();
	private ArrayList<JTextField> pokemondataViewTextFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> pokemonAbilitiesViewTextFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> pokemonTypesViewTextFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> pokemonSpritesViewTextFields = new ArrayList<JTextField>();

	/**
	 * Create the panel.
	 */

	public PokedexView() {

		pokemonImageShiny[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[0];
		pokemonImageShiny[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[2];
		pokemonImageDefault[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[1];
		pokemonImageDefault[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[3];

		pokemonImage = pokemonImageDefault[0];

		setLayout(null);

		// Start -- Background

		JLabel lblBackground = new JLabel("No hay foto");

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (imagesCounter > 0) {
					imagesCounter--;
				}

				updateViewData();

			}
		});

		JLabel lblStatsTitle = new JLabel("Statistics");
		lblStatsTitle.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblStatsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatsTitle.setBounds(365, 131, widthDataTitles, heightDataTitles);
		add(lblStatsTitle);

		JLabel lblSpecialAttackTitle = new JLabel("Special Attack: ");
		lblSpecialAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblSpecialAttackTitle.setBounds(377, 229, widthDataLabels, heightDataLabels);
		add(lblSpecialAttackTitle);

		JLabel lblSpecialDefenseTitle = new JLabel("Special defense: ");
		lblSpecialDefenseTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblSpecialDefenseTitle.setBounds(377, 255, widthDataLabels, heightDataLabels);
		add(lblSpecialDefenseTitle);

		JLabel lblSpeedTitle = new JLabel("Speed:");
		lblSpeedTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblSpeedTitle.setBounds(502, 229, widthDataLabels, heightDataLabels);
		add(lblSpeedTitle);

		JLabel lblAttackTitle = new JLabel("Attack:");
		lblAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblAttackTitle.setBounds(502, 182, widthDataLabels, heightDataLabels);
		add(lblAttackTitle);

		JLabel lblHealthPointsTitle = new JLabel("Health: ");
		lblHealthPointsTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblHealthPointsTitle.setBounds(377, 182, widthDataLabels, heightDataLabels);
		add(lblHealthPointsTitle);

		lblPokemonName = new JLabel(pokemonData[0]);
		lblPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonName.setBounds(90, 387, 114, 30);

		lblPokemonPic = new JLabel("No Pic");

		btnPrevious.setBounds(10, 430, 85, 18);
		add(btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (imagesCounter < pokemonImage.length) {

					if (pokemonImage[imagesCounter + 1] != null) {

						imagesCounter++;

					}

				}

				updateViewData();

			}
		});
		btnNext.setBounds(209, 430, 85, 18);
		add(btnNext);

		JButton btnSwitchShiny = new JButton("Shiny");
		btnSwitchShiny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				shiny = !shiny;

				updateViewData();
			}
		});
		btnSwitchShiny.setBackground(Color.YELLOW);
		btnSwitchShiny.setBounds(110, 430, 85, 18);
		add(btnSwitchShiny);

		JLabel lblHeightTitle = new JLabel("Height: ");
		lblHeightTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblHeightTitle.setBounds(377, 206, widthDataLabels, heightDataLabels);
		add(lblHeightTitle);

		JLabel lblWeightTitle = new JLabel("Weight:");
		lblWeightTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblWeightTitle.setBounds(502, 205, widthDataLabels, heightDataLabels);
		add(lblWeightTitle);

		lblHealthPointsNumber = new JLabel(pokemonData[1]);
		lblHealthPointsNumber.setBounds(432, 182, widthNumberLabels, heightNumberLabels);

		lblSpecialDefenseNumber = new JLabel(pokemonData[4]);
		lblSpecialDefenseNumber.setBounds(473, 254, widthNumberLabels, heightNumberLabels);

		lblHeightNumber = new JLabel(pokemonData[6]);
		lblHeightNumber.setBounds(428, 206, widthNumberLabels, heightNumberLabels);

		lblWeightNumber = new JLabel(pokemonData[7]);
		lblWeightNumber.setBounds(550, 205, widthNumberLabels, heightNumberLabels);

		lblSpecialAttackNumber = new JLabel(pokemonData[3]);
		lblSpecialAttackNumber.setBounds(464, 230, widthNumberLabels, heightNumberLabels);

		lblSpeedNumber = new JLabel(pokemonData[5]);
		lblSpeedNumber.setBounds(550, 230, widthNumberLabels, heightNumberLabels);

		lblAttackNumber = new JLabel(pokemonData[2]);
		lblAttackNumber.setBounds(550, 183, widthNumberLabels, heightNumberLabels);

		JLabel lblAbilities = new JLabel("Abilities");
		lblAbilities.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilities.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblAbilities.setBounds(309, 289, widthDataTitles, heightDataTitles);
		add(lblAbilities);

		lblAbilitie1 = new JLabel("");
		lblAbilitie1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie1.setBounds(377, 320, 92, 21);

		lblAbilitie2 = new JLabel("");
		lblAbilitie2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie2.setBounds(378, 350, 92, 21);

		lblAbilitie3 = new JLabel("");
		lblAbilitie3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie3.setBounds(378, 380, 92, 21);

		JLabel lblTypes = new JLabel("Types");
		lblTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypes.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblTypes.setBounds(426, 289, widthDataTitles, heightDataTitles);
		add(lblTypes);

		lblType1 = new JLabel("");

		lblType1.setHorizontalAlignment(SwingConstants.CENTER);

		lblType1.setBounds(502, 320, 82, 21);

		lblType2 = new JLabel("");

		lblType2.setHorizontalAlignment(SwingConstants.CENTER);

		lblType2.setBounds(502, 350, 82, 21);

		btnNextPokemon = new JButton("Next");
		btnNextPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				nextPokemonData();

			}
		});
		btnNextPokemon.setBounds(511, 427, 85, 21);
		add(btnNextPokemon);

		btnPreviousPokemon = new JButton("Previous");
		btnPreviousPokemon.addActionListener(e -> {

			previousPokemonData();

		});
		btnPreviousPokemon.setBounds(365, 427, 85, 21);
		add(btnPreviousPokemon);

		JButton btnEditActualPokemon = new JButton("Edit");
		btnEditActualPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				editModeStatus = !editModeStatus;

				if (editModeStatus) {
					btnEditActualPokemon.setText("Finish");

				} else {
					btnEditActualPokemon.setText("Edit");
				}

				switchEditMode();
			}
		});

		btnEditActualPokemon.setBounds(623, 10, 85, 20);
		add(btnEditActualPokemon);

		textFieldHP = new JTextField(lblHealthPointsNumber.getText());
		textFieldHP.setBounds(432, 182, widthNumberLabels, heightNumberLabels);
		textFieldHeight = new JTextField(lblHeightNumber.getText());
		textFieldHeight.setBounds(428, 206, widthNumberLabels, heightNumberLabels);
		textFieldSpecialAttack = new JTextField(lblSpecialAttackNumber.getText());
		textFieldSpecialAttack.setBounds(464, 230, widthNumberLabels, heightNumberLabels);
		textFieldSpecialDefense = new JTextField(lblSpecialDefenseNumber.getText());
		textFieldSpecialDefense.setBounds(473, 254, widthNumberLabels, heightNumberLabels);
		textFieldAttack = new JTextField(lblAttackNumber.getText());
		textFieldAttack.setBounds(550, 183, widthNumberLabels, heightNumberLabels);
		textFieldWeight = new JTextField(lblWeightNumber.getText());
		textFieldWeight.setBounds(550, 205, widthNumberLabels, heightNumberLabels);
		textFieldSpeed = new JTextField(lblSpeedNumber.getText());
		textFieldSpeed.setBounds(550, 230, widthNumberLabels, heightNumberLabels);

		textFieldAbility1 = new JTextField(lblAbilitie1.getText());
		textFieldAbility1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAbility1.setBounds(377, 320, 92, 21);
		textFieldAbility2 = new JTextField(lblAbilitie2.getText());
		textFieldAbility2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAbility2.setBounds(378, 350, 92, 21);
		textFieldAbility3 = new JTextField(lblAbilitie3.getText());
		textFieldAbility3.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAbility3.setBounds(378, 380, 92, 21);

		textFieldType1 = new JTextField(lblType1.getText());
		textFieldType1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldType1.setBounds(502, 320, 82, 21);
		textFieldType2 = new JTextField(lblType2.getText());
		textFieldType2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldType2.setBounds(502, 350, 82, 21);

		textFieldPokemonName = new JTextField(lblPokemonName.getText());
		textFieldPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPokemonName.setBounds(90, 389, 114, 30);

		JButton btnNewButton = new JButton("New Pokemon");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creatorModeStatus = !creatorModeStatus;
				switchCreateNewPokemon();
			}
		});

		btnNewButton.setBounds(488, 10, 114, 21);
		add(btnNewButton);

		textFieldPokemonDefaultFrontSprite = new JTextField();
		textFieldPokemonDefaultFrontSprite.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPokemonDefaultFrontSprite.setText("Front Default Sprite");
		textFieldPokemonDefaultFrontSprite.setBounds(90, 187, 114, 19);
		textFieldPokemonDefaultFrontSprite.setColumns(10);

		textFieldPokemonDefaultBackSprite = new JTextField();
		textFieldPokemonDefaultBackSprite.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPokemonDefaultBackSprite.setText("Back Default Image");
		textFieldPokemonDefaultBackSprite.setColumns(10);
		textFieldPokemonDefaultBackSprite.setBounds(90, 260, 114, 19);

		textFieldPokemonShinyFrontSprite = new JTextField();
		textFieldPokemonShinyFrontSprite.setText("Front Shiny Image");
		textFieldPokemonShinyFrontSprite.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPokemonShinyFrontSprite.setColumns(10);
		textFieldPokemonShinyFrontSprite.setBounds(90, 222, 114, 19);

		textFieldPokemonShinyBackSprite = new JTextField();
		textFieldPokemonShinyBackSprite.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPokemonShinyBackSprite.setText("Back Shiny Image");
		textFieldPokemonShinyBackSprite.setColumns(10);
		textFieldPokemonShinyBackSprite.setBounds(90, 300, 114, 19);

		pokemondataViewTextLabels.add(lblPokemonName);
		pokemondataViewTextLabels.add(lblHealthPointsNumber);
		pokemondataViewTextLabels.add(lblAttackNumber);
		pokemondataViewTextLabels.add(lblSpecialAttackNumber);
		pokemondataViewTextLabels.add(lblSpecialDefenseNumber);
		pokemondataViewTextLabels.add(lblSpeedNumber);
		pokemondataViewTextLabels.add(lblHeightNumber);
		pokemondataViewTextLabels.add(lblWeightNumber);

		pokemonabilitiesViewTextLabels.add(lblAbilitie1);
		pokemonabilitiesViewTextLabels.add(lblAbilitie2);
		pokemonabilitiesViewTextLabels.add(lblAbilitie3);
		pokemontypesViewTextLabels.add(lblType1);
		pokemontypesViewTextLabels.add(lblType2);

		pokemonTitlesViewTextLabels.add(lblStatsTitle);
		pokemonTitlesViewTextLabels.add(lblAbilities);
		pokemonTitlesViewTextLabels.add(lblTypes);

		pokemondataViewTextFields.add(textFieldPokemonName);
		pokemondataViewTextFields.add(textFieldHP);
		pokemondataViewTextFields.add(textFieldAttack);
		pokemondataViewTextFields.add(textFieldSpecialAttack);
		pokemondataViewTextFields.add(textFieldSpecialDefense);
		pokemondataViewTextFields.add(textFieldSpeed);
		pokemondataViewTextFields.add(textFieldHeight);
		pokemondataViewTextFields.add(textFieldWeight);
		
		pokemonAbilitiesViewTextFields.add(textFieldAbility1);
		pokemonAbilitiesViewTextFields.add(textFieldAbility2);
		pokemonAbilitiesViewTextFields.add(textFieldAbility3);
		pokemonTypesViewTextFields.add(textFieldType1);
		pokemonTypesViewTextFields.add(textFieldType2);
		pokemonSpritesViewTextFields.add(textFieldPokemonDefaultFrontSprite);
		pokemonSpritesViewTextFields.add(textFieldPokemonDefaultBackSprite);
		pokemonSpritesViewTextFields.add(textFieldPokemonShinyFrontSprite);
		pokemonSpritesViewTextFields.add(textFieldPokemonShinyBackSprite);

		for (JLabel label : pokemondataViewTextLabels) {
			label.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
			add(label);
		}
		for (JLabel label : pokemonabilitiesViewTextLabels) {
			label.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
			add(label);
		}
		for (JLabel label : pokemontypesViewTextLabels) {
			label.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
			add(label);
		}
		for (JLabel label : pokemonTitlesViewTextLabels) {
			add(label);
		}
		for (JTextField label : pokemondataViewTextFields) {
			add(label);
		}
		for (JTextField label : pokemonAbilitiesViewTextFields) {
			add(label);
		}
		for (JTextField label : pokemonTypesViewTextFields) {
			add(label);
		}
		for (JTextField label : pokemonSpritesViewTextFields) {
			add(label);
		}

		try {
			lblPokemonPic = new JLabel(
					new ImageIcon(ImageIO.read(new URL(pokemonImage[0])).getScaledInstance(250, 250, 2)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		lblPokemonPic.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblPokemonPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonPic.setBounds(25, 121, 254, 260);
		add(lblPokemonPic);

		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Lr4arcd.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);

		lblBackground.setBounds(0, 0, 718, 469);

		add(lblBackground);

		changeVisibilityAllDataInputs(false);

		updateViewData();
		switchEditMode();

		setVisible(false);

	}

	public void nextPokemonData() {

		if (pokemonID + 10 <= pokemonMaxID) {

			shiny = false;

			pokemonID += 10;

			pokemonData = Controller.getPokemonDatafromDB(pokemonID);
			pokemonAbilities = Controller.getPokemonArrayfromDB(pokemonID, "abilities");
			pokemonSprites = Controller.getPokemonArrayfromDB(pokemonID, "sprites");
			pokemonTypes = Controller.getPokemonArrayfromDB(pokemonID, "types");

			imagesCounter = 0;

			updateViewData();

		}
	}

	public void previousPokemonData() {

		if (pokemonID - 10 >= pokemonMinID) {

			shiny = false;
			pokemonID -= 10;

			pokemonData = Controller.getPokemonDatafromDB(pokemonID);
			pokemonAbilities = Controller.getPokemonArrayfromDB(pokemonID, "abilities");
			pokemonSprites = Controller.getPokemonArrayfromDB(pokemonID, "sprites");
			pokemonTypes = Controller.getPokemonArrayfromDB(pokemonID, "types");

			imagesCounter = 0;

			updateViewData();

		}
	}

	public void changeVisibilityAllDataInputs(boolean status) {

		for (JTextField textField : pokemondataViewTextFields) {
			textField.setVisible(status);
		}
		for (JTextField textField : pokemonAbilitiesViewTextFields) {
			textField.setVisible(status);
		}
		for (JTextField textField : pokemonTypesViewTextFields) {
			textField.setVisible(status);
		}
		for (JTextField textField : pokemonSpritesViewTextFields) {
			textField.setVisible(status);
		}

	}

	public void changeVisibilityAllDatalabels(boolean status) {

		for (JLabel textLabel : pokemondataViewTextLabels) {
			textLabel.setVisible(status);
		}
		for (JLabel textLabel : pokemonabilitiesViewTextLabels) {
			textLabel.setVisible(status);
		}
		for (JLabel textLabel : pokemontypesViewTextLabels) {
			textLabel.setVisible(status);
		}

	}

	public void cleanAllInfo() {

		for (JTextField textField : pokemondataViewTextFields) {
			textField.setText("");
		}
		for (JTextField textField : pokemonAbilitiesViewTextFields) {
			textField.setText("");
		}
		for (JTextField textField : pokemonTypesViewTextFields) {
			textField.setText("");
		}
		for (JTextField textField : pokemonSpritesViewTextFields) {
			textField.setText("");
		}
		for (JLabel textLabel : pokemondataViewTextLabels) {
			textLabel.setText("");
		}
		for (JLabel textLabel : pokemonabilitiesViewTextLabels) {
			textLabel.setText("");
		}
		for (JLabel textLabel : pokemontypesViewTextLabels) {
			textLabel.setText("");
		}

	}

	public void updateViewData() {

		cleanAllInfo();
		
		pokemonData = Controller.getPokemonDatafromDB(pokemonID);
		pokemonAbilities = Controller.getPokemonArrayfromDB(pokemonID, "abilities");
		pokemonTypes = Controller.getPokemonArrayfromDB(pokemonID, "types");
		pokemonImageShiny[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[0];
		pokemonImageShiny[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[2];
		pokemonImageDefault[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[1];
		pokemonImageDefault[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[3];

		for (int i = 0; i < pokemonData.length; i++) {
			System.out.println("Habilidad " + i + " : " + pokemonData[i]);
		}

		for (int i = 0; i < pokemondataViewTextLabels.size(); i++) {
			pokemondataViewTextLabels.get(i).setText(pokemonData[i]);
			pokemondataViewTextFields.get(i).setText(pokemonData[i]);
		}

		for (int i = 0; i <= 3; i++) {
			if (i < pokemonAbilities.length) {
				pokemonabilitiesViewTextLabels.get(i).setText(pokemonAbilities[i]);
				pokemonAbilitiesViewTextFields.get(i).setText(pokemonAbilities[i]);
				
			}
		}

		for (int i = 0; i <= 3; i++) {
			if (i < pokemonTypes.length) {
				pokemontypesViewTextLabels.get(i).setText(pokemonTypes[i]);
				pokemonTypesViewTextFields.get(i).setText(pokemonTypes[i]);
			}
		}

		if (shiny) {
			pokemonImage = pokemonImageShiny[0];

		} else {
			pokemonImage = pokemonImageDefault[0];

		}

		ImageIcon imageIcon = null;

		try {

			imageIcon = new ImageIcon(new URL(pokemonImage[imagesCounter]));

		} catch (MalformedURLException e1) {

			e1.printStackTrace();
		}

		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		lblPokemonPic.setIcon(imageIcon);

	}

	public void switchEditMode() {

		System.out.println(editModeStatus);

		

		for (int i = 0; i < pokemondataViewTextLabels.size(); i++) {
			if (!pokemondataViewTextLabels.get(i).getText().equals(pokemondataViewTextFields.get(i).getText())) {
				System.out.println("El texto no coincide");
				System.out.println(pokemondataViewTextLabels.get(i).getText());
				System.out.println(pokemondataViewTextFields.get(i).getText());
				
				Controller.updatePokemonOnDB(pokemonID, textFieldPokemonName.getText(),
						Integer.parseInt(textFieldHP.getText()),
						Integer.parseInt(textFieldAttack.getText()),
						Integer.parseInt(textFieldHeight.getText()),
						Integer.parseInt(textFieldWeight.getText()),
						Integer.parseInt(textFieldSpecialAttack.getText()),
						Integer.parseInt(textFieldSpecialDefense.getText()),
						Integer.parseInt(textFieldSpeed.getText()));

			}
		}
					
		updateViewData();


		changeVisibilityAllDataInputs(editModeStatus);

		changeVisibilityAllDatalabels(!editModeStatus);

	}

	public void switchCreateNewPokemon() {

		abilities = new ArrayList<String>();
		sprites = new ArrayList<String>();
		// emptyStatus = true;
		if (!creatorModeStatus) {

			for (int i = 0; i < pokemonAbilities.length; i++) {

			}

			/*
			 * for (JTextField textField : allViewTextFields) { if
			 * (textField.getText().isBlank() || textField.getText().isEmpty()) {
			 * emptyStatus = true; } }
			 */

			/*
			 * 
			 * if (!textFieldHP.getText().equals("") &&
			 * !textFieldPokemonName.getText().equals("") &&
			 * !textFieldSpecialAttack.getText().equals("") &&
			 * !textFieldSpecialDefense.getText().equals("") &&
			 * !textFieldAttack.getText().equals("") &&
			 * !textFieldHeight.getText().equals("") &&
			 * !textFieldWeight.getText().equals("") && !textFieldSpeed.getText().equals("")
			 * && !textFieldAbility1.getText().equals("") &&
			 * !textFieldAbility2.getText().equals("") &&
			 * !textFieldAbility3.getText().equals("") &&
			 * !textFieldType1.getText().equals("") && !textFieldType2.getText().equals(""))
			 * {
			 * 
			 * if (!textFieldAbility1.getText().equals("")) {
			 * abilities.add(lblAbilitie1.getText()); } if
			 * (!textFieldAbility2.getText().equals("")) {
			 * abilities.add(lblAbilitie2.getText()); } if
			 * (!textFieldAbility3.getText().equals("")) {
			 * abilities.add(lblAbilitie2.getText()); } if
			 * (!textFieldPokemonDefaultBackSprite.getText().equals("")) {
			 * sprites.add(lblAbilitie1.getText()); } if
			 * (!textFieldPokemonDefaultFrontSprite.getText().equals("")) {
			 * sprites.add(lblAbilitie2.getText()); } if
			 * (!textFieldPokemonShinyBackSprite.getText().equals("")) {
			 * sprites.add(lblAbilitie2.getText()); } if
			 * (!textFieldPokemonShinyFrontSprite.getText().equals("")) {
			 * sprites.add(lblAbilitie2.getText()); }
			 * 
			 * 
			 * Controller.addPokemonToDatabase(textFieldPokemonName.getText(),"No - URL",
			 * Integer.parseInt(textFieldHP.getText()),
			 * Integer.parseInt(textFieldAttack.getText()),
			 * Integer.parseInt(textFieldSpecialAttack.getText()),
			 * Integer.parseInt(textFieldSpecialDefense.getText()),
			 * Integer.parseInt(textFieldSpeed.getText()),
			 * Integer.parseInt(textFieldHeight.getText()),
			 * Integer.parseInt(textFieldWeight.getText()),0, "["+abilities.toString()+"]",
			 * "sprites","forms","spawnPoints","types");
			 * 
			 * }
			 * 
			 * 
			 * }
			 */
			System.out.println("Habilidades" + abilities);

			textFieldPokemonShinyBackSprite.setText("Back Shiny Sprite");
			textFieldPokemonShinyFrontSprite.setText("Front Shiny Sprite");
			textFieldPokemonDefaultBackSprite.setText("Back Default Sprite");
			textFieldPokemonDefaultFrontSprite.setText("Front Default Sprite");

			changeVisibilityAllDatalabels(!creatorModeStatus);

			lblPokemonPic.setVisible(!editModeStatus);

			changeVisibilityAllDataInputs(creatorModeStatus);

			cleanAllInfo();

		}
	}
}
