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

import classes.Venda;

public class GerenciadorVenda {
	
	static String fileName = ExcelLocalizacao.getFilename();

    public static List<Venda> listarVendas() throws IOException {
        List<Venda> listaVendas = new ArrayList<Venda>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetVendas = workbook.getSheetAt(2);

            Iterator<Row> rowIterator = sheetVendas.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Venda venda = new Venda();
                listaVendas.add(venda);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        venda.setIdVenda(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        Date data = cell.getDateCellValue();
                        venda.setData(data);
                        break;
                    case 2:
                    	venda.setHora(cell.getDateCellValue());
                        break;
                    case 3:
                        venda.setValorVenda(cell.getNumericCellValue());
                        break;
                    case 4:
                        venda.setFormaDePagamento(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 5:
                        venda.setParcelas((int) cell.getNumericCellValue());
                        break;
                    case 6:
                    	venda.setObservacoes(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 7:
                        venda.setIdVendedor(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 8:
                    	venda.setIdCliente(String.valueOf(cell.getStringCellValue()));
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaVendas;
    }

    public static void verificarQuantidadeVendas() throws IOException {
        List<Venda> listaVendas = listarVendas();
        
        if (listaVendas.size() == 0) {
            System.out.println("Nenhuma venda encontrada!");
        } else {
            System.out.println("Número total de vendas: " + listaVendas.size());
        }
    }

    public static void imprimirVendas() throws IOException {
        List<Venda> listaVendas = listarVendas();
        
        for (Venda venda : listaVendas) {
            System.out.println(venda.toString());
        }
    }
    
    public static void criarVenda() throws IOException {
    	System.out.println("Em desenvolvimento");
    }

    public static void gerarCupomFiscal() throws IOException {
    	System.out.println("Em desenvolvimento");
    }
}
