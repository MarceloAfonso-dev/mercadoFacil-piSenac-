package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {

	private String nome;
	private String cpf;
	private String cep;
	private String telefone;
	private String idCliente;
	private Date dataNascimento;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public Cliente() {	}

	public Cliente(String nome, String cpf, String cep, String telefone, String idCliente, Date dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.telefone = telefone;
		this.idCliente = idCliente;
		this.dataNascimento = dataNascimento;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

    @Override
    public String toString() {
        String dataNascimentoFormatada = dataNascimento != null ? dateFormat.format(dataNascimento) : "N/A";
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", cep=" + cep + ", telefone=" + telefone + ", idCliente="
                + idCliente + ", dataNascimento=" + dataNascimentoFormatada + "]";
    }
}
