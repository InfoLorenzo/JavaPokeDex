package views;

import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class PokedexView extends JPanel {


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

		JLabel lblSpecialAttackTitle = new JLabel("Special Attack: ");
		lblSpecialAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialAttackTitle.setBounds(491, 228, 104, 13);
		add(lblSpecialAttackTitle);

		JLabel lblSpecialDefenseTitle = new JLabel("Special defense: ");
		lblSpecialDefenseTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialDefenseTitle.setBounds(377, 228, 104, 13);
		add(lblSpecialDefenseTitle);

		JLabel lblSpeedTitle = new JLabel("Speed:");
		lblSpeedTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpeedTitle.setBounds(491, 205, 45, 13);
		add(lblSpeedTitle);

		JLabel lblDefenseTitle = new JLabel("Defense: ");
		lblDefenseTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDefenseTitle.setBounds(377, 205, 60, 13);
		add(lblDefenseTitle);

		JLabel lblAttackTitle = new JLabel("Attack:");
		lblAttackTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttackTitle.setBounds(491, 182, 45, 13);
		add(lblAttackTitle);

		JLabel lblHealthPointsTitle = new JLabel("HP: ");
		lblHealthPointsTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHealthPointsTitle.setBounds(377, 182, 45, 13);
		add(lblHealthPointsTitle);

		JLabel lblStatsTitle = new JLabel("Statistics");
		lblStatsTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatsTitle.setBounds(365, 131, 231, 30);
		add(lblStatsTitle);

		JLabel lblPokemonName = new JLabel("Name");
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
		lblHeightTitle.setBounds(377, 251, 45, 13);
		add(lblHeightTitle);

		JLabel lblWeightTitle = new JLabel("Weight:");
		lblWeightTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblWeightTitle.setBounds(491, 251, 45, 13);
		add(lblWeightTitle);
		try {
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblHealthPointsNumber = new JLabel("0");
		lblHealthPointsNumber.setBounds(399, 183, 45, 13);
		add(lblHealthPointsNumber);
		
		JLabel lblDefensePointsNumber = new JLabel("0");
		lblDefensePointsNumber.setBounds(428, 205, 45, 13);
		add(lblDefensePointsNumber);
		
		JLabel lblSpecialDefenseNumber = new JLabel("0");
		lblSpecialDefenseNumber.setBounds(467, 229, 45, 13);
		add(lblSpecialDefenseNumber);
		
		JLabel lblHeightNumber = new JLabel("0");
		lblHeightNumber.setBounds(417, 251, 45, 13);
		add(lblHeightNumber);
		
		JLabel lblWeightNumber = new JLabel("0");
		lblWeightNumber.setBounds(535, 252, 45, 13);
		add(lblWeightNumber);
		
		JLabel lblSpecialAttackNumber = new JLabel("0");
		lblSpecialAttackNumber.setBounds(578, 229, 45, 13);
		add(lblSpecialAttackNumber);
		
		JLabel lblSpeedNumber = new JLabel("0");
		lblSpeedNumber.setBounds(535, 206, 45, 13);
		add(lblSpeedNumber);
						
						JLabel lblAttackNumber = new JLabel("0");
						lblAttackNumber.setBounds(535, 183, 45, 13);
						add(lblAttackNumber);
						lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Lr4arcd.png"))));
						lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
						
								lblBackground.setBounds(0, 0, 718, 469);
								
										// End -- Background
								
										add(lblBackground);

	}
	
	public 
}
