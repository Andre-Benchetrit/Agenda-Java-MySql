package agenda.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agenda.model.Pessoa;

public class PessoaDAO {

	public boolean salvar(Pessoa pessoa) {

		/*
		 * Isso é um sql comum, onde os ? são os paramentros na base de dados
		 */

		String sql = "INSERT INTO `pessoa`(`Nome`, `Endereco`, `Cidade`, `CEP`)" + " VALUES (?, ?, ?, ?)";

		try (Connection conn = Conexao.createConnectionToMySQL(); PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getEndereco());
			pstm.setString(3, pessoa.getCidade());
			pstm.setString(4, pessoa.getCEP());

			int rowsAffected = pstm.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Pessoa> buscar(String coluna, String termo) {
		List<Pessoa> lista = new ArrayList<>();

		String sql = "SELECT * FROM pessoa WHERE " + coluna + " LIKE ?";

		try (Connection conn = Conexao.createConnectionToMySQL(); PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setString(1, "%" + termo + "%");

			try (ResultSet rs = pstm.executeQuery()) {
				while (rs.next()) {
					int idPessoa = rs.getInt("idPessoa");
					String nome = rs.getString("Nome");
					String endereco = rs.getString("Endereco");
					String cidade = rs.getString("Cidade");
					String cep = rs.getString("CEP");

					Pessoa pessoa = new Pessoa(idPessoa, nome, endereco, cidade, cep);
					lista.add(pessoa);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public boolean apagar(int termo) {

		String sql = "DELETE FROM pessoa WHERE idPessoa = ?";

		try (Connection conn = Conexao.createConnectionToMySQL(); PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setInt(1, termo);
			int rowsAffected = pstm.executeUpdate(); // Cria uma variavel para capturar com o pstm quantas linhas
														// mudaram.
			return rowsAffected > 0; // Retorna true se conseguir apagar (se linhas foram mudadas).
		} catch (Exception e) {
			e.printStackTrace();
			return false; // Se não conseguir apagar, retorna falso
		}
	}
}
