package classes;

public class VendaItem {
	private String idItemVenda;
	private String idVenda;
	private String idProduto;
	private double quantidade;
	private double valorItem;
	
	public VendaItem() {
		
	}

	public VendaItem(String idItemVenda, String idVenda, String idProduto, int quantidade, double valorItem) {
		super();
		this.idItemVenda = idItemVenda;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.valorItem = valorItem;
	}

	public String getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(String idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
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

	public double getValorItem() {
		return valorItem;
	}

	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}

	@Override
	public String toString() {
		return "VendaItem [idItemVenda=" + idItemVenda + ", idVenda=" + idVenda + ", idProduto=" + idProduto
				+ ", quantidade=" + quantidade + ", valorItem=" + valorItem + "]";
	}
	
}
