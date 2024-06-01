package classes;


public class Fornecedor {
	private String idFornecedor;
	private String nomeFornecedor;
	private String tipoComercio;
	private String telefone;
	private String endereco;
	private String responsavel;
	private String documento;
	
	public Fornecedor() {	}

	public Fornecedor(String idFornecedor, String nomeFornecedor, String tipoComercio, String telefone, String endereco,
			String responsavel, String documento) {
		super();
		this.idFornecedor = idFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.tipoComercio = tipoComercio;
		this.telefone = telefone;
		this.endereco = endereco;
		this.responsavel = responsavel;
		this.documento = documento;
	}

	public String getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getTipoComercio() {
		return tipoComercio;
	}

	public void setTipoComercio(String tipoComercio) {
		this.tipoComercio = tipoComercio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", tipoComercio="
				+ tipoComercio + ", telefone=" + telefone + ", endereco=" + endereco + ", responsavel=" + responsavel
				+ ", documento=" + documento + "]";
	}

}