import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		Empresa empresa = new Empresa();
		
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