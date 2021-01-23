package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;

import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frame;

	JPanel loginview;
	JPanel registerview;
	JPanel welcomeview;
	JPanel PokedexView;
	
	static JLayeredPane layeredPane;

	public static JLayeredPane getLayeredPanel() {
		return layeredPane;
	}

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

	/**
	 * Create the application.
	 */

	public MainWindow() {
		initialize();
	
		System.out.println("Hola main window iniciada");
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 729, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		layeredPane = new JLayeredPane();

		layeredPane.setBounds(0, 0, 729, 498);

		frame.getContentPane().add(layeredPane);

		welcomeview = new WelcomeView();

		welcomeview.setBounds(0, 0, 729, 498);
		
		//welcomeview.setVisible(true);
		
		layeredPane.add(welcomeview);

		registerview = new RegisterView();

		registerview.setBounds(0, 0, 729, 498);

		layeredPane.add(registerview);

		loginview = new LoginView();

		loginview.setBounds(0, 0, 729, 498);
		
		layeredPane.add(loginview);

		PokedexView = new PokedexView();

		PokedexView.setBounds(0, 0, 729, 498);

		layeredPane.add(PokedexView);
		
		PokedexView.setVisible(true);

	}
}
