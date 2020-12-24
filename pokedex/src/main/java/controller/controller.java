package controller;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import views.MainWindow;

public class controller {
	

	
	public controller() {

	}
	
	public static void switchPanels(JLayeredPane layeredPane,JPanel panel) {
		
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
