package agenda.model;

public class Pessoa {
	private int idPessoa;
	private String nome;
	private String endereco;
	private String cidade;
	private String CEP;

	public Pessoa(String nome, String endereco, String cidade, String CEP) {
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.CEP = CEP;

	}

	public Pessoa(int idPessoa, String nome, String endereco, String cidade, String cep) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.CEP = cep;
	}

	public Pessoa() {

	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

}
