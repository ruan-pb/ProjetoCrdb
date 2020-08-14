package Api_Projeto_Crdb.Controladores;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api_Projeto_Crdb.Entidades.Comentario;

import Api_Projeto_Crdb.Excecoes.ComentarioException;

import Api_Projeto_Crdb.Servico.ComentarioServico;


@RestController
@RequestMapping("/comentario")
public class ComentarioControlador {

	@Autowired
	private ComentarioServico comentarioServico;

	@PostMapping("/adicionarComentario/{disciplina}")
	public ResponseEntity<Comentario> adicionarComentario(@RequestBody Comentario comentario,@RequestHeader("Authorization") String autorizacao, @PathVariable String disciplina) {
		
		try {
		return new ResponseEntity<Comentario>(comentarioServico.AdicionarNovoComentario(comentario, autorizacao, disciplina.toUpperCase()),HttpStatus.CREATED);
		}
		catch(ComentarioException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
	}
	
	
	@DeleteMapping("/deletarComentario/{Id}")
	public ResponseEntity<Comentario> deletarComentario(@RequestHeader("Authorization")String token, @PathVariable long Id){
		try {
			return new ResponseEntity<Comentario>(comentarioServico.deletarComentario(token, Id),HttpStatus.OK);
		}
		catch(ComentarioException e) {
			return ResponseEntity.notFound().build();
			
		}
	}
	
	
	
	
	
}
