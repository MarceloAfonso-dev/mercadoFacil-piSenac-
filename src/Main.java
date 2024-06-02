import java.io.IOException;
import java.util.Scanner;

import gerenciadores.GerenciadorCliente;
import gerenciadores.GerenciadorCompra;
import gerenciadores.GerenciadorEmpresa;
import gerenciadores.GerenciadorFornecedor;
import gerenciadores.GerenciadorLogin;
import gerenciadores.GerenciadorMeta;
import gerenciadores.GerenciadorProduto;
import gerenciadores.GerenciadorUsuario;
import classes.Usuario;

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
        
        int opcao = 1;

        do {
            System.out.println("""
                    \nInsira a opção desejada
                    0. Encerrar Sistema
                    1. Fazer Login
                        """);
            opcao = leitor.nextInt();
            leitor.nextLine();
            switch (opcao) {
            case 1 -> {
                Usuario usuarioLogado = GerenciadorLogin.pegarLogin();
                if (usuarioLogado != null) {
                    String cargo = usuarioLogado.getCargo();
                    String idFuncionario = usuarioLogado.getIdFuncionario();
                    switch (cargo) {
                    case "Caixa" -> {
                        System.out.println("\nOlá caixa");
                        GerenciadorProduto.imprimirProdutos();
                        GerenciadorProduto.verificarQuantidadeProdutos();
                    }
                    case "Gerente" -> {
                        System.out.println("\nOlá gerente");
                        GerenciadorCliente.imprimirClientes();
                        GerenciadorCliente.cadastrarCliente();
                        GerenciadorCliente.imprimirClientes();
                        //GerenciadorMeta.imprimirMetasGerais();
                        //GerenciadorMeta.imprimirMetasPorIdFuncionario(idFuncionario);
                    }
                    case "Administrador" -> {
                        System.out.println("\nOlá administrador");
                        acoesAdministrador();
                    }
                    default -> {
                        System.err.println("\nUsuário Inválido\n");
                    }
                    }
                } else {
                    System.err.println("\nLogin inválido\n");
                }
            }
            case 0 -> {
                System.err.println("Encerrando Sistema...");
            }
            default -> {
                System.err.println("\nOpção Inválida!\n");
            }
            }
        } while (opcao != 0);
    }

    public static void acoesAdministrador() throws IOException {
        int opcao = 0;
        int opcaoInterna = 0;
        System.out.println("""
                \nEscolha qual item deseja acessar:
                0. Sair
                1. Usuário
                2. Compra
                3. Fornecedores
                4. Empresa
                """);
        do {
            opcao = leitor.nextInt();
            leitor.nextLine();
            switch (opcao) {
            case 1 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de usuários
                        2. Exibir todos os usuários
                        """);
                opcaoInterna = leitor.nextInt();
                leitor.nextLine();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorUsuario.verificarQuantidadeUsuarios();
                }
                case 2 -> {
                    GerenciadorUsuario.imprimirUsuarios();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 2 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de compras
                        2. Exibir todos os compras
                        """);
                opcaoInterna = leitor.nextInt();
                leitor.nextLine();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorCompra.verificarQuantidadeCompras();
                }
                case 2 -> {
                    GerenciadorCompra.imprimirCompras();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 3 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de forncedores
                        2. Exibir todos os fornecedores
                        """);
                opcaoInterna = leitor.nextInt();
                leitor.nextLine();
                switch (opcaoInterna) {
                case 1 -> {
                	GerenciadorFornecedor.verificarQuantidadeFornecedores();
                }
                case 2 -> {
                	GerenciadorFornecedor.imprimirFornecedores();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 4 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de empresas
                        2. Exibir todas as empresas
                        """);
                opcaoInterna = leitor.nextInt();
                leitor.nextLine();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorEmpresa.verificaEmpresa();
                }
                case 2 -> {
                    GerenciadorEmpresa.imprimirEmpresa();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 0 -> {
                System.err.println("\n\nVoltando ao menu principal...\n");
            }
            default -> {
                System.err.println("\nOpção Inválida!\n");
            }
            }
        } while (opcao != 0);
    }

    public static void clearConsole() {
    	System.out.println("\n\n\n\n\n");
    }
}
