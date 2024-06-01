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

import classes.Meta;

public class GerenciadorMeta {
	static Scanner leitorInterno = new Scanner(System.in);
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Meta> listarMetas() throws IOException {
        List<Meta> listaMetas = new ArrayList<Meta>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetMetas = workbook.getSheetAt(5);

            Iterator<Row> rowIterator = sheetMetas.iterator();
            
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Meta meta = new Meta();
                listaMetas.add(meta);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                    case 0:
                        meta.setIdMeta(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                    	meta.setValorMeta(cell.getNumericCellValue());
                        break;
                    case 2:
                    	meta.setBonificacao(cell.getNumericCellValue());
                        break;
                    case 3:
                    	meta.setIdFuncionario(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 4:
                        meta.setIdCaixa(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 5:
                        Date dataInicio = cell.getDateCellValue();
                        meta.setDataInicio(dataInicio);
                        break;
                    case 6:
                        Date dataFinal = cell.getDateCellValue();
                        meta.setDataFinal(dataFinal);
                        break;
                    case 7:
                    	meta.setValorVendas(cell.getNumericCellValue());
                        break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaMetas;
    }

    public static void verificarQuantidadeGeralMetas() throws IOException {
        List<Meta> listaMeta = listarMetas();
        
        if (listaMeta.size() == 0) {
            System.out.println("Nenhuma meta encontrada!");
        } else {
            System.out.println("Número total de metas: " + listaMeta.size());
        }
    }

    public static void imprimirMetasGerais() throws IOException {
    	List<Meta> listaMeta = listarMetas();
        
        for (Meta meta : listaMeta) {
            System.out.println(meta.toString());
        }
    }
    
    public static List<Meta> listarMetasPorIdFuncionario(String idFuncionario) throws IOException {
        List<Meta> listaMetas = listarMetas();
        List<Meta> metasFuncionario = new ArrayList<>();

        for (Meta meta : listaMetas) {
            if (meta.getIdFuncionario().equals(idFuncionario)) {
                metasFuncionario.add(meta);
            }
        }

        return metasFuncionario;
    }

    public static void imprimirMetasPorIdFuncionario(String idFuncionario) throws IOException {
        List<Meta> metasFuncionario = listarMetasPorIdFuncionario(idFuncionario);

        if (metasFuncionario.isEmpty()) {
            System.out.println("Nenhuma meta encontrada para o funcionário com ID: " + idFuncionario);
        } else {
            for (Meta meta : metasFuncionario) {
                System.out.println(meta.toString());
            }
        }
    }
}
