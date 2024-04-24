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
	
	public void mostraLista() {
		if(inicio == null)
			System.out.println("Nenhum cliente cadastrado.");
		else {
			Cliente aux = inicio;
			int cont = 0;
			while(aux != null) {
				System.out.println(cont + ". " + aux.getNome());
				aux = aux.getProx();
			}
		}
	}
	
}