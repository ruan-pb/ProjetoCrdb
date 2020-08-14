package Api_Projeto_Crdb.Entidades;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String comentario;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;

	@JsonFormat(pattern = "HH:mm:ss")
	private Time hora;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "comentario_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "comentario_disciplina")
	private Disciplina disciplina;

	public Comentario() {
	}

	public Comentario(Long id, String comentario) {
		super();
		this.id = id;
		this.comentario = "comentarios";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.usuario.getNome());
		sb.append(this.data);
		sb.append(this.hora);
		return sb.toString();
	}

}
