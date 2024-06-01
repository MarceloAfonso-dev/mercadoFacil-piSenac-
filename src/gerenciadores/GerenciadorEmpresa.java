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

import classes.Empresa;

public class GerenciadorEmpresa {
	static Empresa empresa = new Empresa();
	static Scanner leitorInterno = new Scanner(System.in);
    static String fileName = ExcelLocalizacao.getFilename();

    public static List<Empresa> listarEmpresa() throws IOException {
        List<Empresa> listaEmpresa = new ArrayList<Empresa>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetEmpresa = workbook.getSheetAt(9);

            Iterator<Row> rowIterator = sheetEmpresa.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    // Ignorar a primeira linha
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();

                Empresa empresa = new Empresa();
                boolean cellHasValue = false; // Flag para verificar se a célula não é nula
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                empresa.setNome(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 1:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                empresa.setCnpj(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 2:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                empresa.setEndereco(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                        case 3:
                            if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                                empresa.setTelefone(String.valueOf(cell.getStringCellValue()));
                                cellHasValue = true;
                            }
                            break;
                    }
                }
                // Adiciona o usuário apenas se pelo menos uma célula não for nula
                if (cellHasValue) {
                	listaEmpresa.add(empresa);
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }
        return listaEmpresa;
    }
    
    public static void imprimirEmpresa() throws IOException {
        List<Empresa> listaEmpresa = listarEmpresa();
        
        for (Empresa empresa : listaEmpresa) {
            System.out.println(empresa.toString());
        }
    }
    
    public static void verificaEmpresa() throws IOException {
        List<Empresa> listaEmpresa = listarEmpresa();
        
        for (Empresa empresa : listaEmpresa) {
            if (empresa.getNome() != null && !empresa.getNome().isEmpty()) {
                empresa.setCadastrado(true);
            }
        }
        
        if (listaEmpresa.isEmpty()) {
        	alterarDados();
        }
    }

    public static void alterarDados() {
    	System.out.println("Seja bem vindo!\nInsira o nome e CNPJ da empresa:");
    	String nome = leitorInterno.nextLine();
    	String cnpj = leitorInterno.nextLine();
    	System.out.println("Agora digite seu endereco e telefone");
    	String endereco = leitorInterno.nextLine();
    	String telefone = leitorInterno.nextLine();
    	
    	armazenaEmpresa(nome, cnpj, endereco, telefone);
    }
    
    private static void armazenaEmpresa(String nome, String cnpj, String endereco, String telefone) {
        FileInputStream arquivo = null;
        FileOutputStream outFile = null;
        XSSFWorkbook workbook = null;

        try {
            // Abrir o arquivo Excel
            arquivo = new FileInputStream(new File(fileName));
            workbook = new XSSFWorkbook(arquivo);
            XSSFSheet sheetLogs = workbook.getSheetAt(9);

            Row linha = sheetLogs.createRow(1);

            // Escrever os dados na nova linha
            Cell cellNome = linha.createCell(0);
            cellNome.setCellValue(nome);

            Cell cellCnpj = linha.createCell(1);
            cellCnpj.setCellValue(cnpj);
            
            Cell cellEndereco = linha.createCell(2);
            cellEndereco.setCellValue(endereco);
            
            Cell cellTelefone = linha.createCell(3);
            cellTelefone.setCellValue(telefone);

            // Fechar o FileInputStream
            arquivo.close();

            // Salvar as mudanças
            outFile = new FileOutputStream(new File(fileName));
            workbook.write(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao escrever no arquivo Excel!");
        } finally {
            try {
                if (arquivo != null) {
                    arquivo.close();
                }
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static String pegaNome() throws IOException {
        List<Empresa> listaEmpresa = listarEmpresa();
        
        for (Empresa empresa : listaEmpresa) {   
                return empresa.getNome();
        }
		return "";
    }
}
