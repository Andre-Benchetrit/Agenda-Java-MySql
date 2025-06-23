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
			String[] op1 = { "Novo Contato", "Procurar Contato", "Apagar Contato", "Atualizar Contato", "Voltar ao menu" };
			int escolha = JOptionPane.showOptionDialog(null, "Ações na área de pessoas", "Agenda :D",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op1, op1[0]);

			switch (escolha) {
			case 0 -> adicionarContato();
			case 1 -> buscarContato();
			case 2 -> apagarContato();
			case 3 -> atualizarContato();
			case 4, -1 -> executando = false;
			}
		}
	}

	private void adicionarContato() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do novo contato.");
		if (nome == null)
			return;
		else if (nome.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
	        return;
	    }
		String endereco = JOptionPane.showInputDialog(null, "Digite o endereço do contato: " + nome);
		if (endereco == null)
			return;
		else if (endereco.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Endereço não pode ser vazio.");
	        return;
	    }
		String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do contato: " + nome);
		if (cidade == null)
			return;
		else if (cidade.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Cidade não pode ser vazio.");
	        return;
		}
		String cep = JOptionPane.showInputDialog(null, "Digite o CEP do contato: " + nome);
		if (cep == null)
			return;
		else if (cep.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "CEP não pode ser vazio.");
	        return;
		}

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
		case 0 -> "nome";
		case 1 -> "endereco";
		case 2 -> "cidade";
		default -> null;
		};
		if (coluna == null) {
			return;
		}

		String valorBusca = JOptionPane.showInputDialog(null, "Digite o termo para a busca no campo " + coluna);
		if (valorBusca == null)
			return;
		else if (valorBusca.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Termo de busca não pode ser vazio.");
	        return;
		}

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
	    String idStr = JOptionPane.showInputDialog("Digite o ID da pessoa que deseja excluir:");
	    
	    if (idStr == null) {
	    	return;
	    }
	    
	    else if (idStr.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "ID não pode ser vazio.");
	        return;
	    }

	    try {
	    	String confirmacao = JOptionPane.showInputDialog("Tem certeza que deseja apagar o contato? Digite SIM para confirmar.");

	    	if (confirmacao == null){
    	    	JOptionPane.showMessageDialog(null, "Ação cancelada pelo usuário.");
    	    	return;
    	    }
	    	String input = confirmacao.trim().toLowerCase();

	    	if (input.equals("fish")) {
	    	    controller.easterEgg();
	    	    return;
	    	}

	    	if (!input.equals("sim")) {
	    	    JOptionPane.showMessageDialog(null, "É necessário confirmação com SIM para prosseguir.");
	    	    return;
	    	}
	    	    	
	    	    
	        int id = Integer.parseInt(idStr);
	        boolean sucesso = controller.apagarPessoa(id);

	        if (sucesso) {
	            JOptionPane.showMessageDialog(null, "Contato apagado com sucesso!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Contato com ID " + id + " não encontrado.");
	        }

	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null,
	            "Erro ao apagar contato: " + e.getMessage(),
	            "Erro",
	            JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void atualizarContato() {
	    String idStr = JOptionPane.showInputDialog("Digite o ID do contato que deseja atualizar:");
	    if (idStr == null) {
	        return;
	    } else if (idStr.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "ID não pode ser vazio.");}

	    String[] op2 = { "Nome", "Endereco", "Cidade", "CEP" };
	    int escolha = JOptionPane.showOptionDialog(null, "Atualizar o campo:", "Buscar",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, op2, op2[0]);

	    if (escolha == -1) return;

	    String coluna;
	    String valor;

	    switch (escolha) {
	        case 0 -> {
	            coluna = "nome";
	            valor = JOptionPane.showInputDialog("Digite o novo nome:");
	            if (valor == null) {
	    	        return;
	    	    } else if (valor.trim().isEmpty()) {
	    	        JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
	    	        return;
	    	        }
	            }
	        case 1 -> {
	            coluna = "endereco";
	            valor = JOptionPane.showInputDialog("Digite o novo nome:");
	            if (valor == null) {
	    	        return;
	    	    } else if (valor.trim().isEmpty()) {
	    	        JOptionPane.showMessageDialog(null, "Endereço não pode ser vazio.");
	    	        return;
	    	        }
	            }
	        case 2 -> {
	            coluna = "cidade";
	            valor = JOptionPane.showInputDialog("Digite a nova cidade:");
	            if (valor == null) {
	    	        return;
	    	    } else if (valor.trim().isEmpty()) {
	    	        JOptionPane.showMessageDialog(null, "Cidade não pode ser vazio.");
	    	        return;
	    	        }
	        }
	        case 3 -> {
	            coluna = "CEP";
	            valor = JOptionPane.showInputDialog("Digite o novo CEP:");
	            if (valor == null) {
	    	        return;
	    	    } else if (valor.trim().isEmpty()) {
	    	        JOptionPane.showMessageDialog(null, "CEP não pode ser vazio.");
	    	        return;
	    	        }
	        }
	        default -> {
	            JOptionPane.showMessageDialog(null, "Opção inválida.");
	            return;
	        }
	    }
	        
	        try {
	        	String confirmacao = JOptionPane.showInputDialog("Tem certeza que deseja alterar o contato? Digite SIM para confirmar.");

		    	if (confirmacao == null){
	    	    	JOptionPane.showMessageDialog(null, "Ação cancelada pelo usuário.");
	    	    	return;
	    	    }
		    	else if (!confirmacao.trim().toLowerCase().equals("sim")) {
		    	    JOptionPane.showMessageDialog(null, "É necessário confirmação com SIM para prosseguir.");
		    	    return;
		    	}
		        int idPessoa = Integer.parseInt(idStr);
		        boolean sucesso = controller.atualizarPessoa(coluna, valor, idPessoa);
		        if (sucesso) {
		            JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Erro ao atualizar pessoa.");
		        }
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "ID da pessoa inválido!");
		    }
	    }
	}
