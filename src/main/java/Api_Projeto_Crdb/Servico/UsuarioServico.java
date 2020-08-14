package Api_Projeto_Crdb.Servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api_Projeto_Crdb.DTO.UsuarioDTO;
import Api_Projeto_Crdb.Entidades.Usuario;
import Api_Projeto_Crdb.Excecoes.UsuarioInvalido;
import Api_Projeto_Crdb.Excecoes.UsuarioJaExiste;
import Api_Projeto_Crdb.Repositorio.UsuarioRepositorio;


@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio<Usuario, String> usuarioBD;
	
	private JWTServico jwtServico;
	
	
	public UsuarioDTO criarUsuario(Usuario usuario) {
		if(!usuario.isValid()) {
			throw new UsuarioInvalido();
			
		}
		if(usuarioBD.existsById(usuario.getEmail())) {
			throw new UsuarioJaExiste();
		}
		usuarioBD.save(usuario);
		return new UsuarioDTO(usuario);
		
	}
	public UsuarioDTO deletaUsuario(String cabecalho) {
		//vai ler o token e recuperar o subject
		Optional<String> usuarioId = jwtServico.recuperarUsuario(cabecalho);
		
		//vai pegar o subject do token e ver se existe um usuário correspondente
		Usuario usuario = validarUsuario(usuarioId);
		
		//vai remover o usuario associado ao token
		usuarioBD.delete(usuario);
		return new UsuarioDTO(usuario);
	}
	public Usuario validarUsuario(Optional<String> id) {
		if(id.isEmpty()) {
			throw new UsuarioInvalido();
		}
		Optional<Usuario> usuario = usuarioBD.findByEmail(id.get());
		if(usuario.isEmpty()) {
			throw new UsuarioInvalido();
		}
		return usuario.get();
		
	}
	public Usuario getUsuario(String email) {
		Optional<Usuario> usuarioOpt = usuarioBD.findByEmail(email);
		if (usuarioOpt.isEmpty())
			throw new UsuarioInvalido();
		return usuarioOpt.get();

	}
}
