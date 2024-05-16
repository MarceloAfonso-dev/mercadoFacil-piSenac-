package classes;

import java.time.LocalDate;

public class Estoque {
	private String idProduto;
	private int quantidade;
	private int idLote;
	private LocalDate dataValidade;
	private LocalDate dataEntrada;
	private double custo;
	
	public Estoque() {
		
	}
	
	public Estoque(String idProduto, int quantidade, int idLote, LocalDate dataValidade, LocalDate dataEntrada,
			double custo) {
		super();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.idLote = idLote;
		this.dataValidade = dataValidade;
		this.dataEntrada = dataEntrada;
		this.custo = custo;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	
}
