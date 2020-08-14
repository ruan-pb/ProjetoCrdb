package Api_Projeto_Crdb.DTO;

import Api_Projeto_Crdb.Entidades.Usuario;

public class UsuarioLoginDTO {
	private String email;
	private String senha;
	
	
	
	public UsuarioLoginDTO() {}
	
	
	
	public UsuarioLoginDTO(Usuario usuario) {
		super();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	

}
