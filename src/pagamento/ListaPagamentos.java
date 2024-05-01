package pagamento;

import pedido.Pedido;

public class ListaPagamentos {

	private Pagamento inicio;
	
	public ListaPagamentos() {
		inicio = null;
	}
	
	public void pagarConta(Pedido pedidos, int formaPagamento, double valorPagar, double valorPago) {
		Pagamento novoPagamento = new Pagamento(pedidos, formaPagamento, valorPagar, valorPago);
		if(valorPago > valorPagar)
			novoPagamento.setTroco(valorPago - valorPagar);
		Pedido aux = novoPagamento.getInicio();
		while(aux != null) {
			aux.setPago(true);
			aux = aux.getProx();
		}
		novoPagamento.setProx(inicio);
		inicio = novoPagamento;
		if(inicio.getProx() != null)
			inicio.setId(inicio.getProx().getId() + 1);
	}
	
	public int mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhum pagamento foi realizado.\n");
			return 0;
		} else {
			Pagamento aux = inicio;
			int idPagamento = inicio.getId();
			while(aux != null) {
				System.out.println(aux.getId() + ". Pagamento " + aux.getId() + " (Valor total: R$ " + aux.getValorPagar() + ")");
				aux = aux.getProx();
			}
			System.out.println();
			return idPagamento;
		}
	}
	
	public void mostrarPagamento(int idPagamento) {
		Pagamento aux = inicio;
		while(aux != null) {
			if(aux.getId() == idPagamento) {
				System.out.println("\nPagamento Nº" + idPagamento);
				aux.mostrarPedidos();
				System.out.println("Valor pago: R$ " + aux.getValorPago());
				System.out.println("Troco: R$ " + aux.getTroco());
				System.out.print("Forma de Pagamento: ");
				
				int forma = aux.getFormaPagamento();
				
				if(forma == 1)
					System.out.println("Dinheiro Físico");
				else if(forma == 2)
					System.out.println("Cartão de Débito");
				else if(forma == 3)
					System.out.println("Cartão de Crédito");
				else if(forma == 4)
					System.out.println("Pix");
				else if(forma == 5)
					System.out.println("Vale-refeição");
				
				System.out.println();
				return;
			}
			aux = aux.getProx();
		}
	}
	
	public void emitirComprovante(int idPagamento) {
		System.out.println("-------- Comprovante de Pagamento --------");
		mostrarPagamento(idPagamento);
		System.out.println("--- Restaurante \033[3mLa Structure de Données\033[0m ---");
		System.out.println();
	}
	
}