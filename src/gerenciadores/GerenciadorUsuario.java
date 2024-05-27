package gerenciadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.Usuario;

public class GerenciadorUsuario {
	
	static Scanner leitorInterno = new Scanner(System.in);
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Usuario> listarUsuarios() throws IOException {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetUsuarios = workbook.getSheetAt(12);

            Iterator<Row> rowIterator = sheetUsuarios.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Usuario usuario = new Usuario();
                listaUsuarios.add(usuario);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        usuario.setIdUsuario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        usuario.setNomeUsuario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        usuario.setEmailUsuario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 3:
                        usuario.setLoginUsuario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 4:
                        usuario.setSenhaUsuario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 5:
                        usuario.setSituacao(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 6:
                        usuario.setCargo(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 7:
                        usuario.setIdFuncionario(String.valueOf(cell.getStringCellValue()));
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaUsuarios;
    }

    public static void verificarQuantidadeUsuarios() throws IOException {
        List<Usuario> listaUsuarios = listarUsuarios();
        
        if (listaUsuarios.size() == 0) {
            System.out.println("Nenhum usuário encontrado!");
        } else {
            System.out.println("Número total de usuários: " + listaUsuarios.size());
        }
    }

    public static void imprimirUsuarios() throws IOException {
        List<Usuario> listaUsuarios = listarUsuarios();
        
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.toString());
        }
    }

    public static void main(String[] args) {
        try {
            verificarQuantidadeUsuarios();
            imprimirUsuarios();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
