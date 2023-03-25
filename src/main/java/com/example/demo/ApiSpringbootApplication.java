package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaReposistory;
import com.example.demo.repositories.ProdutoReposistory;

@SpringBootApplication
public class ApiSpringbootApplication implements CommandLineRunner {

	@Autowired
	private CategoriaReposistory categoriaReposistory;
	
	@Autowired
	private ProdutoReposistory produtoReposistory;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaReposistory.saveAll(Arrays.asList(cat1, cat2));
		produtoReposistory.saveAll(Arrays.asList(p1, p2, p3));
	}

}
