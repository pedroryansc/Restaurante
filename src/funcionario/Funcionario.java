package funcionario;

public class Funcionario {

	private String nome;
	private String cargo;
	private boolean segunda;
	private boolean terca;
	private boolean quarta;
	private boolean quinta;
	private boolean sexta;
	private boolean sabado;
	private boolean domingo;
	private Funcionario prox;
	
	public Funcionario(String nome, String cargo) {
		setNome(nome);
		setCargo(cargo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean trabalhaSegunda() {
		return segunda;
	}

	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}

	public boolean trabalhaTerca() {
		return terca;
	}

	public void setTerca(boolean terca) {
		this.terca = terca;
	}

	public boolean trabalhaQuarta() {
		return quarta;
	}

	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}

	public boolean trabalhaQuinta() {
		return quinta;
	}

	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}

	public boolean trabalhaSexta() {
		return sexta;
	}

	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}

	public boolean trabalhaSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	public boolean trabalhaDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	public Funcionario getProx() {
		return prox;
	}

	public void setProx(Funcionario prox) {
		this.prox = prox;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [nome=");
		builder.append(nome);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append(", segunda=");
		builder.append(segunda);
		builder.append(", terca=");
		builder.append(terca);
		builder.append(", quarta=");
		builder.append(quarta);
		builder.append(", quinta=");
		builder.append(quinta);
		builder.append(", sexta=");
		builder.append(sexta);
		builder.append(", sabado=");
		builder.append(sabado);
		builder.append(", domingo=");
		builder.append(domingo);
		builder.append(", prox=");
		builder.append(prox);
		builder.append("]");
		return builder.toString();
	}
	
}