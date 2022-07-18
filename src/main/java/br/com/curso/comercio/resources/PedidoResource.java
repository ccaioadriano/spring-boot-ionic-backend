package br.com.curso.comercio.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.comercio.domain.Pedido;
import br.com.curso.comercio.dto.PedidoDTO;
import br.com.curso.comercio.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	PedidoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> listarCategorias() {
		List<Pedido> lista = service.listarPedidos();

		List<PedidoDTO> listaDTO = lista.stream().map(pedido -> new PedidoDTO(pedido)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
		Pedido obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
