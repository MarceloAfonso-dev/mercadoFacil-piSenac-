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
    
    public static String pegarLogin() {
    	
        System.out.println("Digite seu login: ");
        String login = leitorInterno.nextLine();
        
        System.out.println("Digite sua senha: ");
        String senha = leitorInterno.nextLine();
        
        try {
            if (validarLogin(login, senha)) {
                System.out.println("Login bem-sucedido!");
                Date dataHoraAtual = new Date();
                GerenciadorLog.armazenaLog(GerenciadorLog.pegaLog(login, senha), dataHoraAtual);
                return validarCargo(login, senha);
            } else {
                System.out.println("Login ou senha incorretos!");
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao validar login.");
            return "";
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
    
    private static String validarCargo(String login, String senha) throws IOException {
        List<Usuario> listaUsuarios = GerenciadorUsuario.listarUsuarios();
        
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLoginUsuario().equals(login) && usuario.getSenhaUsuario().equals(senha)) {
                return usuario.getCargo(); // Retorna o cargo se login e senha são válidos
            }
        }
        return "inválido"; // Retorna "inválido" se login ou senha estão incorretos
    }
    
}