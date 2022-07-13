package com.edsc.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edsc.bookstore.domain.Categoria;
import com.edsc.bookstore.domain.Livro;
import com.edsc.bookstore.repositories.CategoryaRepository;
import com.edsc.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryaRepository categoryaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Impsun", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoryaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
