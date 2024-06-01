package gerenciadores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.Usuario;

public class GerenciadorLogin {
    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static private Scanner leitorInterno = new Scanner(System.in);

    public static Usuario pegarLogin() throws IOException {
        System.out.println(GerenciadorEmpresa.pegaNome());
        System.out.println("Digite seu login: ");
        String login = leitorInterno.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = leitorInterno.nextLine();

        try {
            if (validarLogin(login, senha)) {
                System.out.println("Login bem-sucedido!");
                Date dataHoraAtual = new Date();
                GerenciadorLog.armazenaLog(GerenciadorLog.pegaLog(login, senha), dataHoraAtual);
                return obterUsuario(login, senha);
            } else {
                System.out.println("Login ou senha incorretos!");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao validar login.");
            return null;
        }
    }

    private static boolean validarLogin(String login, String senha) throws IOException {
        List<Usuario> listaUsuarios = GerenciadorUsuario.listarUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLoginUsuario().equals(login) && usuario.getSenhaUsuario().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    private static Usuario obterUsuario(String login, String senha) throws IOException {
        List<Usuario> listaUsuarios = GerenciadorUsuario.listarUsuarios();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLoginUsuario().equals(login) && usuario.getSenhaUsuario().equals(senha)) {
                return usuario; // Retorna o usuário se login e senha são válidos
            }
        }
        return null; // Retorna null se login ou senha estão incorretos
    }
}
