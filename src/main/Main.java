package main;

import java.util.Scanner;

import cliente.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		ListaClientes clientes = new ListaClientes();
		
		int sistema = 1;
		
		while(sistema != 0) { // Estrutura de repetição que mantém a execução do sistema
			
			// Menu principal
			
			System.out.println("Restaurante \033[3mLa Structure de Données\033[0m\n");
			
			do {
				System.out.println("Insira o número correspondente à seção que você quer acessar:");
				System.out.println("(1) Clientes");
				System.out.println("(2) Pedidos");
				System.out.println("(3) Mesas");
				System.out.println("(4) Funcionários");
				System.out.println("(5) Pagamentos");
				System.out.println("(6) Estatísticas");
				System.out.println("(0) Sair");
				sistema = entrada.nextInt();
				if(sistema < 0 || sistema > 6)
					System.out.println("\nErro: Opção inválida\n");
			} while(sistema < 0 || sistema > 6);
			
			System.out.println();
			
			// Seção "Clientes"
			
			if(sistema == 1) {
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Clientes\n");
					
					do {
						System.out.println("O que você gostaria de fazer?");
						System.out.println("(1) Cadastrar cliente");
						System.out.println("(2) Consultar clientes cadastrados");
						System.out.println("(3) Atualizar cliente");
						System.out.println("(4) Remover cliente");
						System.out.println("(0) Voltar");
						escolha = entrada.nextInt();
						if(escolha < 0 || escolha > 4)
							System.out.println("\nErro: Opção inválida\n");
					} while(escolha < 0 || escolha > 4);
					
					System.out.println();
					
					if(escolha == 1) {
						
						// Cadastro de clientes
						
						System.out.println("Cadastro de Cliente \n");
						
						entrada.nextLine();
						
						System.out.println("Insira o nome do cliente (ou 0 para cancelar o cadastro):");
						String nome = entrada.nextLine();
						
						if(!(nome.equals("0"))){
							clientes.cadastrar(nome);
							System.out.println("\nCadastro realizado com sucesso.");
						} else
							System.out.println("\nCadastro cancelado.");
						
						System.out.println();
					} else if(escolha == 2) {
						
						// Consulta dos clientes cadastrados
						
						System.out.println("Lista de Clientes \n");
						
						clientes.mostrarLista();
						
						System.out.println("Insira qualquer tecla para voltar:");
						entrada.nextLine();
						entrada.nextLine();
						
						System.out.println();
					} else if(escolha == 3) {
						
						// Atualização das informações dos clientes
						
						System.out.println("Atualização de cliente \n");
						
						int quantClientes = clientes.mostrarLista();
						int posicao = 0;
						
						if(quantClientes > 0) {
							do {
								System.out.println("Qual cliente você quer atualizar? (Ou insira 0 para cancelar)");
								posicao = entrada.nextInt();
								if(posicao < 0 || posicao > quantClientes)
									System.out.println("\nErro: Opção inválida\n");
							} while(posicao < 0 || posicao > quantClientes);
							
							System.out.println();
							
							if(posicao != 0) {
								Cliente dadosCliente = clientes.pesquisarCliente(posicao);
								
								System.out.println("Insira o novo nome (Nome atual: " + dadosCliente.getNome() + ")");
								entrada.nextLine();
								String nome = entrada.nextLine();
								
								clientes.atualizar(posicao, nome);
								System.out.println("\nCliente atualizado com sucesso.");
							} else
								System.out.println("Atualização cancelada.");
						} else {
							System.out.println("Insira qualquer tecla para voltar:");
							entrada.nextLine();
							entrada.nextLine();
						}
						
						System.out.println();
					} else if(escolha == 4) {
						
						// Remoção de clientes
						
						System.out.println("Remoção de cliente \n");
						
						int remover = -1;
						
						do {
							int quantClientes = clientes.mostrarLista();
							int posicao = 0;
							
							if(quantClientes > 0) {
								do {
									System.out.println("Qual cliente você quer remover? (Ou insira 0 para cancelar a remoção)");
									posicao = entrada.nextInt();
									if(posicao < 0 || posicao > quantClientes)
										System.out.println("\nErro: Opção inválida\n");
								} while(posicao < 0 || posicao > quantClientes);
									
								System.out.println();
								
								if(posicao != 0) {
									Cliente dadosCliente = clientes.pesquisarCliente(posicao);
									
									do {
										System.out.println("Tem certeza de que quer remover o cliente " + dadosCliente.getNome() + "?");
										System.out.println("(1) Sim");
										System.out.println("(0) Cancelar");
										remover = entrada.nextInt();
										if(remover < 0 || remover > 1)
											System.out.println("\nErro: Opção inválida\n");
									} while(remover < 0 || remover > 1);
									
									System.out.println();
									
									if(remover == 1) {
										clientes.remover(posicao);
										System.out.println("Remoção realizada com sucesso.");
									} else
										System.out.println("Remoção cancelada.\n");
								} else {
									System.out.println("Remoção cancelada.");
									remover = -1;
								}
							}
						} while(remover == 0);
						
						System.out.println();
					}
				}
			} else if(sistema == 3) {
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Mesas\n");
					
					do {
						System.out.println("Você quer alocar uma mesa?");
						System.out.println("(1) Sim");
						System.out.println("(0) Voltar");
					} while(escolha < 0 || escolha > 1);
				}
			}
		}
		System.out.print("Fim do sistema");
		entrada.close();
	}
}