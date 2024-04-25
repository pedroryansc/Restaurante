package mesa;

import cliente.Cliente;

public class Mesa {

	private Cliente inicio;
	private int capacidade;
	private int cadeirasOcupadas = 0;
	
	public Mesa(int capacidade) {
		this.capacidade = capacidade;
	}

	public Cliente getInicio() {
		return inicio;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getCadeirasOcupadas() {
		return cadeirasOcupadas;
	}
	
	public boolean temEspaco() {
		return capacidade > cadeirasOcupadas;
	}
	
}