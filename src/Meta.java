import java.time.LocalDate;

public class Meta {

	private String idMeta;
	private double valorMeta;
	private double bonificacao;
	private String idVendedor;
	private String idCaixa;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private double valorVendas;
	public String getIdMeta() {
		return idMeta;
	}
	public void setIdMeta(String idMeta) {
		this.idMeta = idMeta;
	}
	public double getValorMeta() {
		return valorMeta;
	}
	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}
	public double getBonificacao() {
		return bonificacao;
	}
	public void setBonificacao(double bonificacao) {
		this.bonificacao = bonificacao;
	}
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(String idCaixa) {
		this.idCaixa = idCaixa;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public double getValorVendas() {
		return valorVendas;
	}
	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}
}