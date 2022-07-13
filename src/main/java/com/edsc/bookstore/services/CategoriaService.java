package com.edsc.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsc.bookstore.domain.Categoria;
import com.edsc.bookstore.repositories.CategoryaRepository;
import com.edsc.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoryaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> opt = this.repository.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto Não encontrado Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return this.repository.findAll();
    }

}
