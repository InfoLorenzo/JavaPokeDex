package views;

import java.awt.Dimension;
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
import javax.swing.SwingConstants;

public class WelcomeView extends JPanel {

	public WelcomeView() {

		setLayout(null);

		JLabel lblBackground = new JLabel("No hay foto");

		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/YgfPHRp.png"))));
			lblBackground.setVerticalAlignment(SwingConstants.BOTTOM);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblBackground.setBounds(0, 0, 718, 469);

		JLabel lblWelcomeTitle = new JLabel("No hay foto");

		try {
			lblWelcomeTitle = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/sefSdO8.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		lblWelcomeTitle.setVerticalAlignment(SwingConstants.BOTTOM);

		lblWelcomeTitle.setBounds(-10, 0, 718, 140);

		ImageIcon imageForLogin = null;
		try {
			imageForLogin = new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/ieD3eRV.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		final JButton btnLogin = new JButton("", imageForLogin);
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusable(false);
		btnLogin.setPreferredSize(new Dimension(78, 76));
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainWindow.getLayeredPanel().getComponent(0).setVisible(false);
				MainWindow.getLayeredPanel().getComponent(2).setVisible(true);
				MainWindow.getLayeredPanel().revalidate();
				MainWindow.getLayeredPanel().repaint();

				System.out.println("Botón de login pulsado");
			}
		});

		btnLogin.setBounds(116, 241, 158, 76);

		ImageIcon imageForRegister = null;
		try {
			imageForRegister = new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/bVt0BOa.png")));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		final JButton btnRegister = new JButton("", imageForRegister);
		btnRegister.setToolTipText("");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainWindow.getLayeredPanel().getComponent(0).setVisible(false);
				MainWindow.getLayeredPanel().getComponent(1).setVisible(true);
				MainWindow.getLayeredPanel().revalidate();
				MainWindow.getLayeredPanel().repaint();

				System.out.println("Botón de register pulsado");
			}
		});

		btnRegister.setPreferredSize(new Dimension(78, 76));
		btnRegister.setOpaque(false);
		btnRegister.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setFocusable(false);
		btnRegister.setBounds(409, 241, 210, 76);

		add(lblWelcomeTitle);
		add(btnRegister);
		add(btnLogin);
		add(lblBackground);

		MainWindow.getLayeredPanel().revalidate();

		MainWindow.getLayeredPanel().repaint();
		setInvisible();

	}

	public void setInvisible() {
		this.setVisible(false);
	}

	public void setVisible() {
		this.setVisible(true);
	}
}
