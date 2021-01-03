package views.modals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginUnsuccessful {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUnsuccessful window = new LoginUnsuccessful();
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
	public LoginUnsuccessful() {
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

		JLabel lblMainMessage = new JLabel("Los datos introducidos no son correctos");
		lblMainMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMainMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMessage.setBounds(0, 84, 436, 63);
		frame.getContentPane().add(lblMainMessage);
	}
}
