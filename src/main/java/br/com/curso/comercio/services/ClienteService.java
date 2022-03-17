package br.com.curso.comercio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.comercio.domain.Cliente;
import br.com.curso.comercio.repositories.ClienteRepository;
import br.com.curso.comercio.services.exceptions.ObjetoNaoEncontrado;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscarPorId(Integer id) {

		Optional<Cliente> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Objeto não encontrado! Id: " + id + ", tipo do objeto: " + Cliente.class.getName()));

	}

}
