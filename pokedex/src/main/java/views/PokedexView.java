package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PokedexView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PokedexView() {
		setLayout(null);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setBounds(0, 0, 718, 469);
		add(lblBackground);

	}
}
