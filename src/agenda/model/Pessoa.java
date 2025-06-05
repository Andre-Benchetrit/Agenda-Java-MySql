package agenda.model;

public class Pessoa {
	private int idPessoa;
	private String Nome;
	private String Endereco;
	private String Cidade;
	private String CEP;

	// Cadastro manual
	public Pessoa(String nome, String endereco, String cidade, String CEP) {
		this.Nome = nome;
		this.Endereco = endereco;
		this.Cidade = cidade;
		this.CEP = CEP;

	}

	// Para busca
	public Pessoa(int idPessoa, String nome, String endereco, String cidade, String cep) {
		this.idPessoa = idPessoa;
		this.Nome = nome;
		this.Endereco = endereco;
		this.Cidade = cidade;
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
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

}
