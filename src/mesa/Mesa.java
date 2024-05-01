package mesa;

import cliente.Cliente;

public class Mesa {

	private Cliente inicio;
	private int id;
	private int capacidade;
	private int cadeirasOcupadas = 0;
	private boolean atendida = true;
	private Mesa prox;
	
	public Mesa(int id, int capacidade) {
		inicio = null;
		setId(id);
		setCapacidade(capacidade);
	}
	
	public boolean estaOcupada() {
		return cadeirasOcupadas > 0;
	}
	
	public boolean adicionarCliente(Cliente cliente) {
		if(inicio == null) {
			inicio = cliente;
			return true;
		} else {
			Cliente aux = inicio;
			while(aux.getProx() != null) {
				if(aux.getNome() == cliente.getNome())
					return false;
				aux = aux.getProx();
			}
			if(aux.getNome() == cliente.getNome())
				return false;
			else {
				aux.setProx(cliente);
				return true;
			}
		}
	}
	
	public int mostrarLista() {
		Cliente aux = inicio;
		int cont = 0;
		while(aux != null){
			cont++;
			System.out.println(cont + ". " + aux.getNome());
			aux = aux.getProx();
		}
		System.out.println();
		return cont;
	}
	
	

	public Cliente getInicio() {
		return inicio;
	}
	
	public void setInicio(Cliente inicio) {
		this.inicio = inicio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getCadeirasOcupadas() {
		return cadeirasOcupadas;
	}

	public void setCadeirasOcupadas(int cadeirasOcupadas) {
		this.cadeirasOcupadas = cadeirasOcupadas;
	}

	public boolean foiAtendida() {
		return atendida;
	}

	public void setAtendida(boolean atendida) {
		this.atendida = atendida;
	}
	
	public Mesa getProx() {
		return prox;
	}
	
	public void setProx(Mesa prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mesa [inicio=");
		builder.append(inicio);
		builder.append(", id=");
		builder.append(id);
		builder.append(", capacidade=");
		builder.append(capacidade);
		builder.append(", cadeirasOcupadas=");
		builder.append(cadeirasOcupadas);
		builder.append(", atendida=");
		builder.append(atendida);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
}