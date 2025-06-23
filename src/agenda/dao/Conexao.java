package agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USERNAME = "root";

	// Senha do MYSQL
	private static final String PASSWORD = "root";

	// Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	private static final String DATABESE_URL = "jdbc:mysql://localhost:3306/agenda";

	/**
	 * Cria uma conexão com o banco de dados MYSQL utilizando o nome de usuário e a
	 * senha fornecida.
	 * 
	 * @param username
	 * @param senha
	 * @return uma conexão com o banco de dados
	 * @throws Exception
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABESE_URL, USERNAME, PASSWORD);

		return connection;
	}

}
