package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String DATABASE = "localhost:3306/webAerodrom";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static Connection connection;

	public static void open() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + DATABASE + "?useSSL=false", USERNAME, PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {

		return connection;
	}

	public static void close() {

		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
