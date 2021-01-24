package views;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import views.modals.LoginUnsuccessful;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends JPanel {

	private JTextField inputusername;
	private LoginUnsuccessful failedLoginModal;
	private JPasswordField inputPassword;

	public LoginView() {

		setLayout(null);

		JLabel lblBackground = new JLabel("No hay foto");

		JLabel lblWelcomeTitle = new JLabel("No hay foto");

		try {
			lblWelcomeTitle = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/b2c3d8668251fdfe9230d4155786026e.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblWelcomeTitle.setBounds(68, 10, 599, 133);

		JLabel lblUsername = new JLabel("No hay foto");

		try {
			lblUsername = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/1bfe9337cbc33a5e36c40e856c5804d9.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);

		lblUsername.setBounds(122, 169, 221, 51);

		JLabel lblPassword = new JLabel("No hay foto");

		try {
			lblPassword = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/ac72972044190f77e1db6bc5412fdac6.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);

		lblPassword.setBounds(122, 230, 221, 70);

		inputusername = new JTextField();
		inputusername.setForeground(Color.WHITE);
		inputusername.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputusername.setBackground(new Color(255, 205, 0));
		inputusername.setBounds(353, 169, 228, 51);

		inputusername.setColumns(10);

		ImageIcon imageForLogin = null;
		try {
			imageForLogin = new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/ieD3eRV.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		final JButton btnLogin = new JButton("", imageForLogin);
		btnLogin.setBackground(new Color(53, 106, 188));
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusable(false);
		btnLogin.setPreferredSize(new Dimension(78, 76));
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (!Controller.getInstance().isEmpty(new String(inputPassword.getPassword()))
						&& !Controller.getInstance().isEmpty(inputusername.getText())) {

					if (Controller.getInstance().checkUserLogin(inputusername.getText(),
							new String(inputPassword.getPassword()))) {

						setVisible(false);
						MainWindow.getLayeredPanel().getComponent(3).setVisible(true);
						MainWindow.getLayeredPanel().revalidate();
						MainWindow.getLayeredPanel().repaint();
					}
				} else {
					failedLoginModal = new LoginUnsuccessful();
					failedLoginModal.newScreen();
				}

				System.out.println("Botón login pulsado");

			}
		});

		btnLogin.setBounds(271, 330, 173, 83);

		ImageIcon imageforReturn = null;
		try {
			imageforReturn = new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/210114/e20cc361a851b6737f42fb1a08604fe4.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		final JButton btnreturn = new JButton("", imageforReturn);
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón de vuelta pulsado");

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

		add(btnLogin);
		add(btnreturn);
		add(lblPassword);
		add(lblUsername);
		add(inputusername);

		add(lblWelcomeTitle);

		inputPassword = new JPasswordField();
		inputPassword.setForeground(Color.WHITE);
		inputPassword.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputPassword.setBackground(new Color(255, 205, 0));
		inputPassword.setBounds(353, 249, 228, 51);
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
