package gerenciadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import classes.Cliente;

public class GerenciadorCliente  {
	
	 static Scanner leitorInterno = new Scanner(System.in);
	 static String fileName = ExcelLocalizacao.getFilename();

	    public static List<Cliente> listarClientes() throws IOException {
	        List<Cliente> listaClientes = new ArrayList<Cliente>();

	        try {
	            FileInputStream arquivo = new FileInputStream(new File(fileName));
	            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
	            XSSFSheet sheetClientes = workbook.getSheetAt(7);

	            Iterator<Row> rowIterator = sheetClientes.iterator();
	            
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
                        	Date data = cell.getDateCellValue();
                        	cliente.setDataNascimento(data);
                            break;  
	                    }
	                }
	            }
	            arquivo.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Arquivo Excel não encontrado!");
	        }
	        return listaClientes;
	    }
	 
	    public static void verificarQuantidadeClientes() throws IOException {
	        List<Cliente> listaClientes = listarClientes();
	        
	        if (listaClientes.size() == 0) {
	            System.out.println("Nenhum cliente encontrado!");
	        } else {
	            System.out.println("Número total de clientes: " + listaClientes.size());
	        }
	    }

	    public static void imprimirClientes() throws IOException {
	    	List<Cliente> listaClientes = listarClientes();
	        
	        for (Cliente cliente : listaClientes) {
	            System.out.println(cliente.toString());
	        }
	    }
	    
	    public static void cadastrarCliente() throws IOException {
	    	Cliente novoCliente = new Cliente();
	    	System.out.println("Digite o ID do cliente:");
	    	String dado = leitorInterno.nextLine();
	    	novoCliente.setIdCliente(dado);
	    	System.out.println("Digite o nome do cliente:");
	    	dado = leitorInterno.nextLine();
	    	novoCliente.setNome(dado);
	    	System.out.println("Digite o CPF do cliente:");
	    	dado = leitorInterno.nextLine();
	    	novoCliente.setCpf(dado);
	    	System.out.println("Digite o CEP do cliente:");
	    	dado = leitorInterno.nextLine();
	    	novoCliente.setCep(dado);
	    	System.out.println("Digite o telefone do cliente:");
	    	dado = leitorInterno.nextLine();
	    	novoCliente.setTelefone(dado);
	    	System.out.println("Digite o dia de nascimento do cliente:");
	    	int dia = leitorInterno.nextInt();
	    	System.out.println("Digite o mês de nascimento do cliente:");
	    	int mes = leitorInterno.nextInt();
	    	System.out.println("Digite o ano de nascimento do cliente:");
	    	int ano = leitorInterno.nextInt();
	    	Date dataNascimento = criarData(dia,mes,ano);
	    	novoCliente.setDataNascimento(dataNascimento);
	    	
	    	armazenaCliente(novoCliente);
	    }
	    
	    private static Date criarData(int dia, int mes, int ano) {
	        // Construindo uma string no formato "dd/MM/yyyy"
	        String dataString = String.format("%02d/%02d/%04d", dia, mes, ano);

	        // Criando um objeto SimpleDateFormat para fazer a conversão
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	        // Tente analisar a string e criar um objeto Date
	        try {
	            return sdf.parse(dataString);
	        } catch (ParseException e) {
	            // Se ocorrer um erro na análise, imprima a exceção e retorne null
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    private static void armazenaCliente(Cliente novoCliente) throws IOException {
	        try {
	            FileInputStream arquivo = new FileInputStream(new File(fileName));
	            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
	            XSSFSheet sheetClientes = workbook.getSheetAt(7);

	            int lastRowNum = sheetClientes.getLastRowNum();
	            Row novaLinha = sheetClientes.createRow(lastRowNum + 1);

	            Cell cell0 = novaLinha.createCell(0);
	            cell0.setCellValue(novoCliente.getIdCliente());

	            Cell cell1 = novaLinha.createCell(1);
	            cell1.setCellValue(novoCliente.getNome());

	            Cell cell2 = novaLinha.createCell(2);
	            cell2.setCellValue(novoCliente.getCpf());

	            Cell cell3 = novaLinha.createCell(3);
	            cell3.setCellValue(novoCliente.getCep());

	            Cell cell4 = novaLinha.createCell(4);
	            cell4.setCellValue(novoCliente.getTelefone());

	            Cell cell5 = novaLinha.createCell(5);
	            cell5.setCellValue(novoCliente.getDataNascimento());

	            arquivo.close();

	            FileOutputStream outFile = new FileOutputStream(new File(fileName));
	            workbook.write(outFile);
	            outFile.close();

	            System.out.println("Cliente cadastrado com sucesso!");

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Arquivo Excel não encontrado!");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Erro ao manipular o arquivo Excel!");
	        }
	    }
}
