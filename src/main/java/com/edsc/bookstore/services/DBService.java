package com.edsc.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsc.bookstore.domain.Categoria;
import com.edsc.bookstore.domain.Livro;
import com.edsc.bookstore.repositories.CategoryaRepository;
import com.edsc.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoryaRepository categoryaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livro de Biografia");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Impsun", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Lovis V. Gerstner", "Lorem Impsun", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem Impsun", cat2);
		Livro l4 = new Livro(null, "The War of The Words", "H.G. Wells", "Lorem Impsun", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem Impsun", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoryaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
