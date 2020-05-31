package aula08;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String database = "pais";
	private static final String username = "root";
	private static final String password = "1234";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?useTimezone=true&serverTimezone=UTC&user=" + username + "&password=" + password);
	}
}
