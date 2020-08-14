package Api_Projeto_Crdb.Servico;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api_Projeto_Crdb.Entidades.Comentario;
import Api_Projeto_Crdb.Entidades.Disciplina;
import Api_Projeto_Crdb.Entidades.Usuario;
import Api_Projeto_Crdb.Excecoes.ComentarioException;
import Api_Projeto_Crdb.Repositorio.ComentarioRepositorio;


@Service
public class ComentarioServico {

	@Autowired
	private ComentarioRepositorio<Comentario, Long> comentarioBD;


	@Autowired
	private JWTServico jwtServico;

	@Autowired
	private UsuarioServico usuarioServico;

	@Autowired
	private DisciplinaServico disciplinaServico;



	public Comentario AdicionarNovoComentario(Comentario novoComentario, String autorizacao, String disciplina) {
		java.util.Date data = new java.util.Date();//data

		java.sql.Time hora = new java.sql.Time(data.getTime()); //hora
		
		java.sql.Date now = new java.sql.Date(data.getTime());
		String email = jwtServico.getUsuarioId(autorizacao);//validando o token
		novoComentario.setUsuario(usuarioServico.getUsuario(email));

		novoComentario.setDisciplina(disciplinaServico.getOneNome(disciplina));
		novoComentario.setData(now);
		novoComentario.setHora(hora);
		comentarioBD.save(novoComentario);
		return this.ultimoComentarioAlternativa();

	}

	public Comentario ultimoComentarioAlternativa() {
		return comentarioBD.findById(comentarioBD.count()).get();

	}

	public List<Comentario> ComentariosDeDisciplina(int id) {

		
		
		List<Comentario> comentarios = new ArrayList<>(); 
		Disciplina disciplina = disciplinaServico.getOne(id);

		for(Comentario p:comentarioBD.findAll()) {
			
			if(disciplina.getId()==id) {
				comentarios.add(p);
				
			}
			
		}

		

		return comentarios;
	}


	public Comentario deletarComentario(String token, Long id) {
		Optional<String> usuarioId = jwtServico.recuperarUsuario(token);
		Usuario usuario = usuarioServico.validarUsuario(usuarioId);

		Optional<Comentario> comentario = comentarioBD.findById(id);

		if (comentario.get().getUsuario().getEmail() == usuario.getEmail()) {
			if (comentario.get().getId() == id) {
				return this.Resposta(id);
			}

		}

		throw new ComentarioException("Não pode apagar comentarios de outra pessoa");

	}

	public Comentario deletar(String token, Long id) {
		Optional<String> usuarioId = jwtServico.recuperarUsuario(token);// recupara Usuario do Token

		Usuario usuario = usuarioServico.validarUsuario(usuarioId); // valindando usuario e pegando todos os dados desse
																	
		Optional<Comentario> comentario = comentarioBD.findById(id); // recupera usuario que esta na tabela

		for (Comentario c : comentarioBD.findAll()) {

			if (comentario.get().getUsuario().getEmail().equals(usuario.getEmail())) {
				if (c.getId() == id) {
					c.setComentario("");
				} else {
					comentarioBD.save(c);
				}

			}
			throw new ComentarioException("Voce não pode apagar comentarios de outras pessoas");

		}
		return this.Resposta(id);

	}

	public Comentario Resposta(long id) {
		Comentario comentario = comentarioBD.getOne(id);
		comentario.setComentario("   ");
		return comentario;

	}

	public List<Comentario> comentariosDePessoas(String email) {
		List<Comentario> listaDeComentarios = new ArrayList<>();
		for (Comentario c : this.comentarioBD.findAll()) {
			if (c.getUsuario().getEmail().equals(email)) {
				listaDeComentarios.add(c);
			}
		}
		return listaDeComentarios;

	}

	public List<Comentario> listaTodosComentarios() {
		List<Comentario> lista = comentarioBD.findAll();
		return lista;
	}

	public List<Comentario> comentariosDePessoasNome(String nome) {
		List<Comentario> ListaComentariosPorNome = new ArrayList<>();
		for (Comentario c : this.comentarioBD.findAll()) {
			if (c.getUsuario().getNome().equals(nome)) {
				ListaComentariosPorNome.add(c);
			}
		}
		return ListaComentariosPorNome;

	}

	public Comentario buscar(long id) {
		Optional<Comentario> comentario = comentarioBD.findById(id);
		if (comentario.isPresent()) {
			return comentario.get();

		}
		throw new ComentarioException();

	}

	

}
