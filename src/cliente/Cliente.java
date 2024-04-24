package cliente;

public class Cliente {

	private String nome;
	private Cliente prox;
	
	public Cliente(String nome) {
		setNome(nome);
		setProx(null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente getProx() {
		return prox;
	}

	public void setProx(Cliente prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [nome=");
		builder.append(nome);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
}