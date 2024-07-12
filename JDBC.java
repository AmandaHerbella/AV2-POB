package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
		private static final String URL = "jdbc:mysql://localhost:3306/clientela";
		private static final String USER = "root";
		private static final String SENHA = "";
		
		public static Connection getConexao() throws SQLException {
			return DriverManager.getConnection(URL, USER, SENHA);
		}
}
