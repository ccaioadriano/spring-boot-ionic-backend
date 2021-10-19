package br.com.curso.comercio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.comercio.domain.Categoria;
import br.com.curso.comercio.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listarCategorias() {
		List<Categoria> lista = service.listarCategorias();
		return ResponseEntity.ok().body(lista);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Categoria obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);

	}
}
