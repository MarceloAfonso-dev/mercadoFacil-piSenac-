package classes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meta {

	private String idMeta;
	private double valorMeta;
	private double bonificacao;
	private String idFuncionario;
	private String idCaixa;
	private Date dataInicio;
	private Date dataFinal;
	private double valorVendas;
	
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Meta() {	}
	
	public Meta(String idMeta, double valorMeta, double bonificacao, String idFuncionario, String idCaixa,
			Date dataInicio, Date dataFinal, double valorVendas) {
		super();
		this.idMeta = idMeta;
		this.valorMeta = valorMeta;
		this.bonificacao = bonificacao;
		this.idFuncionario = idFuncionario;
		this.idCaixa = idCaixa;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.valorVendas = valorVendas;
	}

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

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(String idCaixa) {
		this.idCaixa = idCaixa;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}

    @Override
    public String toString() {
        String dataInicioFormatada = dataInicio != null ? dateFormat.format(dataInicio) : "N/A";
        String dataFinalFormatada = dataFinal != null ? dateFormat.format(dataFinal) : "N/A";
        return "Meta [idMeta=" + idMeta + ", valorMeta=" + valorMeta + ", bonificacao=" + bonificacao
                + ", idFuncionario=" + idFuncionario + ", idCaixa=" + idCaixa + ", dataInicio=" + dataInicioFormatada
                + ", dataFinal=" + dataFinalFormatada + ", valorVendas=" + valorVendas + "]";
    }
	
}