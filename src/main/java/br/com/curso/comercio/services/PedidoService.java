package br.com.curso.comercio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.comercio.domain.Pedido;
import br.com.curso.comercio.repositories.PedidoRepository;
import br.com.curso.comercio.services.exceptions.ObjetoNaoEncontrado;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public List<Pedido> listarPedidos() {

		List<Pedido> lista = repo.findAll();

		return lista;
	}
	
	public Pedido buscarPorId(Integer id) {

		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjetoNaoEncontrado(
				"Objeto não encontrado! Id: " + id + ", tipo do objeto: " + Pedido.class.getName()));

	}

}
