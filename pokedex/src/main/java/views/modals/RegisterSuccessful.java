package views.modals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RegisterSuccessful {

	private JFrame frame;

	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterSuccessful window = new RegisterSuccessful();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegisterSuccessful() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMainMessage = new JLabel("El usuario ha sido introducido en la base de datos");
		lblMainMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMainMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMessage.setBounds(0, 84, 436, 88);
		frame.getContentPane().add(lblMainMessage);
	}

}
