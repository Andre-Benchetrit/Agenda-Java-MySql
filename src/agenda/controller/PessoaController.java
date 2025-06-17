package agenda.controller;

import agenda.dao.PessoaDAO;
import agenda.model.Pessoa;

import java.util.List;

public class PessoaController {

	private PessoaDAO dao = new PessoaDAO();

	public boolean adicionarPessoa(String nome, String endereco, String cidade, String cep) {
		Pessoa p = new Pessoa(nome, endereco, cidade, cep);
		return dao.salvar(p);
	}

	public List<Pessoa> buscarPessoa(String campo, String valor) {
		return dao.buscar(campo, valor);
	}

	public boolean apagarPessoa(int id) {
		return dao.apagar(id);
	}
	
	public boolean atualizarPessoa(String coluna, String valor, int idPessoa) {
	    return dao.atualizar(coluna, valor, idPessoa);
	}
}
