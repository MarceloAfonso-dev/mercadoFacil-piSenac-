package classes;

import java.util.Date;

public class Estoque {
	private String idProduto;
	private double quantidade;
	private String idLote;
	private Date dataValidade;
	private Date dataEntrada;
	private double custo;
	
	public Estoque() {	}
	
	public Estoque(String idProduto, double quantidade, String idLote, Date dataValidade, Date dataEntrada,
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

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getIdLote() {
		return idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	@Override
	public String toString() {
		return "Estoque [idProduto=" + idProduto + ", quantidade=" + quantidade + ", idLote=" + idLote
				+ ", dataValidade=" + dataValidade + ", dataEntrada=" + dataEntrada + ", custo=" + custo + "]";
	}
	
}
