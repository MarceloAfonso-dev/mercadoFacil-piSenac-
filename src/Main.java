

import java.io.IOException;
import java.util.Scanner;

import classes.Empresa;
import gerenciadores.GerenciadorProduto;

public class Main {
	static Scanner leitor = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		Empresa empresa = new Empresa();
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
		
		if (!empresa.isCadastrado()) {
			System.out.println("Seja bem vindo!\nInsira o nome e CNPJ da empresa:");
			String nome = leitor.nextLine();
			String cnpj = leitor.next();
			empresa.cadastrarEmpresa(nome, cnpj);
		}
		clearConsole();
		System.out.printf("""
				%s
				Seja bem vindo! Selecione o usuario:
				1. Caixa
				2. Gerente
				3. Administrador
				""",empresa.getNome());
		int opcao = leitor.nextInt();
		clearConsole();
		
		switch (opcao) {
		case 1 -> {
			System.out.println("Olá caixa");
//			GerenciadorProduto.editarProduto("Cola");
			GerenciadorProduto.imprimirProdutos();
			GerenciadorProduto.verificarQuantidadeProdutos();
		}
		case 2 -> {
			System.out.println("Olá gerente");
		}
		case 3 -> {
			System.out.println("Olá administrador");
		}
		default -> {

			if (opcao == 4) {
				System.out.println("Encerrando sistema...");
			}

			else {
				System.err.println("Opção invalida, por favor selecione outra opção.");
			}

		}
		}
	}
	
	public static void clearConsole() {
		System.out.println("\n\n\n\n\n\n");
	}
}