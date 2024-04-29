package produto;

public class ListaProdutos {

	private Produto inicio;
	
	public ListaProdutos() {
		inicio = null;
	}
	
	public Produto getInicio() {
		return inicio;
	}
	
	public void cadastrar(String nome, double preco) {
		Produto novoProduto = new Produto(nome, preco);
		if(inicio == null)
			inicio = novoProduto;
		else {
			Produto aux = inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			aux.setProx(novoProduto);
		}
	}
	
	public int mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhum produto foi cadastrado.\n");
			return 0;
		} else {
			Produto aux = inicio;
			int cont = 0;
			while(aux != null) {
				cont++;
				System.out.println(cont + ". " + aux.getNome() + " | Preço: R$ " + aux.getPreco());
				aux = aux.getProx();
			}
			System.out.println();
			return cont;
		}
	}
	
}