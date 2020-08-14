package Api_Projeto_Crdb.Repositorio;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api_Projeto_Crdb.Entidades.Usuario;

@Repository
public interface UsuarioRepositorio<T,Email extends Serializable > extends JpaRepository<Usuario, String> {
	Optional<Usuario>findByEmail(String email);

}
