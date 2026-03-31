package org.example.livraria.repository;

import org.example.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByNomeContainingIgnoreCase(String nome);
}
