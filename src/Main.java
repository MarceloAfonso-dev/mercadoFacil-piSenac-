import java.io.IOException;
import java.util.Scanner;

import gerenciadores.GerenciadorCompra;
import gerenciadores.GerenciadorEmpresa;
import gerenciadores.GerenciadorFornecedor;
import gerenciadores.GerenciadorLogin;
import gerenciadores.GerenciadorProduto;
import gerenciadores.GerenciadorUsuario;

public class Main {
	static Scanner leitor = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		System.out.println("\r\n"
				+ "  __  __                        _         ______ __       _ _ \r\n"
				+ " |  \\/  |                      | |       |  ____/_/      (_) |\r\n"
				+ " | \\  / | ___ _ __ ___ __ _  __| | ___   | |__  __ _  ___ _| |\r\n"
				+ " | |\\/| |/ _ \\ '__/ __/ _` |/ _` |/ _ \\  |  __|/ _` |/ __| | |\r\n"
				+ " | |  | |  __/ | | (_| (_| | (_| | (_) | | |  | (_| | (__| | |\r\n"
				+ " |_|  |_|\\___|_|  \\___\\__,_|\\__,_|\\___/  |_|   \\__,_|\\___|_|_|\r\n"
				+ "                                                              \r\n"
				+ "                                                              \r\n"
				+ "");
		
		GerenciadorEmpresa.verificaEmpresa();
		clearConsole();

		
//PRODUTO
//		GerenciadorProduto.imprimirProdutos();
//		GerenciadorProduto.verificarQuantidadeProdutos();
		
//COMPRA
//		GerenciadorCompra.imprimirCompras();
//		GerenciadorCompra.verificarQuantidadeCompras();
		
//USUARIO
//		GerenciadorUsuario.imprimirUsuarios();
//		GerenciadorUsuario.verificarQuantidadeUsuarios();

//OFERTA
//		GerenciadorOferta.imprimirOfertas();
//		GerenciadorOferta.verificarQuantidadeOfertas();
		
//FUNCIONARIO
//		GerenciadorFuncionario.imprimirFuncionarios();
//		GerenciadorFuncionario.verificarQuantidadeFuncionarios();
		
//ESTOQUE
//		GerenciadorEstoque.imprimirEstoque();
//		GerenciadorEstoque.verificarQuantidadeEstoque();
		
//FORNECEDORES
//		GerenciadorFornecedor.imprimirFornecedores();
//		GerenciadorFornecedor.verificarQuantidadeFornecedores();
		
		int opcao = 1;
		
		do {
			System.out.println("""
					\nInsira a opção desejada
					0. Encerrar Sistema
					1. Fazer Login
						""");
			opcao = leitor.nextInt();
			switch (opcao) {
			case 1 -> {
				switch (GerenciadorLogin.pegarLogin()) {
				case "Caixa" -> {
					System.out.println("Olá caixa");
					GerenciadorProduto.imprimirProdutos();
					GerenciadorProduto.verificarQuantidadeProdutos();
				}
				case "Gerente" -> {
					System.out.println("Olá gerente");
					GerenciadorCompra.imprimirCompras();
					GerenciadorCompra.verificarQuantidadeCompras();
				}
				case "Administrador" -> {
					System.out.println("\nOlá administrador");
					acoesAdministrador();
				}
				default -> {
					System.err.println("\nUsuário Inválido\n");
				}
				}
			}
			case 0 -> {
				System.err.println("\nEncerrando Sistema...");
			}
			default -> {
				System.err.println("\nOpção Inválida!\n");
			}
			}
		} while (opcao != 0);
	}
	
	public static void acoesAdministrador() throws IOException {
		int opcao = 0;
		do {
			System.out.println("""
					\nEscolha qual item deseja acessar:
					0. Sair
					1. Usuário
					2. Compra
					3. Fornecedores
					4. Empresa
					""");
			opcao = leitor.nextInt();
			switch(opcao) {
			case 1 -> {
				System.out.println("""
						\nSelecione a ação desejada:
						0. Voltar
						1. Consultar quantidade de usuários
						2. Exibir todos os usuários
						""");
				int opcaoInterna = leitor.nextInt();
				switch(opcaoInterna) {
				case 1 -> {
					GerenciadorUsuario.verificarQuantidadeUsuarios();
				}
				case 2 -> {
					GerenciadorUsuario.imprimirUsuarios();
				}
				case 0 -> {
					// Voltar ao menu anterior
				}
				default -> {
					System.err.println("\nOpção Inválida!\n");
				}
				}
			}
			case 2 -> {
				System.out.println("""
						\nSelecione a ação desejada:
						0. Voltar
						1. Consultar quantidade de compras
						2. Exibir todos os compras
						""");
				int opcaoInterna = leitor.nextInt();
				switch(opcaoInterna) {
				case 1 -> {
					GerenciadorCompra.verificarQuantidadeCompras();
				}
				case 2 -> {
					GerenciadorCompra.imprimirCompras();
				}
				case 0 -> {
					// Voltar ao menu anterior
				}
				default -> {
					System.err.println("\nOpção Inválida!\n");
				}
				}
			}
			case 3 -> {
				System.out.println("""
						\nSelecione a ação desejada:
						0. Voltar
						1. Consultar quantidade de fornecedores
						2. Exibir todos os fornecedores
						""");
				int opcaoInterna = leitor.nextInt();
				switch(opcaoInterna) {
				case 1 -> {
					GerenciadorFornecedor.verificarQuantidadeFornecedores();
				}
				case 2 -> {
					GerenciadorFornecedor.imprimirFornecedores();
				}
				case 0 -> {
					// Voltar ao menu anterior
				}
				default -> {
					System.err.println("\nOpção Inválida!\n");
				}
				}
			}
			case 4 -> {
				System.out.println("""
						\nSelecione a ação desejada:
						0. Voltar
						1. Exibir dados da empresa
						2. Alterar dados da empresa
						""");
				int opcaoInterna = leitor.nextInt();
				switch(opcaoInterna) {
				case 1 -> {
					GerenciadorEmpresa.imprimirEmpresa();
				}
				case 2 -> {
					GerenciadorEmpresa.alterarDados();
				}
				case 0 -> {
					// Voltar ao menu anterior
				}
				default -> {
					System.err.println("Opção Inválida!");
					}
				}
			}
			case 0 -> {
				System.out.println("Saindo do menu do administrador...\n");
			}
			default -> {
				System.err.println("Opção Inválida!");
			} 
			}
		} while (opcao != 0);
	}
	
	public static void clearConsole() {
		System.out.println("\n\n\n\n\n\n");
	}
}
