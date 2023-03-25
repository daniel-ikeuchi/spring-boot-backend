package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Categoria;

@Repository
public interface CategoriaReposistory extends JpaRepository<Categoria, Integer> {

}
