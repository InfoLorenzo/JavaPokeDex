package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import controller.Controller;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;

public class FindView extends JFrame {

	private JFrame frame;
	private JPanel findPanel;
	private JPanel pokedex;
	private JTextField textFieldQueryName;
	private JTextField textFieldQueryTypes;
	private JTextField textFieldQueryAbilities;

	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindView window = new FindView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public FindView() {
		initialize();
	}
	
	public static JLayeredPane layeredPane = new JLayeredPane();

	public static JLayeredPane getLayeredPanel() {
		return layeredPane;
	}

	private void initialize() { 
		frame = new JFrame();
		frame.setBounds(0, 0, 729, 498);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblBackground = new JLabel("No hay foto");

		JLabel lblTitle = new JLabel("No hay foto");
		try {
			lblTitle = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/210123/92c7f869ff8e43cce5d3057286d3b4f7.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);

		lblTitle.setBounds(204, 22, 301, 92);

		ImageIcon imageforReturn = null;
		try {
			imageforReturn = new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/210114/e20cc361a851b6737f42fb1a08604fe4.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		final JButton btnreturn = new JButton("", imageforReturn);
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón de vuelta pulsado");

				frame.setVisible(false);

			}
		});
		frame.getContentPane().setLayout(null);

		btnreturn.setPreferredSize(new Dimension(78, 76));
		btnreturn.setOpaque(false);
		btnreturn.setHorizontalTextPosition(SwingConstants.CENTER);
		btnreturn.setFocusable(false);
		btnreturn.setContentAreaFilled(false);
		btnreturn.setBorderPainted(false);
		btnreturn.setBackground(new Color(53, 106, 188));
		btnreturn.setBounds(10, 22, 151, 76);

		JLabel lblNameTitle = new JLabel("Name");
		lblNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameTitle.setBounds(92, 189, 78, 21);

		JLabel lblAbilitiesTitle = new JLabel("Abilities");
		lblAbilitiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilitiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAbilitiesTitle.setBounds(532, 189, 78, 21);

		JLabel lblTypesTitle = new JLabel("Types");
		lblTypesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypesTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTypesTitle.setBounds(307, 189, 78, 21);

		textFieldQueryName = new JTextField();
		textFieldQueryName.setBounds(85, 220, 96, 19);
		textFieldQueryName.setColumns(10);

		textFieldQueryTypes = new JTextField();
		textFieldQueryTypes.setBounds(299, 220, 96, 19);
		textFieldQueryTypes.setColumns(10);

		textFieldQueryAbilities = new JTextField();
		textFieldQueryAbilities.setBounds(525, 220, 96, 19);
		textFieldQueryAbilities.setColumns(10);

		JButton btnSubmitFind = new JButton("Find");
		btnSubmitFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					findPanel.setVisible(false);
					pokedex = new PokedexView(Controller.getInstance().getPokemonThroughtQueryFromDB(textFieldQueryName.getText(), textFieldQueryTypes.getText(), textFieldQueryAbilities.getText()));

					pokedex.setBounds(0, 0, 729, 498);

					getLayeredPanel().removeAll();
					getLayeredPanel().add(pokedex);
					
					pokedex.setVisible(true);
					
					validate();
					repaint();
				}
				
			
		}); 
		
		btnSubmitFind.setBounds(299, 329, 85, 21);
		
		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/YgfPHRp.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);

		lblBackground.setBounds(-32, -16, 768, 501);
		
		findPanel = new JPanel();
		findPanel.setBounds(0, 0, 729, 498);
		
		findPanel.setLayout(null);
		
		
		findPanel.add(btnSubmitFind);
		findPanel.add(textFieldQueryAbilities);
		findPanel.add(textFieldQueryTypes);
		findPanel.add(textFieldQueryName);
		findPanel.add(lblTypesTitle);
		findPanel.add(lblAbilitiesTitle);
		findPanel.add(lblNameTitle);
		findPanel.add(btnreturn);
		findPanel.add(lblTitle);
		findPanel.add(lblBackground);
		

		
		
	
		getLayeredPanel().setBounds(0, 0, 729, 498);
		frame.getContentPane().add(getLayeredPanel());
		
		
		getLayeredPanel().add(findPanel);
		
		

		
		
	}
}
