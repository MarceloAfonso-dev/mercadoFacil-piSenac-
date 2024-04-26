import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
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
		
		int opcao;
		
		System.out.println(
				"Informe a opção desejada \n\n1. Cadastrar Empresa\n2. Cadastrar Funcionario \n3. Cadastrar Cliente \n4. Sair");
		opcao = leitor.nextInt();

		switch (opcao) {
		case 1, 2, 3 -> {

//			System.out.println("Informe o numero de identidade:");
//			empresa1.setCnpj(leitor.next());
//			System.out.println("Informe o nome:");
//			empresa1.setNome(leitor.next());
//
//			System.out.println("Dados recebidos");
//			System.out.println(empresa1.getNome() +" "+empresa1.getCnpj());

		}

		default -> {

			if (opcao == 4) {
				System.out.println("Saindo");
			}

			else {
				System.out.println("Opção invalida, por favor selecione outra opção.");
			}

		}
		}
	}
}