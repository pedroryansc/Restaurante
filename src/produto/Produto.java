package produto;

public class Produto {

	private String nome;
	private double preco;
	private Produto prox;
	
	public Produto(String nome, double preco) {
		setNome(nome);
		setPreco(preco);
		setProx(null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Produto getProx() {
		return prox;
	}

	public void setProx(Produto prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [nome=");
		builder.append(nome);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
}
