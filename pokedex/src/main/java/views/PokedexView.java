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
		lblStatsTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatsTitle.setBounds(365, 131, 231, 30);
		add(lblStatsTitle);

		JLabel lblSpecialAttackTitle = new JLabel("Special Attack: ");
		lblSpecialAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialAttackTitle.setBounds(491, 205, 104, 13);
		add(lblSpecialAttackTitle);

		JLabel lblSpecialDefenseTitle = new JLabel("Special defense: ");
		lblSpecialDefenseTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialDefenseTitle.setBounds(377, 205, 104, 13);
		add(lblSpecialDefenseTitle);

		JLabel lblSpeedTitle = new JLabel("Speed:");
		lblSpeedTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpeedTitle.setBounds(438, 251, 45, 13);
		add(lblSpeedTitle);

		JLabel lblAttackTitle = new JLabel("Attack:");
		lblAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttackTitle.setBounds(491, 182, 45, 13);
		add(lblAttackTitle);

		JLabel lblHealthPointsTitle = new JLabel("HP: ");
		lblHealthPointsTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHealthPointsTitle.setBounds(377, 182, 45, 13);
		add(lblHealthPointsTitle);

		lblPokemonName = new JLabel(pokemonData[0]);
		lblPokemonName.setFont(new Font("Tahoma", Font.PLAIN, 12));
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

		lblPokemonPic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPokemonPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonPic.setBounds(25, 121, 254, 260);
		add(lblPokemonPic);
		btnPrevious.setBounds(10, 427, 85, 21);
		add(btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (imagesCounter < pokemonImage.length) {
					
					if (pokemonImage[imagesCounter+1] != null) {
						
						imagesCounter++;
					}
					
				}
				
				updateViewData();

			}
		});
		btnNext.setBounds(208, 427, 85, 21);
		add(btnNext);

		JButton btnSwitchShiny = new JButton("Shiny");
		btnSwitchShiny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				shiny = !shiny;

				if (shiny) {
					pokemonImage = pokemonImageShiny[0];

					imagesCounter = 0;
				} else {
					pokemonImage = pokemonImageDefault[0];

					imagesCounter = 0;
				}
				
				updateViewData();
			}
		});
		btnSwitchShiny.setBackground(Color.YELLOW);
		btnSwitchShiny.setBounds(113, 427, 85, 21);
		add(btnSwitchShiny);

		JLabel lblHeightTitle = new JLabel("Height: ");
		lblHeightTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHeightTitle.setBounds(377, 228, 45, 13);
		add(lblHeightTitle);

		JLabel lblWeightTitle = new JLabel("Weight:");
		lblWeightTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWeightTitle.setBounds(491, 228, 45, 13);
		add(lblWeightTitle);

		lblHealthPointsNumber = new JLabel(pokemonData[1]);
		lblHealthPointsNumber.setBounds(399, 183, 45, 13);
		add(lblHealthPointsNumber);

		lblSpecialDefenseNumber = new JLabel(pokemonData[4]);
		lblSpecialDefenseNumber.setBounds(473, 206, 45, 13);
		add(lblSpecialDefenseNumber);

		lblHeightNumber = new JLabel(pokemonData[6]);
		lblHeightNumber.setBounds(428, 228, 45, 13);
		add(lblHeightNumber);

		lblWeightNumber = new JLabel(pokemonData[7]);
		lblWeightNumber.setBounds(535, 229, 45, 13);
		add(lblWeightNumber);

		lblSpecialAttackNumber = new JLabel(pokemonData[3]);
		lblSpecialAttackNumber.setBounds(578, 206, 45, 13);
		add(lblSpecialAttackNumber);

		lblSpeedNumber = new JLabel(pokemonData[5]);
		lblSpeedNumber.setBounds(486, 252, 45, 13);
		add(lblSpeedNumber);

		lblAttackNumber = new JLabel(pokemonData[2]);
		lblAttackNumber.setBounds(535, 183, 45, 13);
		add(lblAttackNumber);

		JLabel lblAbilities = new JLabel("Abilities");
		lblAbilities.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbilities.setBounds(365, 274, 114, 50);
		add(lblAbilities);

		lblAbilitie1 = new JLabel(pokemonAbilities[0]);
		lblAbilitie1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbilitie1.setBounds(378, 314, 82, 21);
		add(lblAbilitie1);

		if (pokemonAbilities.length >= 2) {

			lblAbilitie2 = new JLabel(pokemonAbilities[1]);
		} else {
			lblAbilitie2 = new JLabel("");
		}

		lblAbilitie2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbilitie2.setBounds(378, 338, 92, 21);
		add(lblAbilitie2);

		if (pokemonAbilities.length >= 3) {

			lblAbilitie3 = new JLabel(pokemonAbilities[2]);
		} else {
			lblAbilitie3 = new JLabel("");
		}

		lblAbilitie3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbilitie3.setBounds(378, 363, 82, 21);
		add(lblAbilitie3);

		JLabel lblTypes = new JLabel("Types");
		lblTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypes.setBounds(480, 274, 114, 50);
		add(lblTypes);

		lblType1 = new JLabel(pokemonTypes[0]);

		lblType1.setHorizontalAlignment(SwingConstants.CENTER);
		lblType1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType1.setBounds(496, 324, 82, 21);
		add(lblType1);

		lblType2 = new JLabel(pokemonTypes[1]);

		if (pokemonTypes.length >= 2) {

			lblType2 = new JLabel(pokemonTypes[1]);
		} else {
			lblType2 = new JLabel("");
		}

		lblType2.setHorizontalAlignment(SwingConstants.CENTER);
		lblType2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType2.setBounds(496, 348, 82, 21);
		add(lblType2);

		JButton btnNextPokemon = new JButton("Next");
		btnNextPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextPokemonData();
			}
		});
		btnNextPokemon.setBounds(511, 427, 85, 21);
		add(btnNextPokemon);

		JButton btnPreviousPokemon = new JButton("Previous");
		btnPreviousPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousPokemonData();
			}
		});
		btnPreviousPokemon.setBounds(365, 427, 85, 21);
		add(btnPreviousPokemon);
		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Lr4arcd.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);

		lblBackground.setBounds(0, 0, 718, 469);

		// End -- Background

		pokemonImage = pokemonImageDefault[0];

		add(lblBackground);

	}

	public void nextPokemonData() {

		if (pokemonID + 10 <= pokemonMaxID) {

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

		
		pokemonImageShiny[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[0];
		pokemonImageShiny[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[2];
		pokemonImageDefault[0] = Controller.getPokemonSpritesDivided(pokemonSprites)[1];
		pokemonImageDefault[1] = Controller.getPokemonSpritesDivided(pokemonSprites)[3];

		
		
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
}
