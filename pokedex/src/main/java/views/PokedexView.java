package views;

import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
		lblPokemonName.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonName.setBounds(90, 387, 114, 30);
		add(lblPokemonName);

		lblPokemonPic = new JLabel("No Pic");

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
		lblHealthPointsNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblHealthPointsNumber.setBounds(432, 182, widthNumberLabels, heightNumberLabels);
		add(lblHealthPointsNumber);

		lblSpecialDefenseNumber = new JLabel(pokemonData[4]);
		lblSpecialDefenseNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblSpecialDefenseNumber.setBounds(473, 254, widthNumberLabels, heightNumberLabels);
		add(lblSpecialDefenseNumber);

		lblHeightNumber = new JLabel(pokemonData[6]);
		lblHeightNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblHeightNumber.setBounds(428, 206, widthNumberLabels, heightNumberLabels);
		add(lblHeightNumber);

		lblWeightNumber = new JLabel(pokemonData[7]);
		lblWeightNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblWeightNumber.setBounds(550, 205, widthNumberLabels, heightNumberLabels);
		add(lblWeightNumber);

		lblSpecialAttackNumber = new JLabel(pokemonData[3]);
		lblSpecialAttackNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblSpecialAttackNumber.setBounds(464, 230, widthNumberLabels, heightNumberLabels);
		add(lblSpecialAttackNumber);

		lblSpeedNumber = new JLabel(pokemonData[5]);
		lblSpeedNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblSpeedNumber.setBounds(550, 230, widthNumberLabels, heightNumberLabels);
		add(lblSpeedNumber);

		lblAttackNumber = new JLabel(pokemonData[2]);
		lblAttackNumber.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblAttackNumber.setBounds(550, 183, widthNumberLabels, heightNumberLabels);
		add(lblAttackNumber);

		JLabel lblAbilities = new JLabel("Abilities");
		lblAbilities.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilities.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblAbilities.setBounds(309, 289, widthDataTitles, heightDataTitles);
		add(lblAbilities);

		lblAbilitie1 = new JLabel("");
		lblAbilitie1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie1.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblAbilitie1.setBounds(381, 320, 82, 21);
		add(lblAbilitie1);

		lblAbilitie2 = new JLabel("");
		lblAbilitie2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie2.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblAbilitie2.setBounds(378, 350, 92, 21);
		add(lblAbilitie2);

		lblAbilitie3 = new JLabel("");
		lblAbilitie3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie3.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblAbilitie3.setBounds(378, 380, 82, 21);
		add(lblAbilitie3);

		JLabel lblTypes = new JLabel("Types");
		lblTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypes.setFont(new Font("Tahoma", Font.PLAIN, titlefontSize));
		lblTypes.setBounds(426, 289, widthDataTitles, heightDataTitles);
		add(lblTypes);

		lblType1 = new JLabel("");

		lblType1.setHorizontalAlignment(SwingConstants.CENTER);
		lblType1.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblType1.setBounds(502, 329, 82, 21);
		add(lblType1);

		lblType2 = new JLabel("");

		lblType2.setHorizontalAlignment(SwingConstants.CENTER);
		lblType2.setFont(new Font("Tahoma", Font.PLAIN, textfontSize));
		lblType2.setBounds(499, 363, 82, 21);
		add(lblType2);

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
		textFieldAbility1.setBounds(381, 320, 82, 21);
		textFieldAbility2 = new JTextField(lblAbilitie2.getText());
		textFieldAbility2.setBounds(378, 350, 92, 21);
		textFieldAbility3 = new JTextField(lblAbilitie3.getText());
		textFieldAbility3.setBounds(378, 380, 82, 21);

		textFieldType1 = new JTextField(lblType1.getText());
		textFieldType1.setBounds(502, 329, 82, 21);
		textFieldType2 = new JTextField(lblType2.getText());
		textFieldType2.setBounds(499, 363, 82, 21);

		add(textFieldHP);
		add(textFieldHeight);
		add(textFieldSpecialAttack);
		add(textFieldSpecialDefense);
		add(textFieldAttack);
		add(textFieldWeight);
		add(textFieldAbility1);
		add(textFieldAbility2);
		add(textFieldAbility3);
		add(textFieldType1);
		add(textFieldType2);

		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Lr4arcd.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);

		lblBackground.setBounds(0, 0, 718, 469);

		add(lblBackground);
		
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

	public void updateViewData() {

		lblAbilitie1.setText("");
		lblAbilitie2.setText("");
		lblAbilitie3.setText("");

		lblType1.setText("");
		lblType2.setText("");

		pokemonImageShiny[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[0];
		pokemonImageShiny[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[2];
		pokemonImageDefault[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[1];
		pokemonImageDefault[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[3];

		lblPokemonName.setText(pokemonData[0]);
		lblHealthPointsNumber.setText(pokemonData[1]);
		lblAttackNumber.setText(pokemonData[2]);
		lblSpecialAttackNumber.setText(pokemonData[3]);
		lblSpecialDefenseNumber.setText(pokemonData[4]);
		lblSpeedNumber.setText(pokemonData[5]);
		lblHeightNumber.setText(pokemonData[6]);
		lblWeightNumber.setText(pokemonData[7]);

		if (pokemonAbilities.length > 0) {
			lblAbilitie1.setText(pokemonAbilities[0]);
		}
		if (pokemonAbilities.length > 1) {
			lblAbilitie2.setText(pokemonAbilities[1]);
		}
		if (pokemonAbilities.length > 2) {
			lblAbilitie3.setText(pokemonAbilities[2]);
		}

		if (pokemonTypes.length > 0) {
			lblType1.setText(pokemonTypes[0]);
		}
		if (pokemonTypes.length > 1) {
			lblType2.setText(pokemonTypes[1]);
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

		revalidate();
		repaint();
	}

	public void switchEditMode() {

		System.out.println(editModeStatus);
		
		if (!editModeStatus) {

			System.out.println("Ha entrado en el if");
			
			if (!textFieldHP.getText().equals(lblHealthPointsNumber.getText())
					|| !textFieldSpecialAttack.getText().equals(lblSpecialAttackNumber.getText())
					|| !textFieldSpecialDefense.getText().equals(lblSpecialDefenseNumber.getText())
					|| !textFieldAttack.getText().equals(lblAttackNumber.getText())
					|| !textFieldHeight.getText().equals(lblHeightNumber.getText())
					|| !textFieldWeight.getText().equals(lblWeightNumber.getText())
					|| !textFieldSpeed.getText().equals(lblSpeedNumber.getText())
					|| !textFieldAbility1.getText().equals(lblAbilitie1.getText())
					|| !textFieldAbility2.getText().equals(lblAbilitie2.getText())
					|| !textFieldAbility3.getText().equals(lblAbilitie3.getText())
					|| !textFieldType1.getText().equals(lblType1.getText())
					|| !textFieldType2.getText().equals(lblType2.getText())) {

				
				Controller.updatePokemonOnDB(pokemonID, lblPokemonName.getText(),
						Integer.parseInt(textFieldHP.getText()),
						Integer.parseInt(textFieldAttack.getText()),
						Integer.parseInt(textFieldHeight.getText()),
						Integer.parseInt(textFieldWeight.getText()),
						Integer.parseInt(textFieldSpecialAttack.getText()),
						Integer.parseInt(textFieldSpecialDefense.getText()),
						Integer.parseInt(textFieldSpeed.getText()));
				
				

			}
			
			pokemonData = Controller.getPokemonDatafromDB(pokemonID);
			pokemonAbilities = Controller.getPokemonArrayfromDB(pokemonID, "abilities");
			pokemonTypes = Controller.getPokemonArrayfromDB(pokemonID, "types");
			
			updateViewData();

		}
		
		textFieldHP.setVisible(editModeStatus);
		textFieldHeight.setVisible(editModeStatus);
		textFieldSpecialAttack.setVisible(editModeStatus);
		textFieldSpecialDefense.setVisible(editModeStatus);
		textFieldAttack.setVisible(editModeStatus);
		textFieldWeight.setVisible(editModeStatus);
		textFieldSpeed.setVisible(editModeStatus);
		textFieldAbility1.setVisible(editModeStatus);
		textFieldAbility2.setVisible(editModeStatus);
		textFieldAbility3.setVisible(editModeStatus);
		textFieldType1.setVisible(editModeStatus);
		textFieldType2.setVisible(editModeStatus);

		lblHealthPointsNumber.setVisible(!editModeStatus);
		lblHeightNumber.setVisible(!editModeStatus);
		lblSpecialAttackNumber.setVisible(!editModeStatus);
		lblSpecialDefenseNumber.setVisible(!editModeStatus);
		lblAttackNumber.setVisible(!editModeStatus);
		lblWeightNumber.setVisible(!editModeStatus);
		lblSpeedNumber.setVisible(!editModeStatus);
		lblAbilitie1.setVisible(!editModeStatus);
		lblAbilitie2.setVisible(!editModeStatus);
		lblAbilitie3.setVisible(!editModeStatus);
		lblType1.setVisible(!editModeStatus);
		lblType2.setVisible(!editModeStatus);

		textFieldHP.setText(lblHealthPointsNumber.getText());
		textFieldHeight.setText(lblHeightNumber.getText());
		textFieldSpecialAttack.setText(lblSpecialAttackNumber.getText());
		textFieldSpecialDefense.setText(lblSpecialDefenseNumber.getText());
		textFieldAttack.setText(lblAttackNumber.getText());
		textFieldWeight.setText(lblWeightNumber.getText());
		textFieldSpeed.setText(lblSpeedNumber.getText());
		textFieldAbility1.setText(lblAbilitie1.getText());
		textFieldAbility2.setText(lblAbilitie2.getText());
		textFieldAbility3.setText(lblAbilitie3.getText());
		textFieldType1.setText(lblType1.getText());
		textFieldType2.setText(lblType2.getText());

	}
}
