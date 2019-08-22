package modelo1;
public class Usuario {
	private String nome;
	private String endereco;
	private String email;
	private String senha;

	
	public Usuario() {}
	public Usuario(String nome,String endereco,String email, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		
	
	}
	
	// metodos get e set para nome, endereco, email, login.
	
	public String getNome() {
		return this. nome;
	}
	public void setNome(String novo) {
		this.nome = novo;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String novo) {
		this.endereco = novo;
	}
	
	public String getEmail() {
		return this. email;
	}
	public void setEmail(String novo) {
		this. email = novo;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String novo) {
		this.senha = novo;

	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "enedreco=" + endereco + "email=" + email + ", senha=" + senha + ",]";
	}
}