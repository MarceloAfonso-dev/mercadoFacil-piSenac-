package gerenciadores;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.Produto;


public class GerenciadorProduto {

	static Scanner leitorInterno = new Scanner(System.in);
    static String fileName = ExcelLocalizacao.getFilename();

    public static void verificarQuantidadeProdutos() throws IOException {
    	   
        List<Produto> listaProdutos = new ArrayList<Produto>();

        try {
               FileInputStream arquivo = new FileInputStream(new File(
                             GerenciadorProduto.fileName));

               XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

               XSSFSheet sheetProdutos = workbook.getSheetAt(0);

               Iterator<Row> rowIterator = sheetProdutos.iterator();
               
               while (rowIterator.hasNext()) {
                      Row row = rowIterator.next();
                      if (row.getRowNum() == 0) {
                          // Ignorar a primeira linha
                          continue;
                      }
                      Iterator<Cell> cellIterator = row.cellIterator();

                      Produto produto = new Produto();
                      listaProdutos.add(produto);
                      while (cellIterator.hasNext()) {
                             Cell cell = cellIterator.next();
                             switch (cell.getColumnIndex()) {
                             case 0:
                                   produto.setIdProduto(String.valueOf(cell.getStringCellValue()));
                                   break;
                             case 1:
                            	 produto.setNome(String.valueOf(cell.getStringCellValue()));
                                   break;
                             case 2:
                            	 produto.setQuantidade((int) cell.getNumericCellValue());
                                   break;
                             case 3:
                            	 produto.setValor(cell.getNumericCellValue());
                                   break;
                             case 4:
                            	 produto.setDescricao(String.valueOf(cell.getStringCellValue()));
                                   break;
                             }
                      }
               }
               arquivo.close();

        } catch (FileNotFoundException e) {
               e.printStackTrace();
               System.out.println("Arquivo Excel não encontrado!");
        }

        if (listaProdutos.size() == 0) {
               System.out.println("Nenhum produto encontrado!");
        } else {
               
               System.out.println("Número total de produtos: " + listaProdutos.size());
        }

  }

    public static void imprimirProdutos() throws IOException {
        try {
            FileInputStream arquivo = new FileInputStream(new File(GerenciadorProduto.fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetProdutos = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheetProdutos.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Produto produto = new Produto();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            produto.setIdProduto(String.valueOf(cell.getStringCellValue()));
                            break;
                        case 1:
                            produto.setNome(String.valueOf(cell.getStringCellValue()));
                            break;
                        case 2:
                            produto.setQuantidade((int) cell.getNumericCellValue());
                            break;
                        case 3:
                            produto.setValor(cell.getNumericCellValue());
                            break;
                        case 4:
                            produto.setDescricao(String.valueOf(cell.getStringCellValue()));
                            break;
                    }
                }
                System.out.println(produto.toString()); // Imprime os detalhes do produto
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
    }


}
