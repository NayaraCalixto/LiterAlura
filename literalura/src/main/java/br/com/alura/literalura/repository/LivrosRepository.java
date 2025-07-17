package br.com.alura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.literalura.model.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{

    List<Livros> findByIdiomaIgnoreCase(String idioma);

}
