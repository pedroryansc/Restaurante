package pagamento;

import pedido.Pedido;

public class Pagamento {

	private Pedido inicio; // Lista encadeada que contém os pedidos feito pelo cliente em sua visita ao restaurante
	private double valorTotal;
	private Pagamento prox;
	
}