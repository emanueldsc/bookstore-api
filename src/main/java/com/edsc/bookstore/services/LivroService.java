package com.edsc.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsc.bookstore.domain.Livro;
import com.edsc.bookstore.repositories.LivroRepository;
import com.edsc.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id) {
        Optional<Livro> opt = this.repository.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto Não encontrado Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

}
