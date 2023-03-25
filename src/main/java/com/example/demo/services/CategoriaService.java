package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.repositories.CategoriaReposistory;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaReposistory repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado => id: " + id + " | Tipo: " + Categoria.class.getName()));
	}
	
}
