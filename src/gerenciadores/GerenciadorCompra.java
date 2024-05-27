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

import classes.Compra;

public class GerenciadorCompra {

    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Compra> listarCompras() throws IOException {
        List<Compra> listaCompras = new ArrayList<Compra>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
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
        return listaCompras;
    }

    public static void verificarQuantidadeCompras() throws IOException {
        List<Compra> listaCompras = listarCompras();
        
        if (listaCompras.size() == 0) {
            System.out.println("Nenhuma compra encontrada!");
        } else {
            System.out.println("Número total de compras: " + listaCompras.size());
        }
    }

    public static void imprimirCompras() throws IOException {
        List<Compra> listaCompras = listarCompras();
        
        for (Compra compra : listaCompras) {
            System.out.println(compra.toString());
        }
    }

}
