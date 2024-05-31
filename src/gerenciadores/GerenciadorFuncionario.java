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

import classes.Funcionario;

public class GerenciadorFuncionario {
	
	static Scanner leitorInterno = new Scanner(System.in);
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Funcionario> listarFuncionarios() throws IOException {
        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetFuncionario = workbook.getSheetAt(11);

            Iterator<Row> rowIterator = sheetFuncionario.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Funcionario funcionario = new Funcionario();
                listaFuncionarios.add(funcionario);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        funcionario.setIdFuncionario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        funcionario.setNome(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        funcionario.setCpf(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 3:
                        funcionario.setSalario(cell.getNumericCellValue());
                        break;
                    case 4:
                        funcionario.setCargoSetor(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 5:
                        funcionario.setSituacao(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 6:
                        funcionario.setEmail(String.valueOf(cell.getStringCellValue()));
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaFuncionarios;
    }

    public static void verificarQuantidadeFuncionarios() throws IOException {
        List<Funcionario> listaFuncionarios = listarFuncionarios();
        
        if (listaFuncionarios.size() == 0) {
            System.out.println("Nenhum produto encontrado!");
        } else {
            System.out.println("Número total de produtos: " + listaFuncionarios.size());
        }
    }

    public static void imprimirFuncionarios() throws IOException {
        List<Funcionario> listaFuncionarios = listarFuncionarios();
        
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario.toString());
        }
    }

}
