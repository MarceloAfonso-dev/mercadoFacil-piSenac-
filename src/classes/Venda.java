package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Venda {
	private String idVenda;
	private Date data;
	private Date hora;
	private double valorVenda;
	private String formaDePagamento;
	private int parcelas;
	private String observacoes;
	private String idVendedor;
	private String idCliente;
	
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	public Venda() {	}

	public Venda(String idVenda, Date data, Date hora, double valorVenda, String formaDePagamento, int parcelas,
			String observacoes, String idVendedor, String idCliente) {
		super();
		this.idVenda = idVenda;
		this.data = data;
		this.hora = hora;
		this.valorVenda = valorVenda;
		this.formaDePagamento = formaDePagamento;
		this.parcelas = parcelas;
		this.observacoes = observacoes;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

    @Override
    public String toString() {
        String dataFormatada = data != null ? dateFormat.format(data) : "N/A";
        String horaFormatada = hora != null ? timeFormat.format(hora) : "N/A";
        return "Venda [idVenda=" + idVenda + ", data=" + dataFormatada + ", hora=" + horaFormatada + ", valorVenda=" + valorVenda
                + ", formaDePagamento=" + formaDePagamento + ", parcelas=" + parcelas + ", observacoes=" + observacoes
                + ", idVendedor=" + idVendedor + ", idCliente=" + idCliente + "]";
    }
	
}
