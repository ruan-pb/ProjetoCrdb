package Api_Projeto_Crdb.Repositorio;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Api_Projeto_Crdb.Entidades.Disciplina;


@Repository
public interface DisciplinaRepositorio<T,ID extends Serializable> extends JpaRepository<Disciplina, Integer> {

	
	
	Optional<Disciplina>findById(int id);

	Optional<Disciplina> findById(long count);
	
	Optional<Disciplina> findByNome(String nome);

	List<Disciplina> findByOrderByNotaDesc();
	
	//List<Disciplina> findByDisciplinaContaining(String substring);
	
	
}
