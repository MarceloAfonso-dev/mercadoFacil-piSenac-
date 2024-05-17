package gerenciadores;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.Cliente;

public class GerenciadorCliente {
	
	 static String fileName = ExcelLocalizacao.getFilename();
	 
	 public static void verificarQuantidadeCliente() throws IOException {
  	   
      List<Cliente> listaClientes = new ArrayList<Cliente>();
      
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

                 Cliente cliente = new Cliente();
                 listaClientes.add(cliente);
                 while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getColumnIndex()) {
                        case 0:
                              cliente.setIdCliente(String.valueOf(cell.getStringCellValue()));
                              break;
                        case 1:
                       	 	  cliente.setNome(String.valueOf(cell.getStringCellValue()));
                              break;
                        case 2:
                        	  cliente.setCpf(String.valueOf(cell.getStringCellValue()));
                              break;
                        case 3:
                       	 cliente.setCep(String.valueOf(cell.getStringCellValue()));
                              break;
                        case 4:
                       	 cliente.setTelefone(String.valueOf(cell.getStringCellValue()));
                              break;
                        case 5:
                          	 cliente.setDataNascimento(String.valueOf(cell.getStringCellValue()));
                                 break;     
                         
                        }
                 }
          }
          arquivo.close();

   } catch (FileNotFoundException e) {
          e.printStackTrace();
          System.out.println("Arquivo Excel não encontrado!");
   }

   if (listaClientes.size() == 0) {
          System.out.println("Nenhum produto encontrado!");
   } else {
          
          System.out.println("Número total de produtos: " + listaClientes.size());
   }
      
      
      
	 }
	 
}
