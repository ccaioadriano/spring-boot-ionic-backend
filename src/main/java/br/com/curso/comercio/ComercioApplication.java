package br.com.curso.comercio;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.curso.comercio.domain.Categoria;
import br.com.curso.comercio.domain.Cidade;
import br.com.curso.comercio.domain.Cliente;
import br.com.curso.comercio.domain.Endereco;
import br.com.curso.comercio.domain.Estado;
import br.com.curso.comercio.domain.Pagamento;
import br.com.curso.comercio.domain.PagamentoComBoleto;
import br.com.curso.comercio.domain.PagamentoComCartao;
import br.com.curso.comercio.domain.Pedido;
import br.com.curso.comercio.domain.Produto;
import br.com.curso.comercio.domain.enums.EstadoPagamento;
import br.com.curso.comercio.domain.enums.TipoCliente;
import br.com.curso.comercio.repositories.CategoriaRepository;
import br.com.curso.comercio.repositories.CidadeRepository;
import br.com.curso.comercio.repositories.ClienteRepository;
import br.com.curso.comercio.repositories.EnderecoRepository;
import br.com.curso.comercio.repositories.EstadoRepository;
import br.com.curso.comercio.repositories.PagamentoRepository;
import br.com.curso.comercio.repositories.PedidoRepository;
import br.com.curso.comercio.repositories.ProdutoRepository;

@SpringBootApplication
public class ComercioApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository repoCategoria;

	@Autowired
	ProdutoRepository repoProduto;

	@Autowired
	EstadoRepository repoEstado;

	@Autowired
	CidadeRepository repoCidade;

	@Autowired
	EnderecoRepository repoEndereco;

	@Autowired
	ClienteRepository repoCliente;
	
	@Autowired
	PedidoRepository repoPedido;
	
	@Autowired
	PagamentoRepository repoPagamento;

	public static void main(String[] args) {
		SpringApplication.run(ComercioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "testeAlo", 1000.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat2));

		repoCategoria.saveAll(Arrays.asList(cat1, cat2));
		repoProduto.saveAll(Arrays.asList(p1, p2, p3, p4));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		repoEstado.saveAll(Arrays.asList(est1, est2));
		repoCidade.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378612377", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777010", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		repoCliente.saveAll(Arrays.asList(cli1));
		repoEndereco.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("24/03/2022 13:00"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("26/03/2022 15:45"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("28/03/2022 12:00"),
				null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		repoPedido.saveAll(Arrays.asList(ped1, ped2));
		repoPagamento.saveAll(Arrays.asList(pagto1, pagto2));

	}
}
