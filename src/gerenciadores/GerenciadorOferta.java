package gerenciadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import classes.Oferta;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerenciadorOferta {
	
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Oferta> listarOfertas() throws IOException {
        List<Oferta> listaOfertas = new ArrayList<Oferta>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetOfertas = workbook.getSheetAt(6);

            Iterator<Row> rowIterator = sheetOfertas.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Oferta oferta = new Oferta();
                listaOfertas.add(oferta);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        oferta.setIdOferta(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        oferta.setIdProduto(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        oferta.setPercentualDesconto(cell.getNumericCellValue());
                        break;
                    case 3:
                        oferta.setQtdeMinima((int)cell.getNumericCellValue());
                        break;
                    case 4:
                    	Date dataInicio = cell.getDateCellValue();
                        oferta.setDataCriacao(dataInicio);
                        break;
                    case 5:
                    	Date dataFim = cell.getDateCellValue();
                        oferta.setDataFim(dataFim);
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaOfertas;
    }

    public static void verificarQuantidadeOfertas() throws IOException {
        List<Oferta> listaOfertas = listarOfertas();
        
        if (listaOfertas.size() == 0) {
            System.out.println("Nenhuma oferta encontrada!");
        } else {
            System.out.println("Número total de ofertas: " + listaOfertas.size());
        }
    }

    public static void imprimirOfertas() throws IOException {
        List<Oferta> listaOfertas = listarOfertas();
        
        for (Oferta oferta : listaOfertas) {
            System.out.println(oferta.toString());
        }
    }

}
