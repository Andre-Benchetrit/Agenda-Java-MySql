package agenda.model;

import java.time.LocalDate;

public class Tarefa {
	private int idTarefa;
	private String nomeTarefa;
	private LocalDate dataEntrega;
	private Pessoa pessoa;

	public Tarefa(String nomeTarefa, LocalDate dataEntrega, Pessoa pessoa) {
		this.nomeTarefa = nomeTarefa;
		this.dataEntrega = dataEntrega;
		this.pessoa = pessoa;
	}

	public Tarefa(int idTarefa, String nomeTarefa, LocalDate dataEntrega, Pessoa pessoa) {
		this.idTarefa = idTarefa;
		this.nomeTarefa = nomeTarefa;
		this.dataEntrega = dataEntrega;
		this.pessoa = pessoa;
	}

	public int getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(int idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
