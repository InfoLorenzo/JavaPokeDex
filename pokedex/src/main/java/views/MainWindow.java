package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JLayeredPane layeredPane,JPanel panel) {
		
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	};
	
	
	/**
	 * Create the application.
	 */
	
	public MainWindow() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 724, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 710, 444); 
		
		frame.getContentPane().add(layeredPane);
		
		
		JPanel welcomeview = new WelcomeView();
		welcomeview.setBounds(0, 0, 710, 444);
		
		JPanel loginview = new LoginView();
		loginview.setBounds(0, 0, 710, 444);
		
		JPanel registerview = new RegisterView();
		registerview.setBounds(0, 0, 710, 444);
		
		layeredPane.add(welcomeview);
		layeredPane.add(loginview);
		layeredPane.add(registerview);
		
		loginview.setVisible(false);
		registerview.setVisible(false);
		
		
	}
	
	
	
}
