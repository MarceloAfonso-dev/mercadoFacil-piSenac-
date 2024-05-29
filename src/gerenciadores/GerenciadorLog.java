package gerenciadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.AcessoUsuario;
import classes.Usuario;

public class GerenciadorLog {
	
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<AcessoUsuario> listarLogs() throws IOException {
        List<AcessoUsuario> listaLogs = new ArrayList<AcessoUsuario>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetLogs = workbook.getSheetAt(13);

            Iterator<Row> rowIterator = sheetLogs.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                AcessoUsuario log = new AcessoUsuario();
                listaLogs.add(log);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        log.setIdUsuario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                    	Date login = cell.getDateCellValue();
                        log.setHorarioLogin(login);
                        break;
                    case 2:
                    	Date logoff = cell.getDateCellValue();
                        log.setHorarioLogoff(logoff);
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaLogs;
    }

    public static void verificarQuantidadeUsuarios() throws IOException {
        List<AcessoUsuario> listaLogs = listarLogs();
        
        if (listaLogs.size() == 0) {
            System.out.println("Nenhum usuário encontrado!");
        } else {
            System.out.println("Número total de usuários: " + listaLogs.size());
        }
    }

    public static void imprimirUsuarios() throws IOException {
        List<AcessoUsuario> listaLogs = listarLogs();
        
        for (AcessoUsuario logs : listaLogs) {
            System.out.println(logs.toString());
        }
    }

    public static String pegaLog(String login, String senha) throws IOException {
        List<Usuario> listaUsuarios = GerenciadorUsuario.listarUsuarios();
        
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLoginUsuario().equals(login) && usuario.getSenhaUsuario().equals(senha)) {
                return usuario.getIdUsuario(); // Retorna o id se login e senha são válidos
            }
        }
        return "inválido"; // Retorna "inválido" se login ou senha estão incorretos
    }
    
    public static boolean armazenaLog(String idLog, Date horarioLogin) {
    	//CHAMA OUTRO MÉTODO PARA ESCREVER AUTOMATICAMENTE O LOG NO EXCEL.
    	return true;
    }
}
