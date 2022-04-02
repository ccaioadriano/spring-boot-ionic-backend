package br.com.curso.comercio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.comercio.domain.Categoria;
import br.com.curso.comercio.repositories.CategoriaRepository;
import br.com.curso.comercio.services.exceptions.ObjetoNaoEncontrado;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> listarCategorias() {

		List<Categoria> lista = repo.findAll();

		return lista;
	}

	public Categoria buscarPorId(Integer id) {

		Optional<Categoria> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Objeto não encontrado! Id: " + id + ", tipo do objeto: " + Categoria.class.getName()));

	}
	
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return repo.save(categoria);
	}

}
