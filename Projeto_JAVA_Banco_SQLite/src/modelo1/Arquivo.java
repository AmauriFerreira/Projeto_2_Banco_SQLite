package modelo1;

public class Arquivo {
	private Integer id;
	private String nome;
	private byte arquivo;
	private String materia;
	private String assunto;
	private String email;

	public Arquivo() {}
	public Arquivo(Integer id,String nome, byte arquivo,String materia,String assunto,String email) {
		this.id = id;
		this.nome = nome;
		this.arquivo = arquivo;
		this.materia = materia;
		this.assunto = assunto;
		this.email = email;

	}


	public Integer getId() {
		return id;
	}

	
	
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
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Arquivo[id=" + id + "nome=" + nome + "arquivo=" + arquivo + "materia=" + materia +"assunto=" + assunto + ",]";
	}
}