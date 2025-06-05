package agenda;

import agenda.view.PessoaView;
import agenda.view.TarefaView;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		boolean executando = true;
		PessoaView pessoaView = new PessoaView();
		TarefaView tarefaView = new TarefaView();

		JOptionPane.showMessageDialog(null, "Iniciando a sua agenda!", "Agenda :D", JOptionPane.INFORMATION_MESSAGE);

		while (executando) {
			String[] opcoes = { "Contatos", "Tarefas", "Sair" };
			int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Agenda :D",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

			switch (escolha) {
			case 0 -> pessoaView.menu();
			case 1 -> tarefaView.menu();
			case 2, -1 -> executando = false;
			}
		}
	}
}
