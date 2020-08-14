package Api_Projeto_Crdb.Entidades;



import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	private String email;
	private String nome;
	private String sobrenome;
	private String senha;

	@OneToOne(mappedBy = "usuario")
	private Comentario comentario;

	public Usuario() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isValid() {
		return !email.isBlank() && !nome.isBlank() && !senha.isBlank();
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public String toString() {
		return this.nome;
	}

}
