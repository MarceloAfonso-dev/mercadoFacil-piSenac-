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
                boolean cellHasValue = false; // Flag para verificar se a célula não é nula
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setIdUsuario(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 1:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setNomeUsuario(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 2:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setEmailUsuario(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 3:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setLoginUsuario(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 4:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setSenhaUsuario(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 5:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setSituacao(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 6:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setCargo(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 7:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                usuario.setIdFuncionario(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                    }
                }
                // Adiciona o usuário apenas se pelo menos uma célula não for nula
                if (cellHasValue) {
                    listaUsuarios.add(usuario);
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
        
        int quantidadeUsuariosNaoNulos = 0;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() != null && !usuario.getIdUsuario().isEmpty()) {
                quantidadeUsuariosNaoNulos++;
            }
        }

        if (quantidadeUsuariosNaoNulos == 0) {
            System.out.println("Nenhum usuário encontrado!");
        } else {
            System.out.println("Número total de usuários: " + quantidadeUsuariosNaoNulos);
        }
    }

    public static void imprimirUsuarios() throws IOException {
        List<Usuario> listaUsuarios = listarUsuarios();
        
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() != null && !usuario.getIdUsuario().isEmpty()) {
                System.out.println(usuario.toString());
            }
        }
    }
}
