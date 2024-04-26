package mesa;

public class Mesa {

	private int id;
	private int capacidade;
	private int cadeirasOcupadas = 0;
	private boolean atendida = true;
	private Mesa prox;
	
	public Mesa(int id, int capacidade) {
		setId(id);
		setCapacidade(capacidade);
	}
	
	public boolean estaOcupada() {
		return cadeirasOcupadas > 0;
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
		builder.append("Mesa [id=");
		builder.append(id);
		builder.append(", capacidade=");
		builder.append(capacidade);
		builder.append(", cadeirasOcupadas=");
		builder.append(cadeirasOcupadas);
		builder.append(", atendida=");
		builder.append(atendida);
		builder.append("]");
		return builder.toString();
	}
	
}