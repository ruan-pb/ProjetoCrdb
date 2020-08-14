package Api_Projeto_Crdb.Repositorio;

import java.io.Serializable;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api_Projeto_Crdb.Entidades.Comentario;


@Repository
public interface ComentarioRepositorio<T,Id extends Serializable> extends JpaRepository<Comentario, Long> {
	
	
	

}
