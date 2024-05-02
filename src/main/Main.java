package main;

import java.util.Scanner;

import cliente.*;
import pedido.*;
import mesa.*;
import produto.*;
import funcionario.*;
import pagamento.FilaCaixa;
import pagamento.ListaPagamentos;

public class Main {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		// Criação das listas
		
		ListaClientes clientes = new ListaClientes();
		ListaPedidos pedidos = new ListaPedidos();
		ListaMesas mesas = new ListaMesas();
		ListaProdutos produtos = new ListaProdutos();
		ListaFuncionarios funcs = new ListaFuncionarios();
		ListaPagamentos pags = new ListaPagamentos();
		
		// Criação de nodos de exemplo
		
		/*
		clientes.cadastrar("Pedro");
		clientes.cadastrar("Igor");
		produtos.cadastrar("Arroz", 7);
		produtos.cadastrar("Feijão", 7);
		produtos.cadastrar("Farofa", 1);
		produtos.cadastrar("Ovo Frito", 1);
		produtos.cadastrar("Batata Frita", 4);
		mesas.cadastrar(2);
		*/
		
		// Inicialização das variáveis de estatísticas
		
		int filaSentar = 0;
		int filaNaoAtendidos = 0;
		int pessoasAlmocando = 0;
		int pessoasAtendidas = 0;
		FilaCaixa filaCaixa = new FilaCaixa();
		
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
								Mesa mesaPedido;
								boolean disponivel = false;
								
								do {
									System.out.println("Qual mesa será atendida? (Ou insira 0 para cancelar o pedido)");
									idMesa = entrada.nextInt();
									mesaPedido = mesas.pesquisarMesa(idMesa);
									if(mesaPedido != null){
										if(!(mesaPedido.estaOcupada()))
											disponivel = true;
										else
											disponivel = false;
									}
									if(idMesa == 0)
										disponivel = false;
									if(idMesa < 0 || idMesa > ocupada || disponivel)
										System.out.println("\nErro: Opção inválida\n");
								} while(idMesa < 0 || idMesa > ocupada || disponivel);
								
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
									
									System.out.println("Produtos:");
									pedido.mostrarProdutos();
									
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
						
						int atualizar = -1;
						
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
								
								do {
									System.out.println("\nQual pedido você quer atualizar? (Ou insira 0 para voltar)");
									idPedido = entrada.nextInt();
									pedido = pedidos.pesquisarPedido(idPedido);
									if(pedido != null) {
										if(pedido.foiEntregue())
											foiEntregue = true;
										else
											foiEntregue = false;
									}
									if(idPedido < 0 || idPedido > quantPedidos || ((pedido == null || foiEntregue) && idPedido != 0))
										System.out.println("\nErro: Opção inválida");
								} while(idPedido < 0 || idPedido > quantPedidos || ((pedido == null || foiEntregue) && idPedido != 0));
								
								if(idPedido != 0) {
									do {
										System.out.println("\nPedido " + pedido.getId() + " (Mesa " + pedido.getIdMesa() + ")\n");
										
										System.out.println("Produtos:");
										pedido.mostrarProdutos();
										
										System.out.println("Cliente: " + pedido.getCliente().getNome());
										System.out.println("Valor Total: R$ " + pedido.getValorTotal());
										
										System.out.println();
										
										do {
											System.out.println("O que você gostaria de fazer?");
											System.out.println("(1) Adicionar produto");
											System.out.println("(0) Voltar");
											atualizar = entrada.nextInt();
											if(atualizar < 0 || atualizar > 1)
												System.out.println("\nErro: Opção inválida\n");
										} while(atualizar < 0 || atualizar > 1);
										
										System.out.println();
										
										if(atualizar == 1) {
											int quantProdutos;
											int idProduto;
											boolean finalizar = false;
											
											while(!(finalizar)) {
												do {
													quantProdutos = produtos.mostrarLista();
													
													System.out.println("Insira o número do produto para adicioná-lo ao pedido (ou 0 para voltar)");
													idProduto = entrada.nextInt();
													if(idProduto < 0 || idProduto > quantProdutos)
														System.out.println("\nErro: Opção inválida\n");
													else if(idProduto == 0)
														finalizar = true;
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
													
													pedidos.adicionarProduto(pedido.getId(), produto, quantidade);
													
													System.out.println("\n" + quantidade + " unidade(s) de " + produto.getNome() + " adicionada(s) com sucesso.\n");
												}
											}
										}
									} while(atualizar != 0);
								} else
									atualizar = -1;
							}
						} while(atualizar == 0);
												
						System.out.println();
					} else if(escolha == 4) {
						
						// Cancelamento de pedidos
						
						System.out.println("Cancelamento de Pedido\n");
						
						int cancelar = -1;
						
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
								
								do {
									System.out.println("\nQual pedido você quer cancelar? (Ou insira 0 para cancelar a operação)");
									idPedido = entrada.nextInt();
									pedido = pedidos.pesquisarPedido(idPedido);
									if(pedido != null) {
										if(pedido.foiEntregue())
											foiEntregue = true;
										else
											foiEntregue = false;
									}
									if(idPedido < 0 || idPedido > quantPedidos || ((pedido == null || foiEntregue) && idPedido != 0))
										System.out.println("\nErro: Opção inválida");
								} while(idPedido < 0 || idPedido > quantPedidos || ((pedido == null || foiEntregue) && idPedido != 0));
								
								System.out.println();
								
								if(idPedido != 0) {
									System.out.println("Pedido " + pedido.getId() + " (Mesa " + pedido.getIdMesa() + ")\n");
									
									System.out.println("Produtos:");
									pedido.mostrarProdutos();
									
									System.out.println("Cliente: " + pedido.getCliente().getNome());
									System.out.println("Valor Total: R$ " + pedido.getValorTotal());
									
									System.out.println();
									
									do {
										System.out.println("Tem certeza de que quer cancelar o pedido " + pedido.getId() + " da mesa " + pedido.getIdMesa() + "?");
										System.out.println("(1) Sim");
										System.out.println("(0) Cancelar");
										cancelar = entrada.nextInt();
										if(cancelar < 0 || cancelar > 1)
											System.out.println("\nErro: Opção inválida\n");
									} while(cancelar < 0 || cancelar > 1);
									
									if(cancelar == 1) {
										pedidos.cancelar(idPedido);
										System.out.println("\nPedido cancelado com sucesso.");
									} else
										System.out.println("\nOperação cancelada.\n");
								} else {
									System.out.println("Operação cancelada.");
									cancelar = -1;
								}
							}
						} while(cancelar == 0);
						
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
									System.out.println("Pedido " + pedido.getId() + " (Mesa " + pedido.getIdMesa() + ")\n");
									
									System.out.println("Produtos:");
									pedido.mostrarProdutos();
									
									System.out.println("Cliente: " + pedido.getCliente().getNome());
									System.out.println("Valor Total: R$ " + pedido.getValorTotal());
									
									System.out.println();
									
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
										
										// Quando um pedido é entregue a uma mesa não atendida:
										// - A mesa muda seu estado para "atendida";
										// - A fila de pessoas não atendidas diminui;
										// - A quantidade de pessoas almoçando aumenta; e
										// - A quantidade de pessoas atendidas aumenta.
										
										Mesa mesaAtendida = mesas.pesquisarMesa(pedido.getIdMesa());
										
										if(!(mesaAtendida.foiAtendida())) {
											mesas.atenderMesa(pedido.getIdMesa());
											filaNaoAtendidos = filaNaoAtendidos - mesaAtendida.getCadeirasOcupadas();
											pessoasAlmocando += mesaAtendida.getCadeirasOcupadas();
											pessoasAtendidas += mesaAtendida.getCadeirasOcupadas();
										}
										
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
									
									// Se houver alguma pessoa na fila para sentar, ao ocupar uma mesa, a fila diminui
									
									if(filaSentar > 0) {
										filaSentar = filaSentar - quantPessoas;
										if(filaSentar < 0)
											filaSentar = 0;
									}
									
									// Juntamente, quando a fila para sentar diminui, a fila de pessoas não atendidas aumenta
									
									filaNaoAtendidos += quantPessoas;
									
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
							Mesa mesaLiberada;
							boolean liberar;
							
							do {
								System.out.println("Qual mesa você quer liberar? (Ou insira 0 para cancelar a operação)");
								idMesa = entrada.nextInt();
								mesaLiberada = mesas.pesquisarMesa(idMesa);
								if(mesaLiberada != null) {
									if(mesaLiberada.estaOcupada()) {
										
										// Se a mesa foi liberada sem ser atendida, a fila de pessoas não atendidas diminui.
										// Caso contrário, a quantidade de pessoas almoçando diminui e a fila do caixa aumenta.
										
										if(!(mesaLiberada.foiAtendida()))
											filaNaoAtendidos = filaNaoAtendidos - mesaLiberada.getCadeirasOcupadas();
										else {
											pessoasAlmocando = pessoasAlmocando - mesaLiberada.getCadeirasOcupadas();
											
											Cliente auxCli = mesaLiberada.getInicio();
											
											while(auxCli != null) {
												int cont = 1;
												Pedido auxPed = pedidos.getInicio();
												while(auxPed != null) {
													if(auxCli.getNome() == auxPed.getCliente().getNome() && auxPed.foiEntregue() && !(auxPed.foiPago())) {
														if(cont == 1) {
															filaCaixa.entrarNaFila();
															cont++;
														}
														filaCaixa.adicionarPedido(auxPed);
													}
													auxPed = auxPed.getProx();
												}
												auxCli = auxCli.getProx();
											}
										}
									}
								}
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
			} else if(sistema == 5) {
				
				// Seção "Funcionários"
				
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Funcionários\n");
					
					do {
						System.out.println("O que você gostaria de fazer?");
						System.out.println("(1) Cadastrar funcionário");
						System.out.println("(2) Consultar funcionários cadastrados");
						System.out.println("(3) Consultar escala de trabalho dos funcionários");
						System.out.println("(4) Remover funcionário");
						System.out.println("(0) Voltar");
						escolha = entrada.nextInt();
						if(escolha < 0 || escolha > 4)
							System.out.println("\nErro: Opção inválida\n");
					} while(escolha < 0 || escolha > 4);
					
					System.out.println();
					
					if(escolha == 1) {
						
						// Cadastro de novos funcionários, como garçons, cozinheiros, etc
						
						System.out.println("Cadastro de Funcionário\n");
						
						entrada.nextLine();
						
						System.out.println("Insira o nome do funcionário (ou 0 para cancelar o cadastro):");
						String nome = entrada.nextLine();
						
						System.out.println();
						
						if(!(nome.equals("0"))){
							System.out.println("Cargo do funcionário:");
							String cargo = entrada.nextLine();
							
							int[] dias = new int[7];
							
							int contDias = 0;
							boolean indeterminado = true;
							
							do {
								for(int i = 0; i < 7; i++) {
									
									do {
										System.out.print("\nO funcionário trabalha ");
										if(i == 0)
											System.out.println("às segundas-feiras?");
										else if(i == 1)
											System.out.println("às terças-feiras?");
										else if(i == 2)
											System.out.println("às quartas-feiras?");
										else if(i == 3)
											System.out.println("às quintas-feiras?");
										else if(i == 4)
											System.out.println("às sextas-feiras?");
										else if(i == 5)
											System.out.println("aos sábados?");
										else
											System.out.println("aos domingos?");
										System.out.println("(1) Sim");
										System.out.println("(0) Não trabalha");
										dias[i] = entrada.nextInt();
										if(dias[i] < 0 || dias[i] > 1)
											System.out.println("\nErro: Opção inválida");
										else if(dias[i] == 1)
											contDias++;
									} while(dias[i] < 0 || dias[i] > 1);
								}
								
								if(contDias > 0)
									indeterminado = false;
								else {
									System.out.println("\nNenhum dia de trabalho foi definido para " + nome + ".");
									System.out.println("Por favor, responda novamente");
								}
							} while(indeterminado);
							
							funcs.cadastrar(nome, cargo, dias);
							System.out.println("\nCadastro realizado com sucesso.");
						} else
							System.out.println("Cadastro cancelado.");
						
						System.out.println();
					} else if(escolha == 2) {
						
						// Consulta de funcionários cadastrados
						
						boolean visualizar = true;
						
						while(visualizar) {
							System.out.println("Lista de Funcionários\n");
							
							int quantFuncs = funcs.mostrarLista();
							
							if(quantFuncs == 0) {
								System.out.println("Insira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
								
								visualizar = false;
							} else {
								int posicao;
								
								do {
									System.out.println("Qual funcionário você quer visualizar? (Ou insira 0 para voltar)");
									posicao = entrada.nextInt();
									if(posicao < 0 || posicao > quantFuncs)
										System.out.println("\nErro: Opção inválida\n");
								} while(posicao < 0 || posicao > quantFuncs);
								
								if(posicao != 0) {
									System.out.println();
									
									funcs.mostrarFuncionario(posicao);
									
									System.out.println("Insira qualquer tecla para voltar:");
									entrada.nextLine();
									entrada.nextLine();
									
									System.out.println();
								} else
									visualizar = false;
							}
						}
						
						System.out.println();
					} else if(escolha == 3) {
						
						// Escala de trabalho dos funcionários
						
						System.out.println("Escala de Trabalho dos Funcionários\n");
						
						funcs.mostrarEscala();
						
						System.out.println("Insira qualquer tecla para voltar:");
						entrada.nextLine();
						entrada.nextLine();
						
						System.out.println();
					} else if(escolha == 4) {
						
						// Remoção de funcionários
						
						System.out.println("Remoção de Funcionário\n");
						
						int remover = -1;
						
						do {
							int quantFuncs = funcs.mostrarLista();
							
							if(quantFuncs > 0) {
								int posicao;
								
								do {
									System.out.println("Qual funcionário você quer remover? (Ou insira 0 para cancelar a remoção)");
									posicao = entrada.nextInt();
									if(posicao < 0 || posicao > quantFuncs)
										System.out.println("\nErro: Opção inválida\n");
								} while(posicao < 0 || posicao > quantFuncs);
								
								System.out.println();
								
								if(posicao != 0) {
									Funcionario dadosFunc = funcs.pesquisarFuncionario(posicao);
									
									do {
										System.out.println("Tem certeza de que quer remover o funcionário " + dadosFunc.getNome() + "?");
										System.out.println("(1) Sim");
										System.out.println("(0) Cancelar");
										remover = entrada.nextInt();
										if(remover < 0 || remover > 1)
											System.out.println("\nErro: Opção inválida\n");
									} while(remover < 0 || remover > 1);
									
									System.out.println();
									
									if(remover == 1) {
										funcs.remover(posicao);
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
			} else if(sistema == 6) {
				
				// Seção "Pagamentos"
				
				int escolha = -1;
				
				while(escolha != 0) {
					System.out.println("Pagamentos\n");
					
					do {
						System.out.println("O que você gostaria de fazer?");
						System.out.println("(1) Realizar pagamento");
						System.out.println("(2) Consultar histórico de pagamentos");
						System.out.println("(0) Voltar");
						escolha = entrada.nextInt();
						if(escolha < 0 || escolha > 2)
							System.out.println("\nErro: Opção inválida\n");
					} while(escolha < 0 || escolha > 2);
					
					System.out.println();
					
					if(escolha == 1) {
						
						// Registro de pagamentos realizados pelos clientes
						
						System.out.println("Registro de Pagamento\n");

						if(filaCaixa.estaVazia()) {
							System.out.println("Não há nenhuma pessoa na fila do caixa.\n");
							System.out.println("Insira qualquer tecla para voltar:");
							entrada.nextLine();
							entrada.nextLine();
						} else {
							int pagar;
							
							do {
								System.out.println("Há " + filaCaixa.getTamanho() + " pessoa(s) na fila do caixa para pagar. Você vai atender agora?");
								System.out.println("(1) Sim");
								System.out.println("(0) Cancelar");
								pagar = entrada.nextInt();
								if(pagar < 0 || pagar > 1)
									System.out.println("\nErro: Opção inválida\n");
							} while(pagar < 0 || pagar > 1);
							
							System.out.println();
							
							if(pagar != 0) {
								filaCaixa.mostrarPedidos();
								
								int formaPagamento;
								
								do {
									System.out.println("\nQual será a forma de pagamento?");
									System.out.println("(1) Dinheiro Físico");
									System.out.println("(2) Cartão de Débito");
									System.out.println("(3) Cartão de Crédito");
									System.out.println("(4) Pix");
									System.out.println("(5) Vale-refeição");
									formaPagamento = entrada.nextInt();
									if(formaPagamento < 1 || formaPagamento > 5)
										System.out.println("\nErro: Opção inválida");
								} while(formaPagamento < 1 || formaPagamento > 5);
								
								System.out.println();
								
								double valorPagar = filaCaixa.getInicio().getValorPagar();
								double valorPago = 0;
								
								if(formaPagamento == 1) {
									do {
										System.out.print("Insira a quantia entregue pelo cliente");
										if(valorPago > 0)
											System.out.println(" (Quantia atual: R$ " + valorPago + "):");
										else
											System.out.println(":");
										System.out.print("R$ ");
										valorPago += entrada.nextDouble();
										if(valorPago < valorPagar) {
											System.out.println("\nErro: A quantia entregue é menor que R$ " + valorPagar + ".");
											System.out.println("Adicione mais dinheiro para pagar a conta.\n");
										}
									} while(valorPago < valorPagar);
									
									System.out.println();
								} else
									valorPago = valorPagar;
								
								pags.pagarConta(filaCaixa.getInicio().getInicio(), formaPagamento, valorPagar, valorPago);
								pedidos.pagar(filaCaixa.getInicio().getInicio());
								filaCaixa.sairDaFila();
								
								System.out.println("Pagamento realizado com sucesso.");
							} else
								System.out.println("Operação cancelada.");
						}
						
						System.out.println();
					} else if(escolha == 2) {
						
						// Consulta de histórico de pagamentos realizados
						
						boolean visualizar = true;
						
						do {
							System.out.println("Histórico de Pagamentos\n");
							
							int quantPagamentos = pags.mostrarLista();
							
							if(quantPagamentos > 0) {
								int idPagamento;
								
								do {
									System.out.println("Qual pagamento você quer visualizar? (Ou insira 0 para voltar)");
									idPagamento = entrada.nextInt();
									if(idPagamento < 0 || idPagamento > quantPagamentos)
										System.out.println("\nErro: Opção inválida\n");
								} while(idPagamento < 0 || idPagamento > quantPagamentos);
								
								if(idPagamento != 0) {
									pags.mostrarPagamento(idPagamento);
									
									int emitir;
									
									do {
										System.out.println("Você quer emitir o comprovante de pagamento?");
										System.out.println("(1) Sim");
										System.out.println("(0) Cancelar");
										emitir = entrada.nextInt();
										if(emitir < 0 || emitir > 1)
											System.out.println("\nErro: Opção inválida\n");
									} while(emitir < 0 || emitir > 1);
									
									System.out.println();
									
									if(emitir == 1) {
										pags.emitirComprovante(idPagamento);
										
										System.out.println("Comprovante emitido com sucesso.\n");
										
										System.out.println("Insira qualquer tecla para voltar:");
										entrada.nextLine();
										entrada.nextLine();
										
										System.out.println();
									} else
										System.out.println("Operação cancelada.\n");
								} else
									visualizar = false;
							} else {
								System.out.println("Insira qualquer tecla para voltar:");
								entrada.nextLine();
								entrada.nextLine();
								
								visualizar = false;
							}
						} while(visualizar);
						
						System.out.println();
					}
				}
			} else if(sistema == 7) {
				
				// Seção "Estatísticas"
				
				int filaAlmocar = filaSentar + filaNaoAtendidos;
				
				System.out.println("Estatísticas\n");
				
				System.out.println("Pessoas na fila para sentar: " + filaSentar + " pessoa(s)");
				System.out.println("Pessoas na fila para serem atendidas: " + filaNaoAtendidos + " pessoa(s)");
				System.out.println("Pessoas na fila para almoçar: " + filaAlmocar + " pessoa(s)");
				System.out.println("Pessoas almoçando: " + pessoasAlmocando + " pessoa(s)");
				System.out.println("Pessoas atendidas: " + pessoasAtendidas + " pessoa(s)");
				System.out.println("Pessoas na fila do caixa: " + filaCaixa.getTamanho() + " pessoa(s)");
				System.out.println("Mesas disponíveis: " + mesas.contarDisponiveis() + " mesa(s)");
				
				System.out.println("\nInsira qualquer tecla para voltar");
				entrada.nextLine();
				entrada.nextLine();
				
				System.out.println();
			}
		}
		System.out.print("Fim do sistema");
		entrada.close();
	}
}