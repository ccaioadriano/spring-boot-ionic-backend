package br.com.curso.comercio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.curso.comercio.domain.ItemPedido;
import br.com.curso.comercio.domain.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;

	private ClienteDTO cliente;

	private Set<ItemPedido> itens = new HashSet<>();

	public PedidoDTO() {

	}

	public PedidoDTO(Pedido pedido) {

		id = pedido.getId();
		instante = pedido.getInstante();
		cliente = new ClienteDTO(pedido.getCliente());
		itens = pedido.getItens();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

}
