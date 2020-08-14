package Api_Projeto_Crdb.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Api_Projeto_Crdb.DTO.UsuarioLoginDTO;
import Api_Projeto_Crdb.Excecoes.UsuarioInvalido;
import Api_Projeto_Crdb.Servico.JWTServico;
import Api_Projeto_Crdb.Servico.LoginResponse;

@RestController
public class LoginControlador {

	@Autowired
	private JWTServico jwtServico;

	@PostMapping("/autorizacao/login")
	public ResponseEntity<LoginResponse> autenticarUsuario(@RequestBody UsuarioLoginDTO usuario) {
		try {
			return new ResponseEntity<LoginResponse>(jwtServico.autentica(usuario), HttpStatus.OK);
		} catch (UsuarioInvalido e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
}
