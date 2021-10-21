package br.com.curso.comercio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.curso.comercio.domain.Categoria;
import br.com.curso.comercio.repositories.CategoriaRepository;

@SpringBootApplication
public class ComercioApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ComercioApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		repo.saveAll(Arrays.asList(cat1, cat2));
	}	
}
