import java.io.IOException;
import java.util.Scanner;

import gerenciadores.GerenciadorCliente;
import gerenciadores.GerenciadorCompra;
import gerenciadores.GerenciadorEmpresa;
import gerenciadores.GerenciadorEstoque;
import gerenciadores.GerenciadorFornecedor;
import gerenciadores.GerenciadorFuncionario;
import gerenciadores.GerenciadorLog;
import gerenciadores.GerenciadorLogin;
import gerenciadores.GerenciadorMeta;
import gerenciadores.GerenciadorOferta;
import gerenciadores.GerenciadorProduto;
import gerenciadores.GerenciadorUsuario;
import gerenciadores.GerenciadorVenda;
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
                        acoesCaixa(idFuncionario);
                    }
                    case "Gerente" -> {
                        System.out.println("\nOlá gerente");
                        acoesGerente();
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
        do {
        System.out.println("""
                \nEscolha qual item deseja acessar:
                0. Sair
                1. Usuário
                2. Compra
                3. Fornecedores
                4. Empresa
                5. Logs
                """);
            opcao = leitor.nextInt();
            switch (opcao) {
            case 1 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de usuários
                        2. Exibir todos os usuários
                        """);
                opcaoInterna = leitor.nextInt();
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
                        1. Editar dados da empresa
                        2. Exibir exibir dados da empresas
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorEmpresa.alterarDados();
                }
                case 2 -> {
                    GerenciadorEmpresa.imprimirEmpresa();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 5 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de logs
                        2. Exibir todos os logs
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorLog.verificarQuantidadeLogs();
                }
                case 2 -> {
                    GerenciadorLog.imprimirLogs();
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

    public static void acoesGerente() throws IOException {
    	int opcao = 0;
        int opcaoInterna = 0;
        do {
        System.out.println("""
                \nEscolha qual item deseja acessar:
                0. Sair
                1. Venda
                2. Produto
                3. Funcionarios
                4. Estoque
                5. Cliente
                6. Oferta
                7. Meta
                8. Compra
                9. Usuario
                """);
            opcao = leitor.nextInt();
            switch (opcao) {
            case 1 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de vendas
                        2. Exibir todos as vendas
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorVenda.verificarQuantidadeVendas();
                }
                case 2 -> {
                    GerenciadorVenda.imprimirVendas();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 2 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de produtos
                        2. Exibir todos os produtos
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorProduto.verificarQuantidadeProdutos();
                }
                case 2 -> {
                	GerenciadorProduto.imprimirProdutos();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 3 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de funcionarios
                        2. Exibir todos os funcionarios
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                	GerenciadorFuncionario.verificarQuantidadeFuncionarios();
                }
                case 2 -> {
                	GerenciadorFuncionario.imprimirFuncionarios();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 4 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de estoque
                        2. Exibir todos os estoques
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorEstoque.verificarQuantidadeEstoque();
                }
                case 2 -> {
                	GerenciadorEstoque.imprimirEstoque();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 5 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de clientes
                        2. Exibir todos os clientes
                        3. Cadastrar um cliente
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorCliente.verificarQuantidadeClientes();
                }
                case 2 -> {
                	GerenciadorCliente.imprimirClientes();
                }
                case 3 -> {
                	GerenciadorCliente.cadastrarCliente();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 6 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de ofertas
                        2. Exibir todos as ofertas
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorOferta.verificarQuantidadeOfertas();
                }
                case 2 -> {
                    GerenciadorOferta.imprimirOfertas();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 7 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de metas
                        2. Exibir todos as metas
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorMeta.verificarQuantidadeGeralMetas();
                }
                case 2 -> {
                    GerenciadorMeta.imprimirMetasGerais();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 8 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de compras
                        2. Exibir todos as compras
                        """);
                opcaoInterna = leitor.nextInt();
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
            case 9 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de usuarios
                        2. Exibir todos os usuarios
                        """);
                opcaoInterna = leitor.nextInt();
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
            case 0 -> {
                System.err.println("\n\nVoltando ao menu principal...\n");
            }
            default -> {
                System.err.println("\nOpção Inválida!\n");
            }
            }
        } while (opcao != 0);
    }
    
    public static void acoesCaixa(String idFuncionario) throws IOException {
        int opcao = 0;
        int opcaoInterna = 0;
        do {
        System.out.println("""
                \nEscolha qual item deseja acessar:
                0. Sair
                1. Cliente
                2. Venda
                3. Oferta
                4. Meta
                5. Produto
                """);
            opcao = leitor.nextInt();
            switch (opcao) {
            case 1 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Cadastrar cliente
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorCliente.cadastrarCliente();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 2 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Iniciar venda
                        2. Gerar cupom fiscal
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorVenda.criarVenda();
                }
                case 2 -> {
                    GerenciadorVenda.gerarCupomFiscal();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 3 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de ofertas
                        2. Exibir todas as ofertas
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                	GerenciadorOferta.verificarQuantidadeOfertas();
                }
                case 2 -> {
                	GerenciadorOferta.imprimirOfertas();
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 4 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar a quantidade de minhas metas
                        2. Exibir minhas metas
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorMeta.verificarQuantidadeMetasPorIdFuncionario(idFuncionario);
                }
                case 2 -> {
                	GerenciadorMeta.imprimirMetasPorIdFuncionario(idFuncionario);
                }
                default -> {
                    System.err.println("\nOpção Inválida!\n");
                }
                }
            }
            case 5 -> {
                System.out.println("""
                        \nSelecione a ação desejada:
                        1. Consultar quantidade de produtos
                        2. Exibir todos os produtos
                        """);
                opcaoInterna = leitor.nextInt();
                switch (opcaoInterna) {
                case 1 -> {
                    GerenciadorProduto.verificarQuantidadeProdutos();
                }
                case 2 -> {
                	GerenciadorProduto.imprimirProdutos();
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
