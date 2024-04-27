package cliente;

public class ListaClientes {

	private Cliente inicio;
	
	public ListaClientes() {
		inicio = null;
	}
	
	public Cliente getInicio() {
		return inicio;
	}
	
	public void cadastrar(String nome) {
		Cliente novoCliente = new Cliente(nome);
		if(inicio == null)
			inicio = novoCliente;
		else {
			Cliente aux = inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			aux.setProx(novoCliente);
		}
	}
	
	public int mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhum cliente foi cadastrado.\n");
			return 0;
		} else {
			Cliente aux = inicio;
			int cont = 0;
			while(aux != null) {
				cont++;
				System.out.println(cont + ". " + aux.getNome());
				aux = aux.getProx();
			}
			System.out.println();
			return cont;
		}
	}
	
	public Cliente pesquisarCliente(int posicao) {
		if(posicao > 0) {
			Cliente aux = inicio;
			for(int i = 1; i < posicao; i++)
				aux = aux.getProx();
			return aux;
		} else
			return null;
	}
	
	public void remover(int posicao) {
		if(posicao == 1)
			inicio = inicio.getProx();
		else{
			Cliente aux = inicio;
			for(int i = 2; i < posicao; i++)
				aux = aux.getProx();
			aux.setProx(aux.getProx().getProx());
		}
	}
	
	public void atualizar(int posicao, String nome) {
		Cliente clienteAtualizado = new Cliente(nome);
		if(posicao == 1) {
			clienteAtualizado.setProx(inicio.getProx());
			inicio = clienteAtualizado;
		} else {
			Cliente aux = inicio;
			for(int i = 2; i < posicao; i++)
				aux = aux.getProx();
			clienteAtualizado.setProx(aux.getProx().getProx());
			aux.setProx(clienteAtualizado);
		}
	}
	
	public int contarClientes() {
		if(inicio == null)
			return 0;
		else {
			Cliente aux = inicio;
			int cont = 0;
			while(aux != null) {
				cont++;
				aux = aux.getProx();
			}
			return cont;
		}
	}
	
}