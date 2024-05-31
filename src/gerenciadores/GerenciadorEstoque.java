package gerenciadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.Estoque;

public class GerenciadorEstoque {
	
	static Scanner leitorInterno = new Scanner(System.in);
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Estoque> listarEstoques() throws IOException {
        List<Estoque> listaEstoque = new ArrayList<Estoque>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetEstoques = workbook.getSheetAt(1);

            Iterator<Row> rowIterator = sheetEstoques.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Estoque estoque = new Estoque();
                listaEstoque.add(estoque);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        estoque.setIdProduto(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        estoque.setQuantidade(cell.getNumericCellValue());
                        break;
                    case 2:
                        estoque.setIdLote(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 3:
                    	Date validade = cell.getDateCellValue();
                        estoque.setDataValidade(validade);
                        break;
                    case 4:
                    	Date entrada = cell.getDateCellValue();
                        estoque.setDataEntrada(entrada);
                        break;
                    case 5:
                        estoque.setCusto(cell.getNumericCellValue());
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaEstoque;
    }

    public static void verificarQuantidadeEstoque() throws IOException {
        List<Estoque> listaEstoque = listarEstoques();
        
        if (listaEstoque.size() == 0) {
            System.out.println("Nenhum estoque encontrado!");
        } else {
            System.out.println("Número total de estoque: " + listaEstoque.size());
        }
    }

    public static void imprimirEstoque() throws IOException {
        List<Estoque> listaEstoque = listarEstoques();
        
        for (Estoque estoque : listaEstoque) {
            System.out.println(estoque.toString());
        }
    }
}
