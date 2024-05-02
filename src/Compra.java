import java.time.LocalDate;

public class Compra {
	private String idCompra;
	private String idProduto;
	private LocalDate dataSolicitacao;
	private double valorUnitario;
	private String tipoUnidade;
	private double valorTotal;
	private double qtdeTotal;
	private String idFornecedor;
	private LocalDate previsaoEntrega;
	
	public Compra() { }
	
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getTipoUnidade() {
		return tipoUnidade;
	}
	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getQtdeTotal() {
		return qtdeTotal;
	}
	public void setQtdeTotal(double qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}
	public String getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public LocalDate getPrevisaoEntrega() {
		return previsaoEntrega;
	}
	public void setPrevisaoEntrega(LocalDate previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}
}
