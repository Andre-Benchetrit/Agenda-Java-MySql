package agenda.view;

import agenda.controller.TarefaController;
import agenda.controller.PessoaController;
import agenda.model.Pessoa;
import agenda.model.Tarefa;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.*;
import java.util.List;

public class TarefaView {

	private TarefaController tarefaController = new TarefaController();
	private PessoaController pessoaController = new PessoaController();

	public void menu() {
		boolean executando = true;
		while (executando) {
			String[] op1 = { "Nova Tarefa", "Procurar Tarefa", "Apagar Tarefa", "Atualizar Tarefa", "Voltar ao menu" };
			int escolha = JOptionPane.showOptionDialog(null, "Ações na área de tarefas", "Agenda :D",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op1, op1[0]);

			switch (escolha) {
			case 0 -> adicionarTarefa();
			case 1 -> listarTarefa();
			case 2 -> excluirTarefa();
			case 3 -> atualizarTarefa();
			case 4, -1 -> executando = false;
			}
		}
	}

	private void adicionarTarefa() {
		String nomeTarefa = JOptionPane.showInputDialog("Qual é a nova tarefa?");
		if (nomeTarefa == null)
			return;
		else if (nomeTarefa.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Nome da tarefa não pode ser vazio.");
	        return;
		}

		LocalDate dataEntrega;
		String input = JOptionPane.showInputDialog("Para quando a nova tarefa deverá ser feita? (Formato yyyy-MM-dd)");
		try {
			dataEntrega = LocalDate.parse(input);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Data inválida! Use o formato yyyy-MM-dd.");
			return;
		}

		Pessoa pessoaEscolhida;
		String nomePessoa = JOptionPane.showInputDialog("Digite o nome do encarregado da tarefa:");
		List<Pessoa> pessoas = pessoaController.buscarPessoa("Nome", nomePessoa);

		if (pessoas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
			return;
		}

		if (pessoas.size() == 1) {
			pessoaEscolhida = pessoas.get(0);
		} else {
			String[] nomes = pessoas.stream().map(p -> p.getIdPessoa() + " - " + p.getNome()).toArray(String[]::new);

			String escolha = (String) JOptionPane.showInputDialog(null, "Mais de uma pessoa encontrada. Escolha:",
					"Selecionar Pessoa", JOptionPane.PLAIN_MESSAGE, null, nomes, nomes[0]);

			if (escolha == null) {
				JOptionPane.showMessageDialog(null, "Nenhuma pessoa selecionada.");
				return;
			}

			int idEscolhido = Integer.parseInt(escolha.split(" - ")[0]);
			pessoaEscolhida = pessoas.stream().filter(p -> p.getIdPessoa() == idEscolhido).findFirst().orElse(null);

			if (pessoaEscolhida == null) {
				JOptionPane.showMessageDialog(null, "Erro ao selecionar a pessoa.");
				return;
			}
		}

		Tarefa tarefa = new Tarefa(nomeTarefa, dataEntrega, pessoaEscolhida);

		boolean sucesso = tarefaController.adicionarTarefa(tarefa);

		if (sucesso) {
			JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void listarTarefa() {
		String[] opcoes = { "Nome da Tarefa", "Data de Entrega", "Nome do Encarregado" };
		int escolha = JOptionPane.showOptionDialog(null, "Escolha o critério de busca:", "Buscar Tarefa",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

		if (escolha == JOptionPane.CLOSED_OPTION)
			return;

		String campo;
		String termo = null;

		switch (escolha) {
		case 0:
			campo = "nomeTarefa";
			termo = JOptionPane.showInputDialog("Digite o nome da tarefa:");
			break;
		case 1:
			campo = "dataEntrega";
			termo = JOptionPane.showInputDialog("Digite a data de entrega (yyyy-mm-dd):");
			break;
		case 2:
			campo = "p.Nome";
			termo = JOptionPane.showInputDialog("Digite o nome do encarregado:");
			break;
		default:
			return;
		}

		if (termo == null)
			return;
		else if (termo.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Termo de busca não pode ser vazio.");
	        return;
		}

		List<Tarefa> tarefas = tarefaController.buscarTarefa(campo, termo);

		if (tarefas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma tarefa encontrada.");
		} else {
			StringBuilder sb = new StringBuilder("Tarefas encontradas:\n\n");
			for (Tarefa t : tarefas) {
				sb.append("ID: ").append(t.getIdTarefa()).append("\n").append("Tarefa: ").append(t.getNomeTarefa())
						.append("\n").append("Entrega: ").append(t.getDataEntrega()).append("\n").append("Pessoa: ")
						.append(t.getPessoa().getNome()).append("\n\n");
			}
			JOptionPane.showMessageDialog(null, sb.toString());
		}
	}

	private void excluirTarefa() {
		String idStr = JOptionPane.showInputDialog("Digite o ID da tarefa que deseja excluir:");
		if (idStr == null)
			return;
		else if (idStr.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "O ID não pode ser vazio.");
	        return;
		}

		try {
			String confirmacao = JOptionPane.showInputDialog("Tem certeza que deseja apagar a tarefa? Digite SIM para confirmar.");

	    	if (confirmacao == null){
    	    	JOptionPane.showMessageDialog(null, "Ação cancelada pelo usuário.");
    	    	return;
    	    }
	    	else if (!confirmacao.trim().toLowerCase().equals("sim")) {
	    	    JOptionPane.showMessageDialog(null, "É necessário confirmação com SIM para prosseguir.");
	    	    return;
	    	}
	    	
			int idTarefa = Integer.parseInt(idStr);
			boolean sucesso = tarefaController.apagarTarefa(idTarefa);
			if (sucesso) {
				JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "Tarefa não encontrada.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID inválido.");
		}
	}

	private void atualizarTarefa() {
	    String idStr = JOptionPane.showInputDialog("Digite o ID da tarefa que deseja atualizar:");
	    if (idStr == null)
			return;
		else if (idStr.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "ID da tarefa não pode ser vazio.");
	        return;
	    }

	    String[] op2 = { "Nome", "Data", "Pessoa" };
	    int escolha = JOptionPane.showOptionDialog(null, "Atualizar o campo:", "Buscar",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op2, op2[0]);

	    if (escolha == -1) return;

	    String coluna;
	    Object novoValorTratado;

	    switch (escolha) {
	        case 0 -> {
	            coluna = "nomeTarefa";
	            String valor = JOptionPane.showInputDialog("Digite o novo nome:");
	            if (valor == null || valor.trim().isEmpty()) return;
	            novoValorTratado = valor;
	        }
	        case 1 -> {
	            coluna = "dataEntrega";
	            String valor = JOptionPane.showInputDialog("Digite a nova data (AAAA-MM-DD):");
	            if (valor == null || valor.trim().isEmpty()) return;
	            try {
	                LocalDate data = LocalDate.parse(valor);
	                novoValorTratado = Date.valueOf(data);
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, "Data inválida!");
	                return;
	            }
	        }
	        case 2 -> {
	            coluna = "Pessoa_idPessoa";
	            String valor = JOptionPane.showInputDialog("Digite o novo ID da pessoa:");
	            if (valor == null || valor.trim().isEmpty()) return;
	            try {
	                novoValorTratado = Integer.parseInt(valor);
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(null, "ID inválido!");
	                return;
	            }
	        }
	        default -> {
	            JOptionPane.showMessageDialog(null, "Opção inválida.");
	            return;
	        }
	    }

	    try {
	    	
	    	String confirmacao = JOptionPane.showInputDialog("Tem certeza que deseja alterar a tarefa? Digite SIM para confirmar.");

	    	if (confirmacao == null){
    	    	JOptionPane.showMessageDialog(null, "Ação cancelada pelo usuário.");
    	    	return;
    	    }
	    	else if (!confirmacao.trim().toLowerCase().equals("sim")) {
	    	    JOptionPane.showMessageDialog(null, "É necessário confirmação com SIM para prosseguir.");
	    	    return;
	    	}
	    	
	        int idTarefa = Integer.parseInt(idStr);
	        boolean sucesso = tarefaController.atualizarTarefa(coluna, novoValorTratado, idTarefa);
	        if (sucesso) {
	            JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Tarefa não encontrada.");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "ID da tarefa inválido!");
	    }
	}
}
