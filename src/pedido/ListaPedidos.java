package pedido;

import cliente.Cliente;

public class ListaPedidos {

	private Pedido inicio;
	
	public ListaPedidos() {
		inicio = null;
	}
	
	public Pedido getInicio() {
		return inicio;
	}
	
	public void fazerPedido(int idMesa, Cliente cliente) {
		Pedido novoPedido = new Pedido(idMesa, cliente);
		novoPedido.setProx(inicio);
		inicio = novoPedido;
	}
	
}