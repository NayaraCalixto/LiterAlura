package br.com.alura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.literalura.model.Autores;

public interface AutoresRepository extends JpaRepository<Autores, Long>{

    Autores findByNomeIgnoreCase(String nomeAutor);

    List<Autores> findByAnoNascimento(String anoNascimento); 



}
