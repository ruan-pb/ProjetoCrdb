package Api_Projeto_Crdb.DTO;

import Api_Projeto_Crdb.Entidades.Disciplina;

public class DisciplinaIdNome {
	
	
	private int id;
	private String nome;
	public DisciplinaIdNome(Disciplina disciplina) {
		super();
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
