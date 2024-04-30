package pedido;

import cliente.Cliente;
import produto.Produto;

public class ListaPedidos {

	private Pedido inicio;
	
	public ListaPedidos() {
		inicio = null;
	}
	
	public Pedido getInicio() {
		return inicio;
	}
	
	public void fazerPedido(int idMesa, String nomeCliente) {
		Cliente cliente = new Cliente(nomeCliente);
		Pedido novoPedido = new Pedido(1, idMesa, cliente);
		novoPedido.setProx(inicio);
		inicio = novoPedido;
		if(inicio.getProx() != null)
			inicio.setId(inicio.getProx().getId() + 1);
	}
	
	public void adicionarProduto(int idPedido, Produto produto, int quantidade) {
		Produto produtoPedido = new Produto(produto.getId(), produto.getNome(), produto.getPreco());
		Pedido aux = inicio;
		while(aux != null) {
			if(aux.getId() == idPedido) {
				aux.setValorTotal(aux.getValorTotal() + (produto.getPreco() * quantidade));
				aux.adicionarProduto(produtoPedido, quantidade);
				return;
			}
			aux = aux.getProx();
		}
	}
	
	public int mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhum pedido foi realizado.\n");
			return 0;
		} else {
			Pedido aux = inicio;
			while(aux != null) {
				System.out.print(aux.getId() + ". Pedido " + aux.getId() + " | Mesa " + aux.getIdMesa());
				if(aux.foiEntregue()) {
					if(aux.foiPago())
						System.out.print(" (Pago)");
					else
						System.out.println(" (Entregue) - Não pago");
				} else
					System.out.println(" (Não entregue)");
				aux = aux.getProx();
			}
			System.out.println();
			return inicio.getId();
		}
	}
	
	public int mostrarNaoEntregues() {
		if(inicio == null) {
			System.out.println("Nenhum pedido foi realizado.\n");
			return -1;
		} else {
			Pedido aux = inicio;
			int idPedido = 0;
			while(aux != null) {
				if(!(aux.foiEntregue())) {
					System.out.println(aux.getId() + ". Pedido" + aux.getId() + " | Mesa " + aux.getIdMesa());
					if(idPedido == 0)
						idPedido = aux.getId();
				}
				aux = aux.getProx();
			}
			System.out.println();
			return idPedido;
		}
	}
	
	public Pedido pesquisarPedido(int idPedido) {
		Pedido aux = inicio;
		while(aux != null) {
			if(aux.getId() == idPedido)
				return aux;
			aux = aux.getProx();
		}
		return null;
	}
	
}