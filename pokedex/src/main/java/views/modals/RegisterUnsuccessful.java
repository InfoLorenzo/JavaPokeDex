package views.modals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegisterUnsuccessful {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUnsuccessful window = new RegisterUnsuccessful();
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
	public RegisterUnsuccessful() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMainMessage = new JLabel("El usuario ya existe en la base de datos");
		lblMainMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMainMessage.setBounds(0, 20, 436, 123);
		frame.getContentPane().add(lblMainMessage);
		
		JLabel lblSolveTip = new JLabel("Introduce un usuario diferente");
		lblSolveTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolveTip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSolveTip.setBounds(0, 142, 436, 55);
		frame.getContentPane().add(lblSolveTip);
	}
}
