package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Oferta {
    private String idOferta;
    private Date dataCriacao;
    private Date dataFim;
    private int qtdeMinima;
    private double percentualDesconto;
    private String idProduto;
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public Oferta() { }

	public Oferta(String idOferta, Date dataCriacao, Date dataFim, int qtdeMinima, double percentualDesconto,
			String idProduto) {
		super();
		this.idOferta = idOferta;
		this.dataCriacao = dataCriacao;
		this.dataFim = dataFim;
		this.qtdeMinima = qtdeMinima;
		this.percentualDesconto = percentualDesconto;
		this.idProduto = idProduto;
	}

	public String getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getQtdeMinima() {
		return qtdeMinima;
	}

	public void setQtdeMinima(int qtdeMinima) {
		this.qtdeMinima = qtdeMinima;
	}

	public double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}


    @Override
    public String toString() {
        String dataCriacaoFormatada = dataCriacao != null ? dateFormat.format(dataCriacao) : "N/A";
        String dataFimFormatada = dataFim != null ? dateFormat.format(dataFim) : "N/A";
        return "Oferta [idOferta=" + idOferta + ", dataCriacao=" + dataCriacaoFormatada + ", dataFim=" + dataFimFormatada
                + ", qtdeMinima=" + qtdeMinima + ", percentualDesconto=" + percentualDesconto + ", idProduto="
                + idProduto + "]";
    }
    
}