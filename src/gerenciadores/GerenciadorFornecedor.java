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

import classes.Fornecedor;

public class GerenciadorFornecedor {

    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Fornecedor> listarFornecedores() throws IOException {
        List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetFornecedores = workbook.getSheetAt(4);

            Iterator<Row> rowIterator = sheetFornecedores.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Fornecedor fornecedor = new Fornecedor();
                listaFornecedores.add(fornecedor);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                    	fornecedor.setIdFornecedor(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        fornecedor.setNomeFornecedor(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        fornecedor.setTipoComercio(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 3:
                        fornecedor.setTelefone(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 4:
                        fornecedor.setEndereco(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 5:
                        fornecedor.setResponsavel(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 6:
                        fornecedor.setDocumento(String.valueOf(cell.getStringCellValue()));
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaFornecedores;
    }

    public static void verificarQuantidadeFornecedores() throws IOException {
        List<Fornecedor> listaFornecedores = listarFornecedores();
        
        if (listaFornecedores.size() == 0) {
            System.out.println("Nenhuma fornecedor encontrado!");
        } else {
            System.out.println("Número total de fornecedores: " + listaFornecedores.size());
        }
    }

    public static void imprimirFornecedores() throws IOException {
    	List<Fornecedor> listaFornecedores = listarFornecedores();
        
        for (Fornecedor fornecedor : listaFornecedores) {
            System.out.println(fornecedor.toString());
        }
    }
}
