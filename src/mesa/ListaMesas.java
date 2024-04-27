package mesa;

import cliente.Cliente;

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
	
	public boolean mostrarLista() {
		if(inicio == null) {
			System.out.println("Nenhuma mesa foi cadastrada.\n");
			return false;
		} else {
			Mesa aux = inicio;
			while(aux != null) {
				System.out.print(aux.getId() + ". Mesa " + aux.getId() + " (");
				if(aux.estaOcupada())
					System.out.print("Ocupada)");
				else
					System.out.print("Disponível)");
				System.out.print(" | Capacidade: " + aux.getCapacidade() + " pessoa(s)");
				if(!(aux.foiAtendida()))
					System.out.println(" - Não atendida");
				else
					System.out.println();
				aux = aux.getProx();
			}
			System.out.println();
			return true;
		}	
	}
	
	public int mostrarDisponiveis(int quantClientes) {
		if(inicio == null) {
			System.out.println("Nenhuma mesa foi cadastrada.\n");
			return -1;
		} else {
			Mesa aux = inicio;
			int contDisponivel = 0;
			int contCapacidade = 0;
			int idMesa = 0;
			while(aux != null) {
				if(aux.getCapacidade() >= quantClientes) {
					contCapacidade++;
					if(!(aux.estaOcupada())) {
						idMesa = aux.getId();
						System.out.println(idMesa + ". Mesa " + idMesa + " | Capacidade: " + aux.getCapacidade() + " pessoa(s)");
						contDisponivel++;
					}
				}
				aux = aux.getProx();
			}
			if(contCapacidade == 0) {
				System.out.println("Não há mesas com capacidade para " + quantClientes + " pessoa(s).\n");
				return -2;
			} else {
				if(contDisponivel == 0) {
					System.out.println("Não há mesas disponíveis.\n");
					return 0;
				} else {
					System.out.println();
					return idMesa;
				}
			}
		}
	}
	
	public int mostrarOcupadas() {
		if(inicio == null) {
			System.out.println("Nenhuma mesa foi cadastrada.\n");
			return -1;
		} else {
			Mesa aux = inicio;
			int idMesa = 0;
			while(aux != null) {
				if(aux.estaOcupada()) {
					idMesa = aux.getId();
					System.out.print(idMesa + ". Mesa " + idMesa + " | Capacidade: " + aux.getCapacidade() + " pessoa(s)");
					if(!(aux.foiAtendida()))
						System.out.println(" - Não atendida");
					else
						System.out.println();
				}
				aux = aux.getProx();
			}
			if(idMesa == 0)
				System.out.println("Todas as mesas estão disponíveis.\n");
			return idMesa;
		}
	}
	
	public boolean ocuparMesa(int id, int quantClientes) {
		Mesa aux = inicio;
		while(aux != null) {
			if(aux.getId() == id && !(aux.estaOcupada()) && aux.getCapacidade() >= quantClientes) {
				aux.setAtendida(false);
				aux.setCadeirasOcupadas(quantClientes);
				return true;
			}
			aux = aux.getProx();
		}
		return false;
	}
	
	public boolean adicionarCliente(int idMesa, Cliente cliente) {
		Mesa aux = inicio;
		while(aux != null) {
			if(aux.getId() == idMesa) {
				return aux.adicionarCliente(cliente);
			}
			aux = aux.getProx();
		}
		return false;
	}
	
	public int liberarMesa(int id) {
		if(inicio == null) {
			System.out.println("Nenhuma mesa foi cadastrada");
			return -1;
		} else {
			Mesa aux = inicio;
			while(aux != null) {
				if(aux.getId() == id) {
					aux.setAtendida(true);
					aux.setCadeirasOcupadas(0);
					return 1;
				}
				aux = aux.getProx();
			}
			return 0;
		}
	}
	
}