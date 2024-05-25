package gerenciadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.Compra;

public class GerenciadorCompra {
	
    static String fileName = ExcelLocalizacao.getFilename();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static DataFormatter formatador = new DataFormatter();
    
    public static void verificarQuantidadeCompras() throws IOException {
    	   
        List<Compra> listaCompras = new ArrayList<Compra>();

        try {
               FileInputStream arquivo = new FileInputStream(new File(
                             GerenciadorProduto.fileName));

               XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

               XSSFSheet sheetCompras = workbook.getSheetAt(8);

               Iterator<Row> rowIterator = sheetCompras.iterator();
               
               while (rowIterator.hasNext()) {
                      Row row = rowIterator.next();
                      if (row.getRowNum() == 0) {
                          // Ignorar a primeira linha
                          continue;
                      }
                      Iterator<Cell> cellIterator = row.cellIterator();

                      Compra compra = new Compra();
                      listaCompras.add(compra);
                      while (cellIterator.hasNext()) {
                             Cell cell = cellIterator.next();
                             switch (cell.getColumnIndex()) {
                             case 0:
                             	compra.setIdCompra(String.valueOf(cell.getStringCellValue()));
                             	break;
                             case 1:
                                 compra.setIdProduto(String.valueOf(cell.getStringCellValue()));
                                 break;
                           case 2:
                           	Date dataSolicitacao = cell.getDateCellValue();
                           	compra.setDataSolicitacao(dataSolicitacao);
                                 break;
                           case 3:
                          	 compra.setValorUnitario(cell.getNumericCellValue());
                                 break;
                           case 4:
                          	 compra.setTipoUnidade(String.valueOf(cell.getStringCellValue()));
                                 break;
                           case 5:
                          	 compra.setValorTotal(cell.getNumericCellValue());
                                 break;
                           case 6:
                          	 compra.setQtdeTotal((int) cell.getNumericCellValue());
                          	   break;
                           case 7:
                          	 compra.setIdFornecedor(String.valueOf(cell.getStringCellValue()));
                          	   break;
                           case 8:
                           	Date dataEntrega = cell.getDateCellValue();
                          	compra.setPrevisaoEntrega(dataEntrega);
                          	   break;
                             }
                      }
               }
               arquivo.close();

        } catch (FileNotFoundException e) {
               e.printStackTrace();
               System.out.println("Arquivo Excel não encontrado!");
        }

        if (listaCompras.size() == 0) {
               System.out.println("Nenhum produto encontrado!");
        } else {
               
               System.out.println("Número total de produtos: " + listaCompras.size());
        }

  }
    
//    public static void editarCompra(String novoNome) throws IOException  {
//        try {
//            FileInputStream file = new FileInputStream(new File(GerenciadorProduto.fileName));
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            XSSFSheet sheetProdutos = workbook.getSheetAt(0);
//
//            // Alterar o nome do produto na primeira linha (ignorando o cabeçalho)
//            Row row = sheetProdutos.getRow(1); // A linha 1 é a segunda linha, pois a contagem começa do 0
//            Cell cellNome = row.getCell(1); // A coluna 1 é a segunda coluna, pois a contagem começa do 0
//            cellNome.setCellValue(novoNome);
//
//            file.close();
//
//            FileOutputStream outFile = new FileOutputStream(new File(GerenciadorProduto.fileName));
//            workbook.write(outFile);
//            outFile.close();
//            System.out.println("Nome do produto alterado com sucesso!");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Arquivo Excel não encontrado!");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Erro na edição do arquivo!");
//        }
//    }
    
    public static void imprimirCompras() throws IOException {
        try {
            FileInputStream arquivo = new FileInputStream(new File(GerenciadorProduto.fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetCompras = workbook.getSheetAt(8);

            Iterator<Row> rowIterator = sheetCompras.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Compra compra = new Compra();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                    	compra.setIdCompra(String.valueOf(cell.getStringCellValue()));
                    	break;
                    case 1:
                        compra.setIdProduto(String.valueOf(cell.getStringCellValue()));
                        break;
                  case 2:
                  	Date dataSolicitacao = cell.getDateCellValue();
                  	compra.setDataSolicitacao(dataSolicitacao);
                        break;
                  case 3:
                 	 compra.setValorUnitario(cell.getNumericCellValue());
                        break;
                  case 4:
                 	 compra.setTipoUnidade(String.valueOf(cell.getStringCellValue()));
                        break;
                  case 5:
                 	 compra.setValorTotal(cell.getNumericCellValue());
                        break;
                  case 6:
                 	 compra.setQtdeTotal((int) cell.getNumericCellValue());
                 	   break;
                  case 7:
                 	 compra.setIdFornecedor(String.valueOf(cell.getStringCellValue()));
                 	   break;
                  case 8:
                  	Date dataEntrega = cell.getDateCellValue();
                 	compra.setPrevisaoEntrega(dataEntrega);
                 	   break;
                  }
                }
                System.out.println(compra.toString()); // Imprime os detalhes do produto
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
    }


}
