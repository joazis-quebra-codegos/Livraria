package org.example.livraria.controller;

import jakarta.validation.Valid;
import org.example.livraria.model.Livro;
import org.example.livraria.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service){
        this.service = service;
    }

    @GetMapping("{/id}")
    public Livro buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @GetMapping
    public List<Livro> listar(){
        return service.listar();
    }

    @PostMapping("{/id}")
    public Livro criar(@RequestBody @Valid Livro livro){
        return service.salvar(livro);
    }

    @PutMapping("{/id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro){
        livro.setId(id);
        return service.salvar(livro);
    }

    @DeleteMapping("{/id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
