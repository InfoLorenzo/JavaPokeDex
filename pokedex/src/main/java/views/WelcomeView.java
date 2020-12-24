package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import AppPackage.AnimationClass;
import controller.controller;

public class WelcomeView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public WelcomeView() {

		AnimationClass animator = new AnimationClass(); // Clase Animaciones
		
		setLayout(null); // Layout
		
		//Start -- Background
		
		JLabel lblBackground = new JLabel("No hay foto");
		
		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/YgfPHRp.png"))));
			lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblBackground.setBounds(0, 0, 718, 469);
		
		//End -- Background

		//Start -- Welcome Title

		JLabel lblWelcomeTitle = new JLabel("No hay foto");
		
		try {
			lblWelcomeTitle = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/sefSdO8.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblWelcomeTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		
		lblWelcomeTitle.setBounds(-10, 0, 718, 140);
		
		animator.jLabelYDown(lblWelcomeTitle.getY(), (lblWelcomeTitle.getY() + 60), 15, 2, lblWelcomeTitle);
		
		//End -- Welcome Title
		
		
		//Start -- Login Button
		
		ImageIcon imageForLogin = null;
		try {
			imageForLogin = new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/ieD3eRV.png")));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		final JButton btnLogin = new JButton("", imageForLogin);
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusable(false);
		btnLogin.setPreferredSize(new Dimension(78, 76));
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.setEnabled(false);
				

				System.out.println("Botón login pulsado");

			}
		});

		btnLogin.setBounds(116, 241, 158, 76);
		
		animator.jButtonYDown(btnLogin.getY(), btnLogin.getY()+40, 15, 2, btnLogin);
		
		
		//End -- Login Button
		
		
		//Start -- Register Button
		
		ImageIcon imageForRegister = null;
		try {
			imageForRegister = new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/bVt0BOa.png")));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		final JButton btnRegister = new JButton("", imageForRegister);
		btnRegister.setToolTipText("");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
				btnRegister.setEnabled(false);

				System.out.println("Botón registro pulsado");
			}
		});
		
		btnRegister.setPreferredSize(new Dimension(78, 76));
		btnRegister.setOpaque(false);
		btnRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setFocusable(false);
		btnRegister.setBounds(409, 241, 210, 76);
		

		animator.jButtonYDown(btnRegister.getY(), btnRegister.getY()+40, 15, 2, btnRegister);
		
		//End -- Register Button
		
		//Start -- Views order
		
		add(lblWelcomeTitle);
		add(btnRegister);
		add(btnLogin);
		add(lblBackground);
		
		//End -- Views order
	}
}
