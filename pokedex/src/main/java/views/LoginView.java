package views;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import AppPackage.AnimationClass;
import controller.Controller;
import views.modals.LoginUnsuccessful;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginView extends JPanel {
	private JTextField inputusername;
	private JTextField inputPassword;
	private LoginUnsuccessful failedLoginModal;
	/**
	 * Create the panel.
	 */
	public LoginView() {

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
					.read(new URL("https://fontmeme.com/permalink/201224/b2c3d8668251fdfe9230d4155786026e.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblWelcomeTitle.setBounds(68, 10, 599, 133);

		// End -- Welcome Title

		// Start -- Username Label

		JLabel lblUsername = new JLabel("No hay foto");

		try {
			lblUsername = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/1bfe9337cbc33a5e36c40e856c5804d9.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblUsername.setVerticalAlignment(SwingConstants.BOTTOM);

		lblUsername.setBounds(122, 169, 221, 51);

		// End -- Username Label

		// Start -- Password Label

		JLabel lblPassword = new JLabel("No hay foto");

		try {
			lblPassword = new JLabel(new ImageIcon(ImageIO
					.read(new URL("https://fontmeme.com/permalink/201224/ac72972044190f77e1db6bc5412fdac6.png"))));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblPassword.setVerticalAlignment(SwingConstants.BOTTOM);

		lblPassword.setBounds(122, 230, 221, 70);

		// End -- Password Label

		// Start -- Username Input

		inputusername = new JTextField();
		inputusername.setText("Test1");
		inputusername.setForeground(Color.WHITE);
		inputusername.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputusername.setBackground(new Color(255, 205, 0));
		inputusername.setBounds(353, 169, 228, 51);

		inputusername.setColumns(10);

		// End -- Username Input

		// Start -- Password Input

		inputPassword = new JTextField();
		inputPassword.setText("Test1");
		inputPassword.setForeground(Color.WHITE);
		inputPassword.setFont(new Font("DejaVu Sans Condensed", Font.PLAIN, 21));
		inputPassword.setBackground(new Color(255, 205, 0));
		inputPassword.setBounds(353, 249, 228, 51);

		inputPassword.setColumns(10);

		// End -- Password Input

		// Start -- Login Button

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
				
				
				
				if (!Controller.isEmpty(inputPassword.getText()) && !Controller.isEmpty(inputusername.getText())) {
					Controller.checkUserLogin(inputusername.getText(), inputPassword.getText());
				}else {
					failedLoginModal = new LoginUnsuccessful();
					failedLoginModal.newScreen();
				}
				
				System.out.println("Botón login pulsado");

			}
		});

		btnLogin.setBounds(271, 330, 173, 83);

		// End -- Login Button

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

		add(btnLogin);
		add(btnreturn);
		add(lblPassword);
		add(lblUsername);

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
