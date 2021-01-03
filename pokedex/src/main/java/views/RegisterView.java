package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import AppPackage.AnimationClass;
import controller.Controller;
import views.modals.RegisterSuccessful;
import views.modals.RegisterUnsuccessful;

public class RegisterView extends JPanel {

	private JTextField inputusername;
	private JTextField inputPassword;
	private JTextField inputNickname;
	private JButton btnreturn;
	private RegisterUnsuccessful failedRegModal;
	private RegisterSuccessful SuccessfulRegModal;

	/**
	 * Create the panel.
	 */
	public RegisterView() {

		AnimationClass animator = new AnimationClass(); // Clase Animaciones

		setLayout(null); // Layout

		// Start -- Background

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
		// End -- Background

		// Start -- Welcome Title

		JLabel lblWelcomeTitle = new JLabel("No hay foto");

		try {
			lblWelcomeTitle = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/fcd2999524255136d6e2b4b8946166e4.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblWelcomeTitle.setVerticalAlignment(SwingConstants.BOTTOM);

		lblWelcomeTitle.setBounds(68, -58, 599, 189);

		// End -- Welcome Title

		// Start -- Nickname Label

		JLabel lblNickname = new JLabel("No hay foto");

		try {
			lblNickname = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/31dc37dea2c2e4a10c0bf6c41b745b50.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblNickname.setVerticalAlignment(SwingConstants.BOTTOM);

		lblNickname.setBounds(121, 157, 221, 51);

		// End -- Nickname Label

		// Start -- Username Label

		JLabel lblUsername = new JLabel("No hay foto");

		try {
			lblUsername = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/17b9cce38184dd4505b61ff3dbc5910d.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);

		lblUsername.setBounds(121, 219, 221, 51);

		// End -- Username Label

		// Start -- Password Label

		JLabel lblPassword = new JLabel("No hay foto");

		try {
			lblPassword = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/025e83a2e5c304492381d7b481b13806.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);

		lblPassword.setBounds(121, 271, 221, 70);

		// End -- Password Label

		// Start -- Nickname Input

		inputNickname = new JTextField();
		inputNickname.setText("");
		inputNickname.setForeground(Color.WHITE);
		inputNickname.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputNickname.setBackground(new Color(255, 205, 0));
		inputNickname.setBounds(352, 157, 221, 43);

		inputNickname.setColumns(10);

		// End -- Nickname Input

		// Start -- Username Input

		inputusername = new JTextField();
		inputusername.setText("");
		inputusername.setForeground(Color.WHITE);
		inputusername.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputusername.setBackground(new Color(255, 205, 0));
		inputusername.setBounds(352, 227, 221, 43);

		inputusername.setColumns(10);

		// End -- Username Input

		// Start -- Password Input

		inputPassword = new JTextField();
		inputPassword.setText("");
		inputPassword.setForeground(Color.WHITE);
		inputPassword.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputPassword.setBackground(new Color(255, 205, 0));
		inputPassword.setBounds(352, 298, 221, 43);

		inputPassword.setColumns(10);

		// End -- Password Input

		ImageIcon imageforRegister = null;
		try {
			imageforRegister = new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/f917d8fc9dab42ed37ffcb9400016f32.png")));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		final JButton btnLogin = new JButton("", imageforRegister);
		btnLogin.setBackground(new Color(53, 106, 188));
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusable(false);
		btnLogin.setPreferredSize(new Dimension(78, 76));
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!Controller.isEmpty(inputusername.getText()) && !Controller.isEmpty(inputPassword.getText())
						&& !Controller.isEmpty(inputNickname.getText())) {

					System.out.println("Los inputs no están vacios");

					if (!Controller.checkUserExist(inputusername.getText())) {

						Controller.registerUser(inputNickname.getText(), inputusername.getText(),
								inputPassword.getText());
						SuccessfulRegModal = new RegisterSuccessful();
						SuccessfulRegModal.newScreen();
					}else {
						
						failedRegModal = new RegisterUnsuccessful();
						failedRegModal.newScreen();
						
					}

				}else {
					failedRegModal = new RegisterUnsuccessful();
					failedRegModal.newScreen();
				}

				System.out.println("Botón Register pulsado");

				// btnLogin.setEnabled(false);

			}
		});

		btnLogin.setBounds(273, 363, 173, 83);

		// Start -- Return Button

		ImageIcon imageforReturn = null;
		try {
			imageforReturn = new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/210102/938402012117d7cf010c59421d232540.png")));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		final JButton btnreturn = new JButton("", imageforReturn);
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón de vuelta pulsado");
				inputNickname.setText("");
				inputPassword.setText("");
				inputusername.setText("");

				setInvisible();
				MainWindow.getLayeredPanel().getComponent(0).setVisible(true);
				MainWindow.getLayeredPanel().revalidate();
				MainWindow.getLayeredPanel().repaint();

			}
		});
		btnreturn.setPreferredSize(new Dimension(78, 76));
		btnreturn.setOpaque(false);
		btnreturn.setHorizontalTextPosition(SwingConstants.CENTER);
		btnreturn.setFocusable(false);
		btnreturn.setContentAreaFilled(false);
		btnreturn.setBorderPainted(false);
		btnreturn.setBackground(new Color(53, 106, 188));
		btnreturn.setBounds(10, 10, 151, 76);

		// End -- Return Button

		// Start -- Views order

		add(btnreturn);
		add(btnLogin);

		add(lblNickname);
		add(lblPassword);
		add(lblUsername);

		add(inputNickname);
		add(inputPassword);
		add(inputusername);

		add(lblWelcomeTitle);
		add(lblBackground);

		// End -- Views order

		setInvisible();
	}

	public void setInvisible() {
		this.setVisible(false);
	}

	public void setVisible() {
		this.setVisible(true);
	}

}
