package br.com.alura.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.literalura.principal.Principal;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
	}

}
