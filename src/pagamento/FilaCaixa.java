package pagamento;

import pedido.Pedido;

public class FilaCaixa {

	private Pagamento inicio;
	private Pagamento fim;
	private int tamanho;
	
	public Pagamento getInicio() {
		return inicio;
	}
	
	public Pagamento getFim() {
		return fim;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
	
	public void entrarNaFila() {
		Pagamento novoPagamento = new Pagamento();
		if(estaVazia()) {
			inicio = novoPagamento;
			fim = inicio;
		} else {
			fim.setProx(novoPagamento);
			fim = novoPagamento;
		}
		tamanho++;
	}
	
	public void sairDaFila() {
		inicio = inicio.getProx();
		tamanho--;
		if(estaVazia())
			fim = null;
	}
	
	public void adicionarPedido(Pedido pedido) {
		Pedido novoPedido = new Pedido(pedido.getId(), pedido.getIdMesa(), pedido.getCliente());
		novoPedido.setValorTotal(pedido.getValorTotal());
		novoPedido.setEntregue(true);
		novoPedido.setInicio(pedido.getInicio());
		
		Pagamento aux = inicio;
		while(aux.getProx() != null)
			aux = aux.getProx();
		aux.setValorPagar(aux.getValorPagar() + pedido.getValorTotal());
		
		aux.adicionarPedido(novoPedido);
	}
	
	public void mostrarPedidos() {
		inicio.mostrarPedidos();
	}
	
}