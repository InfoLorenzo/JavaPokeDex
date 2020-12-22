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
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;

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
		frame.setBounds(100, 100, 559, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		
		frame.getContentPane().add(panel, "name_410300299934100");
		panel.setLayout(null);
		/*
		JLabel lblNewLabel = new JLabel("No hay foto");
		try {
			lblNewLabel = new JLabel(new ImageIcon(ImageIO.read(new URL("https://cutewallpaper.org/21/pokemon-background-gif/Intro-GIF-Find-and-Share-on-GIPHY.gif"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lblNewLabel.setBounds(10, 10, 525, 335);
		
		*/
		 	URL url = null;
			try {
				url = new URL("https://cutewallpaper.org/21/pokemon-background-gif/Intro-GIF-Find-and-Share-on-GIPHY.gif");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Icon icon = new ImageIcon(url);
		    
		  
		    
		    final JLabel label = new JLabel(icon);
		    
		    label.setBounds(10, 10, 525, 335);
		    
		    JButton btnNewButton = new JButton("New button");
		    
		    btnNewButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		    		for (int i = 0; i < 6; i++) {
					    
				    	
						try {
							Thread.sleep(1000);
							label.setSize(label.getWidth()+50, label.getHeight()+50);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
		    		
		    	}
		    });
		    
		    btnNewButton.setBounds(229, 324, 85, 21);
		    panel.add(btnNewButton);
		    
		    panel.add(label);
	}
}
