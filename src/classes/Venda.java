package classes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Venda {
	private String idVenda;
	private LocalDate data;
	private LocalTime hora;
	private double valorVenda;
	private String formaDePagamento;
	private int parcelas;
	private String observacoes;
	private String idVendedor;
	private String idCliente;
	
	public Venda() {
		
	}

	public Venda(String idVenda, LocalDate data, LocalTime hora, double valorVenda, String formaDePagamento,
			int parcelas, String observacoes, String idVendedor, String idCliente) {
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
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
	
	
}
