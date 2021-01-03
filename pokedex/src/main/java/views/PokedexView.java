package views;

import javax.swing.JPanel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PokedexView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PokedexView() {

		setLayout(null);

		// Start -- Background

		JLabel lblBackground = new JLabel("No hay foto");

		try {
			lblBackground = new JLabel(new ImageIcon(ImageIO.read(new URL("https://i.imgur.com/Lr4arcd.png"))));
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

		
		add(lblBackground);

	}
}
