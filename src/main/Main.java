package main;

import java.util.Scanner;

import cliente.*;
import pedido.*;
import mesa.ListaMesas;
import produto.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		// Criação das listas
		
		ListaClientes clientes = new ListaClientes();
		ListaPedidos pedidos = new ListaPedidos();
		ListaMesas mesas = new ListaMesas();
		ListaProdutos produtos = new ListaProdutos();
		
		// Criação de nodos de exemplo
		
		clientes.cadastrar("Pedro");
		clientes.cadastrar("Igor");
		produtos.cadastrar("Arroz", 7);
		produtos.cadastrar("Feijão", 7);
		produtos.cadastrar("Farofa", 1);
		produtos.cadastrar("Ovo Frito", 1);
		produtos.cadastrar("Batata Frita", 4);
		mesas.cadastrar(2);
		
		// Inicialização das variáveis de estatística
		
		int filaSentar = 0;
		
		int sistema = 1;
		
		while(sistema != 0) { // Estrutura de repetição que mantém a execução do sistema
			
			// Menu principal
			
			System.out.println("Restaurante \033[3mLa Structure de Données\033[0m\n");
			
			do {
				System.out.println("Insira o número correspondente à seção que você quer acessar:");
				System.out.println("(1) Clientes");
				System.out.println("(2) Pedidos");
				System.out.println("(3) Mesas");
				System.out.println("(4) Produtos");
				System.out.println("(5) Funcionários");
				System.out.println("(6) Pagamentos");
				System.out.println("(7) Estatísticas");
				System.out.println("(0) Sair");
				sistema = entrada.nextInt();
				if(sistema < 0 || sistema > 7)
					System.out.println("\nErro: Opção inválida\n");
			} while(sistema < 0 || sistema > 7);
			
			System.out.println();
			
			if(sistema == 1) {
				
				// Seção "Clientes"
				
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
							} else {
								System.out.println("Insira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
							}
						} while(remover == 0);
						
						System.out.println();
					}
				}
			} else if(sistema == 2) {
				
				// Seção "Pedidos"
				
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Pedidos\n");
					
					do {
						System.out.println("O que você gostaria de fazer?");
						System.out.println("(1) Fazer pedido");
						System.out.println("(2) Consultar pedidos realizados");
						System.out.println("(3) Alterar pedido");
						System.out.println("(4) Cancelar pedido");
						System.out.println("(5) Entregar pedido");
						System.out.println("(0) Voltar");
						escolha = entrada.nextInt();
						if(escolha < 0 || escolha > 5)
							System.out.println("\nErro: Opção inválida\n");
					} while(escolha < 0 || escolha > 5);
					
					System.out.println();
					
					if(escolha == 1) {
						
						// Registro de novos pedidos
						
						System.out.println("Registro de Pedido\n");
						
						if(produtos.contarProdutos() > 0) {
							int ocupada = mesas.mostrarOcupadas();
							
							System.out.println();
							
							if(ocupada <= 0) {
								System.out.println("Insira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
							} else {
								int idMesa;
								boolean atender;
								
								do {
									System.out.println("Qual mesa será atendida? (Ou insira 0 para cancelar o pedido)");
									idMesa = entrada.nextInt();
									atender = mesas.atenderMesa(idMesa);
									if(idMesa < 0 || idMesa > ocupada || !(atender))
										System.out.println("\nErro: Opção inválida\n");
								} while(idMesa < 0 || idMesa > ocupada || !(atender));
								
								System.out.println();
								
								if(idMesa != 0) {
									int quantClientes = mesas.listarClientes(idMesa);
									
									int posicao;
									
									do {
										System.out.println("O pedido estará no nome de qual cliente?");
										posicao = entrada.nextInt();
										if(posicao < 1 || posicao > quantClientes)
											System.out.println("\nErro: Opção inválida\n");
									} while(posicao < 1 || posicao > quantClientes);
									
									Cliente cliente = mesas.pesquisarCliente(idMesa, posicao);
									pedidos.fazerPedido(idMesa, cliente.getNome());
									
									System.out.println();
									
									int quantProdutos;
									int idProduto;
									boolean finalizar = false;
									
									while(!(finalizar)) {
										do {
											quantProdutos = produtos.mostrarLista();
											
											System.out.print("Insira o número do produto para adicioná-lo ao pedido");
											if(pedidos.getInicio().getInicio() != null)
												System.out.println(" (ou 0 para finalizar)");
											else
												System.out.println();
											
											idProduto = entrada.nextInt();
											
											if(pedidos.getInicio().getInicio() != null) {
												if(idProduto < 0 || idProduto > quantProdutos)
													System.out.println("\nErro: Opção inválida\n");
												else if(idProduto == 0)
													finalizar = true;
											} else {
												if(idProduto <= 0 || idProduto > quantProdutos) {
													System.out.println("\nErro: Opção inválida\n");
													idProduto = -1;
												}
											}
										} while(idProduto < 0 || idProduto > quantProdutos);
										
										if(idProduto > 0 && idProduto <= quantProdutos) {
											Produto produto = produtos.pesquisarProduto(idProduto);
											
											int quantidade;
											
											do {
												System.out.println("\nQual é a quantidade desejada de " + produto.getNome() + "?");
												quantidade = entrada.nextInt();
												if(quantidade <= 0)
													System.out.println("\nErro: Insira um número maior que 0");
											} while(quantidade <= 0);
											
											pedidos.adicionarProduto(pedidos.getInicio().getId(), produto, quantidade);
											
											System.out.println("\n" + quantidade + " unidade(s) de " + produto.getNome() + " adicionada(s) com sucesso.\n");
										}
									}
									
									System.out.println("\nPedido realizado com sucesso.");
								} else
									System.out.println("Pedido cancelado.");
							}
						} else {
							System.out.println("Nenhum produto foi cadastrado.\n");
							System.out.println("Insira qualquer tecla para voltar:");
							entrada.nextLine();
							entrada.nextLine();
						}
						
						System.out.println();
					} else if(escolha == 2) {
						
						// Consulta de pedidos realizados
						
						boolean visualizar = true;
						
						while(visualizar) {
							System.out.println("Lista de Pedidos Realizados\n");
							
							int quantPedidos = pedidos.mostrarLista();
							
							if(quantPedidos > 0) {
								int idPedido;
								Pedido pedido;
								
								do {
									System.out.println("Qual pedido você quer visualizar? (Ou insira 0 para voltar)");
									idPedido = entrada.nextInt();
									pedido = pedidos.pesquisarPedido(idPedido);
									if(idPedido < 0 || idPedido > quantPedidos || (pedido == null && idPedido != 0))
										System.out.println("\nErro: Opção inválida\n");
								} while(idPedido < 0 || idPedido > quantPedidos || (pedido == null && idPedido != 0));
								
								if(idPedido != 0) {
									System.out.println("\nPedido " + pedido.getId() + " (Mesa " + pedido.getIdMesa() + ")\n");
									
									System.out.println("Cliente: " + pedido.getCliente().getNome());
									System.out.println("Valor Total: R$ " + pedido.getValorTotal());
									System.out.print("Status: ");
									if(pedido.foiEntregue()) {
										if(pedido.foiPago())
											System.out.println("Pago");
										else
											System.out.println("Entregue - Não pago");
									} else
										System.out.println("Não entregue");
									
									System.out.println("\nInsira qualquer tecla para voltar:");
									entrada.nextLine();
									entrada.nextLine();
									
									System.out.println();
								} else
									visualizar = false;
							} else {
								System.out.println("Insira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
								
								visualizar = false;
							}
						}
						
						System.out.println();
					} else if(escolha == 3) {
						
						// Alteração de pedidos
						
						System.out.println("Alteração de Pedido\n");
						
						int quantPedidos = pedidos.mostrarLista();
						
						if(quantPedidos > 0) {
							
							// Continuar
							
						} else {
							System.out.println("Insira qualquer tecla para voltar:");
							entrada.nextLine();
							entrada.nextLine();
						}
						
						System.out.println();
					} else if(escolha == 4) {
						
						// Cancelamento de pedidos
						
						System.out.println("Cancelamento de Pedido\n");
						
						int quantPedidos = pedidos.mostrarNaoEntregues();
						
						if(quantPedidos <= 0) {
							System.out.println("Insira qualquer tecla para voltar:");
							entrada.nextLine();
							entrada.nextLine();
						} else {
							
							// Continuar
							
						}
						
						System.out.println();
					} else if(escolha == 5) {
						
						// Entregar pedido na mesa do cliente
						
						System.out.println("Entregar Pedido\n");
						
						int entregar = -1;
						
						do {
							int quantPedidos = pedidos.mostrarNaoEntregues();
							
							if(quantPedidos <= 0) {
								System.out.println("Insira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
							} else {
								int idPedido;
								Pedido pedido;
								boolean foiEntregue = false;
								
								System.out.println();
								
								do {
									System.out.println("Insira o número do pedido a ser entregue (ou 0 para cancelar a operação):");
									idPedido = entrada.nextInt();
									pedido = pedidos.pesquisarPedido(idPedido);
									if(pedido != null) {
										if(pedido.foiEntregue())
											foiEntregue = true;
										else
											foiEntregue = false;
									}
									if(idPedido < 0 || idPedido > quantPedidos || (pedido == null && idPedido != 0) || (foiEntregue && idPedido != 0))
										System.out.println("\nErro: Opção inválida\n");
								} while(idPedido < 0 || idPedido > quantPedidos || (pedido == null && idPedido != 0) || (foiEntregue && idPedido != 0));
								
								System.out.println();
								
								if(idPedido != 0) {
									do {
										System.out.println("Entregar pedido " + pedido.getId() + " para a mesa " + pedido.getIdMesa() + "?");
										System.out.println("(1) Sim");
										System.out.println("(0) Cancelar");
										entregar = entrada.nextInt();
										if(entregar < 0 || entregar > 1)
											System.out.println("\nErro: Opção inválida\n");
									} while(entregar < 0 || entregar > 1);
									
									System.out.println();
									
									if(entregar == 1) {
										pedidos.entregar(idPedido);
										System.out.println("Entrega realizada com sucesso.");
									} else
										System.out.println("Operação cancelada.\n");
								} else {
									System.out.println("Operação cancelada.");
									entregar = -1;
								}
							}
						} while(entregar == 0);
						
						System.out.println();
					}
				}
			} else if(sistema == 3) {
				
				// Seção "Mesas"
				
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Mesas\n");
					
					do {
						System.out.println("O que você gostaria de fazer?");
						System.out.println("(1) Cadastrar mesa");
						System.out.println("(2) Consultar mesas ocupadas e disponíveis");
						System.out.println("(3) Ocupar mesa");
						System.out.println("(4) Liberar mesa");
						System.out.println("(0) Voltar");
						escolha = entrada.nextInt();
						if(escolha < 0 || escolha > 4)
							System.out.println("\nErro: Opção inválida\n");
					} while(escolha < 0 || escolha > 4);
					
					System.out.println();
					
					if(escolha == 1) {
						
						// Cadastro de mesa
						
						System.out.println("Cadastro de Mesa \n");
						
						int quantCadeiras;
						
						do {
							System.out.println("Insira a quantidade de cadeiras da mesa (ou 0 para cancelar o cadastro):");
							quantCadeiras = entrada.nextInt();
							if(quantCadeiras < 0)
								System.out.println("\nErro: Insira um número maior ou igual a 0 \n");
						} while(quantCadeiras < 0);
						
						if(quantCadeiras > 0) {
							mesas.cadastrar(quantCadeiras);
							System.out.println("\nCadastro realizado com sucesso.");
						} else
							System.out.println("\nCadastro cancelado.");
						
						System.out.println();
					} else if(escolha == 2) {
						
						// Consulta de mesas ocupadas e disponíveis
						
						System.out.println("Consulta de Mesas Ocupadas e Disponíveis\n");
						
						mesas.mostrarLista();
						
						System.out.println("Insira qualquer tecla para voltar:");
						entrada.nextLine();
						entrada.nextLine();
						
						System.out.println();
					} else if(escolha == 3) {
						
						// Alocação de mesa para clientes
						
						System.out.println("Ocupar Mesa\n");
						
						int quantPessoas;
						
						do {
							System.out.println("Quantas pessoas vão ocupar a mesa? (Ou insira 0 para cancelar a operação)");
							quantPessoas = entrada.nextInt();
							if(quantPessoas < 0)
								System.out.println("\nErro: Insira um número maior ou igual a 0 \n");
						} while(quantPessoas < 0);
						
						System.out.println();
						
						if(quantPessoas > 0) {
							if(clientes.contarClientes() >= quantPessoas) {
								int disponivel = mesas.mostrarDisponiveis(quantPessoas);
								
								if(disponivel < 0) {
									System.out.println("Insira qualquer tecla para voltar:");
									entrada.nextLine();
									entrada.nextLine();
								} else if(disponivel == 0) {
									int adicionar;
									
									do {
										System.out.println("Adicionar pessoa(s) à fila para sentar?");
										System.out.println("(1) Sim");
										System.out.println("(0) Cancelar");
										adicionar = entrada.nextInt();
										if(adicionar < 0 || adicionar > 1)
											System.out.println("\nErro: Opção inválida\n");
									} while(adicionar < 0 || adicionar > 1);
									
									if(adicionar == 1) {
										filaSentar += quantPessoas;
										System.out.println("\n" + quantPessoas + " pessoa(s) adicionada(s) à fila para sentar.");
									} else
										System.out.println("\nOperação cancelada.");
								} else {
									int idMesa;
									boolean ocupar;
									
									do {
										System.out.println("Em qual mesa as pessoas vão se sentar?");
										idMesa = entrada.nextInt();
										ocupar = mesas.ocuparMesa(idMesa, quantPessoas);
										if(idMesa < 1 || idMesa > disponivel || !(ocupar))
											System.out.println("\nErro: Opção inválida\n");
									} while(idMesa < 1 || idMesa > disponivel || !(ocupar));
									
									System.out.println();
									
									if(filaSentar > 0) { // Ao mesmo tempo que diminui a quantidade de pessoas na fila para sentar, aumenta a quantidade na fila para almoçar
										filaSentar = filaSentar - quantPessoas;
										if(filaSentar < 0)
											filaSentar = 0;
									}
									
									int posicao;
									boolean adicionar = true;
									
									for(int i = 1; i <= quantPessoas; i++) {
										
										int contClientes = clientes.mostrarLista();
										Cliente cliente;
										
										do {
											System.out.println("Quem é a " + i + "ª pessoa da mesa?");
											posicao = entrada.nextInt();
											cliente = clientes.pesquisarCliente(posicao);
											if(posicao > 0 && posicao <= clientes.contarClientes()) {
												adicionar = mesas.adicionarCliente(idMesa, cliente.getNome());
												if(!(adicionar))
													System.out.println("\nErro: Cliente " + cliente.getNome() + " já inserido\n");
											} else
												System.out.println("\nErro: Opção inválida\n");
										} while(posicao < 1 || posicao > contClientes || !(adicionar));
										
										System.out.println("\nCliente " + cliente.getNome() + " adicionado com sucesso.");
										
										System.out.println();
									}
									
									System.out.println("Mesa ocupada com sucesso.");
								}
							} else {
								System.out.println("Não há " + quantPessoas + " pessoa(s) cadastrada(s).");
								System.out.println("\nInsira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
							}
						} else
							System.out.println("Operação cancelada.");
						
						System.out.println();
					} else if(escolha == 4) {
						
						// Liberação de mesas após a saída dos clientes
						
						System.out.println("Liberar Mesa\n");
						
						int ocupada = mesas.mostrarOcupadas();
						
						System.out.println();
						
						if(ocupada <= 0) {
							System.out.println("Insira qualquer tecla para voltar:");
							entrada.nextLine();
							entrada.nextLine();
						} else{
							int idMesa;
							boolean liberar;
							
							do {
								System.out.println("Qual mesa você quer liberar? (Ou insira 0 para cancelar a operação)");
								idMesa = entrada.nextInt();
								liberar = mesas.liberarMesa(idMesa);
								if(idMesa < 0 || idMesa > ocupada || !(liberar))
									System.out.println("\nErro: Opção inválida\n");
							} while(idMesa < 0 || idMesa > ocupada || !(liberar));
							
							if(idMesa != 0)
								System.out.println("\nMesa liberada com sucesso.");
							else
								System.out.println("\nOperação cancelada.");
						}
						
						System.out.println();
					}
				}
			} else if(sistema == 4) {
				
				// Seção "Produtos"
				
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Produtos\n");
					
					do {
						System.out.println("O que você gostaria de fazer?");
						System.out.println("(1) Cadastrar produto");
						System.out.println("(2) Consultar produtos");
						System.out.println("(0) Voltar");
						escolha = entrada.nextInt();
						if(escolha < 0 || escolha > 2)
							System.out.println("\nErro: Opção inválida\n");
					} while(escolha < 0 || escolha > 2);
					
					System.out.println();
					
					if(escolha == 1) {
						
						// Cadastro de produto
						
						System.out.println("Cadastro de Produto\n");
						
						entrada.nextLine();
						
						System.out.println("Insira o nome do produto (ou 0 para cancelar o cadastro):");
						String nome = entrada.nextLine();
						
						if(!(nome.equals("0"))) {
							double preco;
							
							do {
								System.out.println("\nPreço do produto:");
								preco = entrada.nextDouble();
								if(preco <= 0)
									System.out.println("\nErro: Insira um valor maior que 0");
							} while(preco <= 0);
							
							produtos.cadastrar(nome, preco);
							
							System.out.println("\nCadastro realizado com sucesso.");
						} else
							System.out.println("\nCadastro cancelado.");
						
						System.out.println();
					} else if(escolha == 2) {
						
						// Consulta dos produtos cadastrados
						
						System.out.println("Lista de Produtos\n");
						
						produtos.mostrarLista();
						
						System.out.println("Insira qualquer tecla para voltar:");
						entrada.nextLine();
						entrada.nextLine();
						
						System.out.println();
					}
				}
			}
		}
		System.out.print("Fim do sistema");
		entrada.close();
	}
}