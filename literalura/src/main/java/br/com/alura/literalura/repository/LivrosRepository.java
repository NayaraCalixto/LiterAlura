package br.com.alura.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.literalura.model.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{

}
