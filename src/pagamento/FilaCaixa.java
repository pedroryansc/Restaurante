package pagamento;

public class FilaCaixa {

	private Pagamento inicio;
	private Pagamento fim;
	private int tamanho;
	
	public Pagamento getInicio() {
		return inicio;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
	
}