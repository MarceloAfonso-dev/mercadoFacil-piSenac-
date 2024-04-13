import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int opcao;

		System.out.println(
				"Informe a opção desejada \n\n1. Cadastrar Empresa\n2. Cadastrar Funcionario \n3. Cadastrar Cliente \n4. Sair");
		opcao = ler.nextInt();

		switch (opcao) {
		case 1, 2, 3 -> {

			String doc, nome;

			System.out.println("Informe o numero de identidade:");
			doc = ler.next();
			System.out.println("Informe o nome:");
			nome = ler.nextLine();

			System.out.println("Dados recebidos");
			System.out.println(nome + doc);

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