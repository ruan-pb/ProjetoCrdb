package Api_Projeto_Crdb;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import Api_Projeto_Crdb.filtros.filtroToken;



@SpringBootApplication
public class ApiProjetoCrdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjetoCrdbApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<filtroToken> filtroJwt(){
		FilterRegistrationBean<filtroToken> filtroRB = new FilterRegistrationBean<filtroToken>();
		filtroRB.setFilter(new filtroToken());
		filtroRB.addUrlPatterns("/usuario/deletar","/comentario/adicionarComentario/{disciplina}","/comentario/deletarComentario/{Id}","/disciplina/like/{Id}","/disciplina/buscar/{id}","/disciplina/hankingNotas");
		return filtroRB;
		
	
	
	
	}

}
