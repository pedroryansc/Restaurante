package pedido;

import produto.Produto;
import cliente.Cliente;

public class Pedido {

	private Produto inicio;
	private int idMesa;
	private Cliente cliente;
	private double valorTotal;
	private boolean entregue = false;
	private boolean pago = false;
	private Pedido prox;
	
	public Pedido(int idMesa, Cliente cliente) {
		inicio = null;
		setIdMesa(idMesa);
		setCliente(cliente);
	}

	public Produto getInicio() {
		return inicio;
	}
	
	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public boolean foiEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public boolean foiPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Pedido getProx() {
		return prox;
	}

	public void setProx(Pedido prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [inicio=");
		builder.append(inicio);
		builder.append(", idMesa=");
		builder.append(idMesa);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", valorTotal=");
		builder.append(valorTotal);
		builder.append(", entregue=");
		builder.append(entregue);
		builder.append(", pago=");
		builder.append(pago);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
}