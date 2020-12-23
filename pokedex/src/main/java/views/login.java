package views;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class login {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblBackground;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		
		frame.getContentPane().add(panel, "name_410300299934100");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No hay foto");
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
		
		lblBackground.setBounds(0, 0, 698, 472);
		
		/*
		 	URL url = null;
			try {
				url = new URL("https://cutewallpaper.org/21/pokemon-background-gif/Intro-GIF-Find-and-Share-on-GIPHY.gif");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Icon icon = new ImageIcon(url);
		    
		  
		    
		    final JLabel label = new JLabel(icon);
		    label.setVerticalAlignment(SwingConstants.TOP);
		    label.setHorizontalAlignment(SwingConstants.LEFT);
		    
		    label.setBounds(10, 10, 725, 735);
		    */
		
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
		    
		    
		    
		    JLabel lblWelcomeTitle = new JLabel("No hay foto");
		    
		    try {
		    	lblWelcomeTitle = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/sefSdO8.png"))));
		    	lblWelcomeTitle.setVerticalAlignment(SwingConstants.BOTTOM);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
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
		    
		    JButton btnRegister = new JButton("", imageForRegister);
		    btnRegister.setToolTipText("");
		    btnRegister.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
					System.out.println("Botón registro pulsado");
		    	}
		    });
		    btnRegister.setPreferredSize(new Dimension(78, 76));
		    btnRegister.setOpaque(false);
		    btnRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		    btnRegister.setContentAreaFilled(false);
		    btnRegister.setBorderPainted(false);
		    btnRegister.setFocusable(false);
		    btnRegister.setBounds(370, 253, 210, 76);
		    panel.add(btnRegister);
		    
		    
		    JButton btnLogin = new JButton("",imageForLogin);
		    btnLogin.setOpaque(false);
		    btnLogin.setContentAreaFilled(false);
		    btnLogin.setBorderPainted(false);
		    btnLogin.setFocusable(false);
		    btnLogin.setPreferredSize( new Dimension(78, 76));
		    btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		    btnLogin.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
					System.out.println("Botón login pulsado");

		    		
		    	}
		    });
		    
		    btnLogin.setBounds(132, 253, 158, 76);
		    panel.add(btnLogin);
		    
		    lblWelcomeTitle.setBounds(0, 40, 698, 140);
		    panel.add(lblWelcomeTitle);
		    
		   
			
			
		    
		    panel.add(lblBackground);
	}
}
