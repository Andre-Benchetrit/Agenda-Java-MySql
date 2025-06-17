package agenda.controller;

import java.util.List;

import agenda.dao.TarefaDAO;
import agenda.dao.PessoaDAO;
import agenda.model.Pessoa;
import agenda.model.Tarefa;

public class TarefaController {

	private TarefaDAO tarefaDAO = new TarefaDAO();
	private PessoaDAO pessoaDAO = new PessoaDAO();

	public boolean adicionarTarefa(Tarefa tarefa) {
		return tarefaDAO.salvar(tarefa);
	}

	public List<Tarefa> buscarTarefa(String campo, String valor) {
		return tarefaDAO.buscar(campo, valor);
	}

	public boolean apagarTarefa(int id) {
		return tarefaDAO.apagar(id);
	}

	public List<Pessoa> buscarNome(String campo, String valor) {
		return pessoaDAO.buscar(campo, valor);
	}
	
	public boolean atualizarTarefa(String coluna, Object valor, int idTarefa) {
	    return tarefaDAO.atualizar(coluna, valor, idTarefa);
	}
}