package funcionario;

public class ListaFuncionarios {

	private Funcionario inicio;
	
	public ListaFuncionarios() {
		inicio = null;
	}
	
	public Funcionario getInicio() {
		return inicio;
	}
	
	public void cadastrar(String nome, String cargo, int[] dias) {
		Funcionario novoFunc = new Funcionario(nome, cargo);
		novoFunc.setSegunda(dias[0] == 1);
		novoFunc.setTerca(dias[1] == 1);
		novoFunc.setQuarta(dias[2] == 1);
		novoFunc.setQuinta(dias[3] == 1);
		novoFunc.setSexta(dias[4] == 1);
		novoFunc.setSabado(dias[5] == 1);
		novoFunc.setDomingo(dias[6] == 1);
		if(inicio == null)
			inicio = novoFunc;
		else {
			Funcionario aux = inicio;
			while(aux.getProx() != null)
				aux = aux.getProx();
			aux.setProx(novoFunc);
		}
	}
	
	public int mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhum funcionário foi cadastrado.\n");
			return 0;
		} else {
			Funcionario aux = inicio;
			int cont = 0;
			while(aux != null) {
				cont++;
				System.out.println(cont + ". " + aux.getNome() + " (" + aux.getCargo() + ")");
				aux = aux.getProx();
			}
			System.out.println();
			return cont;
		}
	}
	
	public void remover(int posicao) {
		if(posicao == 1)
			inicio = inicio.getProx();
		else {
			Funcionario aux = inicio;
			for(int i = 2; i < posicao; i++)
				aux = aux.getProx();
			aux.setProx(aux.getProx().getProx());
		}
	}
	
	public void mostrarFuncionario(int posicao) {
		Funcionario aux = inicio;
		for(int i = 1; i < posicao; i++)
			aux = aux.getProx();
		System.out.println("Nome: " + aux.getNome());
		System.out.println("Cargo: " + aux.getCargo());
		System.out.println("Escala de trabalho (10h às 15h):");
		if(aux.trabalhaSegunda())
			System.out.println("- Segunda-feira");
		if(aux.trabalhaTerca())
			System.out.println("- Terça-feira");
		if(aux.trabalhaQuarta())
			System.out.println("- Quarta-feira");
		if(aux.trabalhaQuinta())
			System.out.println("- Quinta-feira");
		if(aux.trabalhaSexta())
			System.out.println("- Sexta-feira");
		if(aux.trabalhaSabado())
			System.out.println("- Sábado");
		if(aux.trabalhaDomingo())
			System.out.println("- Domingo");
		System.out.println();
	}
	
	public Funcionario pesquisarFuncionario(int posicao) {
		Funcionario aux = inicio;
		for(int i = 1; i < posicao; i++)
			aux = aux.getProx();
		return aux;
	}
	
	public void mostrarEscala() {
		if(inicio == null)
			System.out.println("Nenhum funcionário foi cadastrado.\n");
		else {
			System.out.println("Período das 10h às 15h:\n");
			int contFuncs = 0;
			for(int i = 1; i <= 7; i++) {
				Funcionario aux = inicio;
				contFuncs = 0;
				if(i == 1)
					System.out.print("- Segunda-feira: ");
				else if(i == 2)
					System.out.print("- Terça-feira: ");
				else if(i == 3)
					System.out.print("- Quarta-feira: ");
				else if(i == 4)
					System.out.print("- Quinta-feira: ");
				else if(i == 5)
					System.out.print("- Sexta-feira: ");
				else if(i == 6)
					System.out.print("- Sábado: ");
				else if(i == 7)
					System.out.print("- Domingo: ");
				while(aux != null) {
					if((i == 1 && aux.trabalhaSegunda()) || (i == 2 && aux.trabalhaTerca()) || (i == 3 && aux.trabalhaQuarta()) ||
					(i == 4 && aux.trabalhaQuinta()) || (i == 5 && aux.trabalhaSexta()) || (i == 6 && aux.trabalhaSabado()) ||
					(i == 7 && aux.trabalhaDomingo())) {
						System.out.print(aux.getNome() + " (" + aux.getCargo() + ") | ");
						contFuncs++;
					}
					aux = aux.getProx();
				}
				if(contFuncs == 0)
					System.out.println("Nenhum funcionário trabalha neste dia.");
				else
					System.out.println();
			}
			System.out.println();
		}
	}
	
}