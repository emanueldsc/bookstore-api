package com.edsc.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsc.bookstore.domain.Categoria;
import com.edsc.bookstore.domain.Livro;
import com.edsc.bookstore.repositories.LivroRepository;
import com.edsc.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> opt = this.repository.findById(id);
        return opt.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto Não encontrado Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer categoriaId) {
        categoriaService.findById(categoriaId);
        return repository.findAllByCategoria(categoriaId);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public Livro updatePatch(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateDataPatch(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNomeAutor(obj.getNomeAutor());
        newObj.setTexto(obj.getTexto());
    }

    private void updateDataPatch(Livro newObj, Livro obj) {
        if (obj.getTitulo() != null)
            newObj.setTitulo(obj.getTitulo());
        if (obj.getNomeAutor() != null)
            newObj.setNomeAutor(obj.getNomeAutor());
        if (obj.getTexto() != null)
            newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer categoriaId, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(categoriaId);
        obj.setCategoria(cat);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Livro obj = findById(id);
        repository.delete(obj);
    }

}
