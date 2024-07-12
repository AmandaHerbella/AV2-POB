package CRUD;

public class Cliente {
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private String cep;
	
	public Cliente(String nome, String cpf, String email, String endereco, String cep) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setCep(cep);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
