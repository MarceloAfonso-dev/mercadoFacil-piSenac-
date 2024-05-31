

import java.io.IOException;
import java.util.Scanner;

import classes.Empresa;
import gerenciadores.GerenciadorCompra;
import gerenciadores.GerenciadorFuncionario;
import gerenciadores.GerenciadorLogin;
import gerenciadores.GerenciadorOferta;
import gerenciadores.GerenciadorProduto;
import gerenciadores.GerenciadorUsuario;

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
				Seja bem vindo! Digite seu usuário e senha
				""",empresa.getNome());
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
		GerenciadorFuncionario.imprimirFuncionarios();
		GerenciadorFuncionario.verificarQuantidadeFuncionarios();
		
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
			System.out.println("Olá administrador");
			GerenciadorUsuario.imprimirUsuarios();
			GerenciadorUsuario.verificarQuantidadeUsuarios();
		}
		default -> {
			System.err.println("Encerrando Sistema!");
		}
		}
	}
	
	public static void clearConsole() {
		System.out.println("\n\n\n\n\n\n");
	}
}