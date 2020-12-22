package mainAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://eu-cdbr-west-03.cleardb.net/heroku_414700429a65082";
		String username = "b0124af284507d";
		String password = "c7610f50";
	
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			
			System.out.println("La conexión fue correcta");
			
			String sql = "INSERT INTO users (username,password) VALUES (?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, "lorenzo");
			statement.setString(2, "cajamar1");

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
		
		
		
		System.out.println("Hola");
	}

}
