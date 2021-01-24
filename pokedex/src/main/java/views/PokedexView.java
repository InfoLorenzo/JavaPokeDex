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

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import controller.Controller;
import views.modals.LoginUnsuccessful;

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
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PokedexView extends JPanel {

	private int contador = 0;
	private int[] pokemonIDsArray;
	private int pokemonMinID;
	private int pokemonMaxID;
	private int pokemonID;
	private boolean shiny = false;
	private String[] pokemonData;
	private String[] pokemonAbilities;
	private String[] pokemonSprites;
	private String[] pokemonTypes;
	private ArrayList<String> pokemonImageDefault = new ArrayList<String>();
	private ArrayList<String> pokemonImageShiny = new ArrayList<String>();
	private ArrayList<String> pokemonImage;
	private int imagesCounter = 1;
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
	private JLabel lblMinMaxID;
	private JButton btnPreviousPokemon;
	private JButton btnNextPokemon;
	private JButton btnSwitchShiny;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnDeletePokemon;
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
	private boolean emptyStatus = false;
	private boolean limited;
	private JSpinner spinner;
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
	private JMenuItem menuItemFind;
	private JMenuBar menuBar;
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
		limited = false;
		pokemonIDsArray = Controller.getInstance().getPokemonIDsFromDB();
		pokemonMinID = pokemonIDsArray[0];
		pokemonMaxID = pokemonIDsArray[pokemonIDsArray.length - 1];
		pokemonID = pokemonMinID;
		initialize();
	}

	public PokedexView(int[] pokemonIDsArray) {

		limited = true;
		this.pokemonIDsArray = pokemonIDsArray;
		pokemonMinID = pokemonIDsArray[0];
		pokemonMaxID = pokemonIDsArray[pokemonIDsArray.length - 1];
		pokemonID = pokemonMinID;
		
		initialize();
		
		menuBar.setVisible(false);
		btnDeletePokemon.setVisible(false);
	}

	private void initialize() {
		setLayout(null);

		// Start -- Background

		JLabel lblBackground = new JLabel("No hay foto");

		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (imagesCounter < pokemonImage.size()) {
					imagesCounter++;
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
		lblSpeedTitle.setBounds(515, 229, widthDataLabels, heightDataLabels);
		add(lblSpeedTitle);

		JLabel lblAttackTitle = new JLabel("Attack:");
		lblAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblAttackTitle.setBounds(515, 182, widthDataLabels, heightDataLabels);
		add(lblAttackTitle);

		JLabel lblHealthPointsTitle = new JLabel("Health: ");
		lblHealthPointsTitle.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblHealthPointsTitle.setBounds(377, 182, widthDataLabels, heightDataLabels);
		add(lblHealthPointsTitle);

		lblPokemonName = new JLabel("");
		lblPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonName.setBounds(90, 387, 114, 30);

		lblPokemonPic = new JLabel("No Pic"); 

		btnPrevious.setBounds(10, 430, 85, 18);
		add(btnPrevious);

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (imagesCounter > 0) {
					if (pokemonImage.get(imagesCounter - 1) != null) {

						imagesCounter--;
					}
				}
				updateViewData();
			}
		});
		btnNext.setBounds(209, 430, 85, 18);
		add(btnNext);

		btnSwitchShiny = new JButton("Shiny");
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
		lblWeightTitle.setBounds(515, 205, widthDataLabels, heightDataLabels);
		add(lblWeightTitle);

		lblHealthPointsNumber = new JLabel("");
		lblHealthPointsNumber.setBounds(432, 182, widthNumberLabels, heightNumberLabels);

		lblSpecialDefenseNumber = new JLabel("");
		lblSpecialDefenseNumber.setBounds(473, 254, widthNumberLabels, heightNumberLabels);

		lblHeightNumber = new JLabel("");
		lblHeightNumber.setBounds(428, 206, widthNumberLabels, heightNumberLabels);

		lblWeightNumber = new JLabel("");
		lblWeightNumber.setBounds(560, 205, widthNumberLabels, heightNumberLabels);

		lblSpecialAttackNumber = new JLabel("");
		lblSpecialAttackNumber.setBounds(464, 230, widthNumberLabels, heightNumberLabels);

		lblSpeedNumber = new JLabel("");
		lblSpeedNumber.setBounds(560, 230, widthNumberLabels, heightNumberLabels);

		lblAttackNumber = new JLabel("");
		lblAttackNumber.setBounds(560, 183, widthNumberLabels, heightNumberLabels);

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
		textFieldAttack.setBounds(555, 183, widthNumberLabels, heightNumberLabels);
		textFieldWeight = new JTextField(lblWeightNumber.getText());
		textFieldWeight.setBounds(555, 205, widthNumberLabels, heightNumberLabels);
		textFieldSpeed = new JTextField(lblSpeedNumber.getText());
		textFieldSpeed.setBounds(555, 230, widthNumberLabels, heightNumberLabels);

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

		JButton btnNewPokemon = new JButton("New Pokemon");
		btnNewPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				creatorModeStatus = !creatorModeStatus;

				if (creatorModeStatus) {
					btnNewPokemon.setText("Save");

				} else {
					btnNewPokemon.setText("New Pokemon");
				}

				switchCreateNewPokemon();
			}
		});

		btnNewPokemon.setBounds(468, 10, 124, 21);
		add(btnNewPokemon);

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

		lblPokemonPic = new JLabel(new ImageIcon(""));

		lblPokemonPic.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblPokemonPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonPic.setBounds(25, 121, 254, 260);
		add(lblPokemonPic);

		spinner = new JSpinner();
		spinner.setBounds(233, 39, 61, 22);
		add(spinner);

		lblMinMaxID = new JLabel();
		lblMinMaxID.setBounds(182, 42, 50, 15);
		add(lblMinMaxID);

		JButton btnFindButton = new JButton("Find");
		btnFindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((int) spinner.getValue() <= pokemonIDsArray.length - 1 && (int) spinner.getValue() >= 0) {
					contador = (int) spinner.getValue();
					pokemonID = pokemonIDsArray[contador];

				}

				System.out.println(contador);
				System.out.println(pokemonID);

				updateViewData();
			}
		});
		btnFindButton.setBounds(182, 74, 89, 18);
		add(btnFindButton);

		btnDeletePokemon = new JButton("Delete");
		btnDeletePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().deleteOnDB("pokemon", pokemonID);

				if (contador > 0) {
					previousPokemonData();
				} else {
					nextPokemonData();
				}

			}
		});
		btnDeletePokemon.setBounds(623, 39, 85, 21);
		add(btnDeletePokemon);

		menuBar = new JMenuBar();
		menuBar.setBounds(350, 0, 50, 22);
		add(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		menuItemFind = new JMenuItem("Find ");

		menuItemFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Mono");

				FindView findModal = new FindView();
				findModal.newScreen();

			}
		});
		mnMenu.add(menuItemFind);
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

		setVisible(false);

	}

	public void nextPokemonData() {

		if (pokemonID + 10 <= (pokemonMaxID * 10 + pokemonMinID)) {

			shiny = false;

			if (contador < pokemonIDsArray.length - 1) {
				contador++;
			}

			pokemonID = pokemonIDsArray[contador];

			imagesCounter = 1;
			updateViewData();

		}
	}

	public void previousPokemonData() {

		if (pokemonID - 10 >= pokemonMinID) {

			shiny = false;

			if (contador > 0) {
				contador--;
			}

			pokemonID = pokemonIDsArray[contador];

			imagesCounter = 1;
			/*
			 * while (Controller.getInstance().getPokemonDatafromDB(pokemonID)==null) {
			 * 
			 * if (pokemonID-10 >= pokemonMinID) { pokemonID -= 10; }
			 * 
			 * }
			 */
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

		Controller.getInstance().getMaxRowsOnTable("pokemon");

		System.out.println("PokemonMinID: " + pokemonMinID);
		System.out.println("PokemonMaxID: " + pokemonMaxID);

		/*
		 * while (Controller.getInstance().getPokemonDatafromDB(pokemonID)==null) {
		 * 
		 * if (pokemonID-10 >= pokemonMinID) { pokemonID -= 10; }else if(pokemonID+10 <=
		 * pokemonMaxID) { pokemonID += 10; }
		 * 
		 * }
		 */

		if (!limited) {
			pokemonIDsArray = Controller.getInstance().getPokemonIDsFromDB();
		}

		pokemonMinID = pokemonIDsArray[0];
		pokemonMaxID = pokemonIDsArray[pokemonIDsArray.length - 1];
		pokemonData = Controller.getInstance().getPokemonDatafromDB(pokemonID);
		pokemonAbilities = Controller.getInstance().getPokemonArrayfromDB(pokemonID, "abilities");
		pokemonTypes = Controller.getInstance().getPokemonArrayfromDB(pokemonID, "types");
		pokemonSprites = Controller.getInstance().getPokemonArrayfromDB(pokemonID, "sprites");
		pokemonImageShiny = Controller.getInstance().getPokemonSprites(pokemonSprites)[0];
		pokemonImageDefault = Controller.getInstance().getPokemonSprites(pokemonSprites)[1];

		lblMinMaxID.setText(contador + "/" + (pokemonIDsArray.length - 1));

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
			pokemonImage = pokemonImageShiny;

			System.out.println("Images Shiny " + pokemonImageShiny.toString());

		} else {
			pokemonImage = pokemonImageDefault;

			System.out.println("Images Default " + pokemonImageDefault.toString());

		}

		ImageIcon imageIcon = null;

		try {

			imageIcon = new ImageIcon(new URL(pokemonImage.get(imagesCounter)));

		} catch (MalformedURLException e1) {
			imagesCounter = 1;
			e1.printStackTrace();
		}

		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		lblPokemonPic.setIcon(imageIcon);

	}

	public void switchEditMode() {

		System.out.println(editModeStatus);

		if (!editModeStatus) {
			Controller.getInstance().updatePokemonOnDB(pokemonID, textFieldPokemonName.getText(),
					Integer.parseInt(textFieldHP.getText()), Integer.parseInt(textFieldAttack.getText()),
					Integer.parseInt(textFieldHeight.getText()), Integer.parseInt(textFieldWeight.getText()),
					Integer.parseInt(textFieldSpecialAttack.getText()),
					Integer.parseInt(textFieldSpecialDefense.getText()), Integer.parseInt(textFieldSpeed.getText()),
					textFieldAbility1.getText(), textFieldAbility2.getText(), textFieldAbility3.getText(),
					textFieldType1.getText(), textFieldType2.getText());
		}

		updateViewData();

		changeVisibilityAllDataInputs(editModeStatus);

		changeVisibilityAllDatalabels(!editModeStatus);

	}

	public void switchCreateNewPokemon() {

		emptyStatus = false;

		for (int i = 0; i < pokemondataViewTextFields.size(); i++) {
			if (pokemondataViewTextFields.get(i).getText().isBlank()) {
				emptyStatus = true;
			}
			if (i + 1 <= pokemonAbilitiesViewTextFields.size()) {
				if (pokemonAbilitiesViewTextFields.get(i).getText().isBlank()) {
					emptyStatus = true;
				}
			}
			if (i + 1 <= pokemonTypesViewTextFields.size()) {
				if (pokemonTypesViewTextFields.get(i).getText().isBlank()) {
					emptyStatus = true;
				}
			}
		}

		System.out.println(emptyStatus);

		if (!emptyStatus) {

			Controller.getInstance().addPokemonToDatabase(textFieldPokemonName.getText(), "pokeprofileURL",
					Integer.parseInt(textFieldHP.getText()), Integer.parseInt(textFieldAttack.getText()),
					Integer.parseInt(textFieldSpecialAttack.getText()),
					Integer.parseInt(textFieldSpecialDefense.getText()), Integer.parseInt(textFieldSpeed.getText()),
					Integer.parseInt(textFieldHeight.getText()), Integer.parseInt(textFieldWeight.getText()), 0,
					"[" + textFieldAbility1.getText() + ", " + textFieldAbility2.getText() + ", "
							+ textFieldAbility3.getText() + "]",
					"[" + textFieldPokemonDefaultFrontSprite.getText() + ", "
							+ textFieldPokemonDefaultBackSprite.getText() + ", "
							+ textFieldPokemonShinyFrontSprite.getText() + ", "
							+ textFieldPokemonShinyBackSprite.getText() + "]",
					"forms", "spawnPoints", "[" + textFieldType1.getText() + ", " + textFieldType2.getText() + "]");

		}

		updateViewData();

		changeVisibilityAllDataInputs(creatorModeStatus);

		btnNextPokemon.setVisible(!creatorModeStatus);
		btnPreviousPokemon.setVisible(!creatorModeStatus);
		btnPrevious.setVisible(!creatorModeStatus);
		btnNext.setVisible(!creatorModeStatus);
		btnSwitchShiny.setVisible(!creatorModeStatus);

		changeVisibilityAllDatalabels(!creatorModeStatus);

		lblPokemonPic.setVisible(!creatorModeStatus);

		if (creatorModeStatus) {
			cleanAllInfo();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemFind) {
			System.out.println("Menu llamado");
		}
	}
}
