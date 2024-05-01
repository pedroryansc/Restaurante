package pagamento;

import pedido.Pedido;

public class Pagamento {

	private Pedido inicio; // Lista encadeada que contém os pedidos feitos pelo cliente em sua visita ao restaurante
	private int id = 1;
	private int formaPagamento;
	private double valorPagar;
	private double valorPago;
	private double troco = 0;
	private Pagamento prox;
	
	public Pagamento() {
		inicio = null;
	}
	
	public Pagamento(Pedido pedidos, int formaPagamento, double valorPagar, double valorPago) {
		setInicio(pedidos);
		setFormaPagamento(formaPagamento);
		setValorPagar(valorPagar);
		setValorPago(valorPago);
	}
	
	public void adicionarPedido(Pedido pedido) {
		if(inicio == null)
			inicio = pedido;
		else {
			Pedido aux = inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			aux.setProx(pedido);
		}
	}
	
	public void mostrarPedidos() {
		Pedido aux = inicio;
		
		System.out.println("Cliente: " + aux.getCliente().getNome() + " (Mesa " + aux.getIdMesa() + ")\n");
		
		System.out.println("Pedidos realizados:\n");
		while(aux != null) {
			System.out.println("------ Pedido " + aux.getId() + " ------");
			aux.mostrarProdutos();
			System.out.println("Valor do pedido " + aux.getId() + ": R$ " + aux.getValorTotal() + "\n");
			aux = aux.getProx();
		}
		System.out.println("------------------\n");
		System.out.println("Valor total a pagar: R$ " + valorPagar);
	}
	
	public Pedido getInicio() {
		return inicio;
	}
	
	public void setInicio(Pedido inicio) {
		this.inicio = inicio;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	public Pagamento getProx() {
		return prox;
	}
	
	public void setProx(Pagamento prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pagamento [inicio=");
		builder.append(inicio);
		builder.append(", formaPagamento=");
		builder.append(formaPagamento);
		builder.append(", valorPagar=");
		builder.append(valorPagar);
		builder.append(", valorPago=");
		builder.append(valorPago);
		builder.append(", troco=");
		builder.append(troco);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
}