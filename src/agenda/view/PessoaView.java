package agenda.view;

import agenda.controller.PessoaController;
import agenda.model.Pessoa;

import javax.swing.*;
import java.util.List;

public class PessoaView {
	private PessoaController controller = new PessoaController();

	public void menu() {
		boolean executando = true;
		while (executando) {
			String[] op1 = { "Novo Contato", "Procurar Contato", "Apagar Contato", "Voltar ao menu" };
			int escolha = JOptionPane.showOptionDialog(null, "Ações na área de pessoas", "Agenda :D",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op1, op1[0]);

			switch (escolha) {
			case 0 -> adicionarContato();
			case 1 -> buscarContato();
			case 2 -> apagarContato();
			case 3, -1 -> executando = false;
			}
		}
	}

	private void adicionarContato() {
		String nome = JOptionPane.showInputDialog("Digite o nome do novo contato.");
		String endereco = JOptionPane.showInputDialog("Digite o endereço do contato: " + nome);
		String cidade = JOptionPane.showInputDialog("Digite a cidade do contato: " + nome);
		String cep = JOptionPane.showInputDialog("Digite o CEP do contato: " + nome);

		boolean sucesso = controller.adicionarPessoa(nome, endereco, cidade, cep);

		if (sucesso) {
			JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar contato.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarContato() {
		String[] op2 = { "Nome", "Endereco", "Cidade" };
		int escolha = JOptionPane.showOptionDialog(null, "Buscar por:", "Buscar", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, op2, op2[0]);

		if (escolha == -1)
			return;
		String coluna = switch (escolha) {
		case 0 -> "Nome";
		case 1 -> "Endereco";
		case 2 -> "Cidade";
		default -> null;
		};
		if (coluna == null)
			return;

		String valorBusca = JOptionPane.showInputDialog(null, "Digite o termo para a busca no campo " + coluna);
		if (valorBusca == null)
			return;

		List<Pessoa> resultados = controller.buscarPessoa(coluna, valorBusca);

		if (resultados == null || resultados.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum contato encontrado.");
		} else {
			StringBuilder sb = new StringBuilder("Contatos encontrados:\n\n");
			for (Pessoa p : resultados) {
				sb.append("ID: ").append(p.getIdPessoa()).append("\n").append("Nome: ").append(p.getNome()).append("\n")
						.append("Endereço: ").append(p.getEndereco()).append("\n").append("Cidade: ")
						.append(p.getCidade()).append("\n").append("CEP: ").append(p.getCEP()).append("\n\n");
			}
			JOptionPane.showMessageDialog(null, sb.toString());
		}
	}

	private void apagarContato() {
		String valor = JOptionPane.showInputDialog(null, "Digite o ID do contato que deseja apagar:");
		if (valor == null)
			return;

		try {
			int id = Integer.parseInt(valor);
			boolean sucesso = controller.apagarPessoa(id);
			if (sucesso) {
				JOptionPane.showMessageDialog(null, "Contato apagado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Contato com ID " + id + " não encontrado.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
		}
	}
}