package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Conexao {

	public Conexao() {
		// TODO Auto-generated constructor stub
	}

	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/db_postman";

	private static final String USUARIO = "root";
	private static final String SENHA = "admin@9751";

	public static Connection getConnection() {

		try {
			Class.forName(DRIVE);
			return DriverManager.getConnection(URL, USUARIO, SENHA);

		} catch (ClassNotFoundException | SQLException erroSQL) {
			throw new RuntimeException("Erro ao se Conectar no DB: " + erroSQL);
		}
	}

	public static void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException erroSQL) {
			throw new RuntimeException("Erro ao desconectar do DB: " + erroSQL);
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement pstm) {

		closeConnection(conn);
		
		try {
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException erroSQL) {
			throw new RuntimeException("Erro ao desconectar do PreparedStatement: " + erroSQL);
		}
	}
	
	public static void closeConnection(Connection conn, PreparedStatement pstm, ResultSet rs) {

		closeConnection(conn, pstm);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException erroSQL) {
			throw new RuntimeException("Erro ao desconectar do Resultset: " + erroSQL);
		}
	}
}
