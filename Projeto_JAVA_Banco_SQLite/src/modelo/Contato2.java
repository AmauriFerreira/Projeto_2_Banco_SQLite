package modelo;

public class Contato2 {
	private Integer id;
	private String nome;
	private byte arquivo;

	
	public Contato2(Integer id,String nome,byte arquivo) {
		this.id = id;
		this.nome = nome;
		this.arquivo = arquivo;	
	}
	
	// metodos get e set para nome, endereco, email, login.
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public byte getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String toString() {
		return "Arquivo[id=" + id + "nome=" + nome + "arquivo=" + arquivo + ",]";
	}
}