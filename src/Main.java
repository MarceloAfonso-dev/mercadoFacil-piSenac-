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

			Empresa empresa1 = new Empresa();

			System.out.println("Informe o numero de identidade:");
			empresa1.setCnpj(ler.next());
			System.out.println("Informe o nome:");
			empresa1.setNome(ler.next());

			System.out.println("Dados recebidos");
			System.out.println(empresa1.getNome() +" "+empresa1.getCnpj());

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