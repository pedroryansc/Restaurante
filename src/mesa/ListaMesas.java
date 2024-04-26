package mesa;

public class ListaMesas {

	private Mesa inicio;
	
	public ListaMesas() {
		inicio = null;
	}
	
	public Mesa getInicio() {
		return inicio;
	}
	
	public void cadastrar(int capacidade) {
		Mesa novaMesa = new Mesa(1, capacidade);
		if(inicio == null)
			inicio = novaMesa;
		else {
			Mesa aux = inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			novaMesa.setId(aux.getId() + 1);
			aux.setProx(novaMesa);
		}
	}
	
}