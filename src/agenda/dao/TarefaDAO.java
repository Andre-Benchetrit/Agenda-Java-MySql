package agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import agenda.model.Pessoa;
import agenda.model.Tarefa;

public class TarefaDAO {

	public boolean salvar(Tarefa tarefa) {

		String sql = "INSERT INTO `tarefa` (`nomeTarefa`, `dataEntrega`, `Pessoa_idPessoa`)" + " VALUES (?, ?, ?)";

		try (Connection conn = Conexao.createConnectionToMySQL(); PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setString(1, tarefa.getNomeTarefa());

			java.sql.Date sqlDate = java.sql.Date.valueOf(tarefa.getDataEntrega());

			pstm.setDate(2, sqlDate);

			pstm.setInt(3, tarefa.getPessoa().getIdPessoa());

			int rowsAffected = pstm.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Tarefa> buscar(String coluna, String termo) {
		List<Tarefa> lista = new ArrayList<>();

		String sql = "SELECT t.idTarefa, t.nomeTarefa, t.dataEntrega, p.idPessoa, p.Nome "
				+ "FROM tarefa t JOIN pessoa p ON t.Pessoa_idPessoa = p.idPessoa " + "WHERE " + coluna + " LIKE ?";

		try (Connection conn = Conexao.createConnectionToMySQL(); PreparedStatement pstm = conn.prepareStatement(sql)) {

			pstm.setString(1, "%" + termo + "%");

			try (ResultSet rs = pstm.executeQuery()) {
				while (rs.next()) {
					int idTarefa = rs.getInt("idTarefa");
					String nomeTarefa = rs.getString("nomeTarefa");
					LocalDate dataEntrega = rs.getDate("dataEntrega").toLocalDate();

					int idPessoa = rs.getInt("idPessoa");
					String nomePessoa = rs.getString("Nome");

					Pessoa pessoa = new Pessoa();
					pessoa.setIdPessoa(idPessoa);
					pessoa.setNome(nomePessoa);

					Tarefa tarefa = new Tarefa(idTarefa, nomeTarefa, dataEntrega, pessoa);
					lista.add(tarefa);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public boolean apagar(int termo) {

		String sql = "DELETE FROM tarefa WHERE idTarefa = ?";

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
