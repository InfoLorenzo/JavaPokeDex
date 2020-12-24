package mainAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import views.Login;
import views.WelcomeWindow;

public class main {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_414700429a65082";
		String username = "b0124af284507d";
		String password = "c7610f50";
	
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			
			System.out.println("La conexi�n fue correcta");
			
			String sql = "INSERT INTO users (username,password) VALUES (?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, "test");
			statement.setString(2, "test1");

			int rows = statement.executeUpdate();
			
			if (rows > 0) {
				System.out.println("A rows has been inserted");
			}

			
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Oops algo salio mal...");
			e.printStackTrace();
		}
		
		WelcomeWindow welcomewindow = new WelcomeWindow();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Login login = new Login();
		
		
		System.out.println("Hola");
	}

}
