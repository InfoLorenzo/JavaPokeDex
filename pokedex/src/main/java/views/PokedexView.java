package views;

import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.Controller;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class PokedexView extends JPanel {

	private int pokemonMinID = 1111;
	private int pokemonMaxID = 3101;
	private int pokemonID = pokemonMinID;
	private String[] pokemonData = Controller.getPokemonDatafromDB(pokemonID);

	/**
	 * Create the panel.
	 */
	public PokedexView() {

		setLayout(null);

		// Start -- Background

		JLabel lblBackground = new JLabel("No hay foto");

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		JLabel lblPokemonName = new JLabel(pokemonData[0]);
		lblPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonName.setBounds(90, 387, 114, 30);
		add(lblPokemonName);

		JLabel lblPokemonPic = new JLabel("No Pic");
		lblPokemonPic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPokemonPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonPic.setBounds(25, 121, 254, 260);
		add(lblPokemonPic);
		btnPrevious.setBounds(10, 427, 85, 21);
		add(btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(208, 427, 85, 21);
		add(btnNext);

		JButton btnSwitchShiny = new JButton("Shiny");
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

		JLabel lblHealthPointsNumber = new JLabel(pokemonData[1]);
		lblHealthPointsNumber.setBounds(399, 183, 45, 13);
		add(lblHealthPointsNumber);

		JLabel lblSpecialDefenseNumber = new JLabel(pokemonData[4]);
		lblSpecialDefenseNumber.setBounds(473, 206, 45, 13);
		add(lblSpecialDefenseNumber);

		JLabel lblHeightNumber = new JLabel(pokemonData[6]);
		lblHeightNumber.setBounds(428, 228, 45, 13);
		add(lblHeightNumber);

		JLabel lblWeightNumber = new JLabel(pokemonData[7]);
		lblWeightNumber.setBounds(535, 229, 45, 13);
		add(lblWeightNumber);

		JLabel lblSpecialAttackNumber = new JLabel(pokemonData[3]);
		lblSpecialAttackNumber.setBounds(578, 206, 45, 13);
		add(lblSpecialAttackNumber);

		JLabel lblSpeedNumber = new JLabel(pokemonData[5]);
		lblSpeedNumber.setBounds(486, 252, 45, 13);
		add(lblSpeedNumber);

		JLabel lblAttackNumber = new JLabel(pokemonData[2]);
		lblAttackNumber.setBounds(535, 183, 45, 13);
		add(lblAttackNumber);

		JLabel lblAbilities = new JLabel("Abilities");
		lblAbilities.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbilities.setBounds(365, 274, 114, 50);
		add(lblAbilities);

		JLabel lblAbilitie1 = new JLabel("First abilitie");
		lblAbilitie1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbilitie1.setBounds(378, 314, 82, 21);
		add(lblAbilitie1);

		JLabel lblAbilitie2 = new JLabel("Second Abilitie");
		lblAbilitie2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbilitie2.setBounds(378, 338, 82, 21);
		add(lblAbilitie2);

		JLabel lblAbilitie3 = new JLabel("Third Abilitie");
		lblAbilitie3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitie3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbilitie3.setBounds(378, 363, 82, 21);
		add(lblAbilitie3);

		JLabel lblTypes = new JLabel("Types");
		lblTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypes.setBounds(480, 274, 114, 50);
		add(lblTypes);

		JLabel lblType1 = new JLabel("Type 1");
		lblType1.setHorizontalAlignment(SwingConstants.CENTER);
		lblType1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType1.setBounds(496, 324, 82, 21);
		add(lblType1);

		JLabel lblType2 = new JLabel("Type 2");
		lblType2.setHorizontalAlignment(SwingConstants.CENTER);
		lblType2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType2.setBounds(496, 348, 82, 21);
		add(lblType2);
		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Lr4arcd.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);

		lblBackground.setBounds(0, 0, 718, 469);

		// End -- Background

		add(lblBackground);

	}

}
