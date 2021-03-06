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
import javax.swing.JPasswordField;

public class RegisterView extends JPanel {

	private JTextField inputUsername;
	private JTextField inputNickname;
	private RegisterUnsuccessful failedRegModal;
	private RegisterSuccessful SuccessfulRegModal;
	private JPasswordField inputPassword;

	public RegisterView() {

		setLayout(null);

		JLabel lblBackground = new JLabel("No hay foto");

		JLabel lblWelcomeTitle = new JLabel("No hay foto");

		try {
			lblWelcomeTitle = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/fcd2999524255136d6e2b4b8946166e4.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblWelcomeTitle.setVerticalAlignment(SwingConstants.BOTTOM);

		lblWelcomeTitle.setBounds(68, -58, 599, 189);

		JLabel lblNickname = new JLabel("No hay foto");

		try {
			lblNickname = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/31dc37dea2c2e4a10c0bf6c41b745b50.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblNickname.setVerticalAlignment(SwingConstants.BOTTOM);

		lblNickname.setBounds(121, 157, 221, 51);

		JLabel lblUsername = new JLabel("No hay foto");

		try {
			lblUsername = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/17b9cce38184dd4505b61ff3dbc5910d.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);

		lblUsername.setBounds(121, 219, 221, 51);

		JLabel lblPassword = new JLabel("No hay foto");

		try {
			lblPassword = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/025e83a2e5c304492381d7b481b13806.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);

		lblPassword.setBounds(121, 271, 221, 70);

		inputNickname = new JTextField();
		inputNickname.setText("");
		inputNickname.setForeground(Color.WHITE);
		inputNickname.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputNickname.setBackground(new Color(255, 205, 0));
		inputNickname.setBounds(352, 157, 221, 43);

		inputNickname.setColumns(10);

		inputUsername = new JTextField();
		inputUsername.setText("");
		inputUsername.setForeground(Color.WHITE);
		inputUsername.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputUsername.setBackground(new Color(255, 205, 0));
		inputUsername.setBounds(352, 227, 221, 43);

		inputUsername.setColumns(10);

		ImageIcon imageforRegister = null;
		try {
			imageforRegister = new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/f917d8fc9dab42ed37ffcb9400016f32.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
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

				if (!Controller.getInstance().isEmpty(inputUsername.getText())
						&& !Controller.getInstance().isEmpty(inputPassword.getText())
						&& !Controller.getInstance().isEmpty(inputNickname.getText())) {

					System.out.println("Los inputs no est�n vacios");

					if (!Controller.getInstance().checkUserExist(inputUsername.getText())) {

						Controller.getInstance().registerUser(inputNickname.getText(), inputUsername.getText(),
								inputPassword.getText());
						SuccessfulRegModal = new RegisterSuccessful();
						SuccessfulRegModal.newScreen();
					} else {

						failedRegModal = new RegisterUnsuccessful();
						failedRegModal.newScreen();

					}

				} else {
					failedRegModal = new RegisterUnsuccessful();
					failedRegModal.newScreen();
				}

				System.out.println("Bot�n Register pulsado");

			}
		});

		btnLogin.setBounds(273, 363, 173, 83);

		ImageIcon imageforReturn = null;
		try {
			imageforReturn = new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/210114/e20cc361a851b6737f42fb1a08604fe4.png")));
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
				System.out.println("Bot�n de vuelta pulsado");
				inputNickname.setText("");
				inputPassword.setText("");
				inputUsername.setText("");

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

		add(btnreturn);
		add(btnLogin);

		add(lblNickname);
		add(lblPassword);
		add(lblUsername);

		add(inputNickname);
		add(inputUsername);

		add(lblWelcomeTitle);

		inputPassword = new JPasswordField();
		inputPassword.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputPassword.setColumns(10);
		inputPassword.setBackground(new Color(255, 205, 0));
		inputPassword.setBounds(352, 298, 221, 43);
		add(inputPassword);

		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/YgfPHRp.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);

		lblBackground.setBounds(0, 0, 718, 469);
		add(lblBackground);

		setInvisible();
	}

	public void setInvisible() {
		this.setVisible(false);
	}

	public void setVisible() {
		this.setVisible(true);
	}
}
