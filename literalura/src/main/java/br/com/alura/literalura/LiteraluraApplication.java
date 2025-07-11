package br.com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.literalura.principal.Principal;
import br.com.alura.literalura.repository.AutoresRepository;
import br.com.alura.literalura.repository.LivrosRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private AutoresRepository autoresRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livrosRepository, autoresRepository);
		principal.exibirMenu();
	}

}
