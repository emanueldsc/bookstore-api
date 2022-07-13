package com.edsc.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsc.bookstore.domain.Categoria;

@Repository
public interface CategoryaRepository extends JpaRepository<Categoria, Integer>{ }
