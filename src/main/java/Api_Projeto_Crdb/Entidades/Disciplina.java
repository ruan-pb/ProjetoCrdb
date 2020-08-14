package Api_Projeto_Crdb.Entidades;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private double nota;
	private int likes;


	@JsonIgnore
	@OneToMany(mappedBy = "disciplina")
	List<Comentario> comentario;

	

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "disciplina_Usuario", joinColumns = @JoinColumn(name = "disciplina_Id"), inverseJoinColumns = @JoinColumn(name = "usuario_Email"))
	private List<Usuario> usuario;

	public Disciplina() {
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
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

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void AdicionarUsuario(Usuario usuario) {
		this.usuario.add(usuario);
	}

	public int getLikes() {
		return likes;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void adicionarComentario(Comentario c) {
		this.comentario.add(c);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(String.format("%.2f", this.nota));
		sb.append(this.likes);
		for (Comentario c : this.comentario) {
			sb.append(c.getComentario());
		}
		return sb.toString();
	}

}
