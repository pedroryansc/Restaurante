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
		Produto novoProduto = new Produto(1, nome, preco);
		if(inicio == null)
			inicio = novoProduto;
		else {
			Produto aux = inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			novoProduto.setId(aux.getId() + 1);
			aux.setProx(novoProduto);
		}
	}
	
	public int mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhum produto foi cadastrado.\n");
			return 0;
		} else {
			Produto aux = inicio;
			int id = 0;
			while(aux != null) {
				id = aux.getId();
				System.out.println(id + ". " + aux.getNome() + " | Preço: R$ " + aux.getPreco());
				aux = aux.getProx();
			}
			System.out.println();
			return id;
		}
	}
	
	public Produto pesquisarProduto(int id) {
		Produto aux = inicio;
		while(aux != null) {
			if(aux.getId() == id)
				return aux;
			aux = aux.getProx();
		}
		return null;
	}
	
	public int contarProdutos() {
		Produto aux = inicio;
		int cont = 0;
		while(aux != null) {
			cont++;
			aux = aux.getProx();
		}
		return cont;
	}
	
}