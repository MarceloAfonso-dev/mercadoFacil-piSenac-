package classes;

public class VendaItem {
	private String idItemVenda;
	private String idVenda;
	private String idProduto;
	private int quantidade;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorItem() {
		return valorItem;
	}

	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
	
	
}
