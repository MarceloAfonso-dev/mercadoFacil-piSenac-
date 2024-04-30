

public class Empresa {
    private String nome;
    private String cnpj;
    private boolean cadastrado;
    
    public Empresa() {
    	this.cadastrado = false;
    }

    public void cadastrarEmpresa(String nome, String cnpj) {
    	this.nome = nome;
    	this.cnpj = cnpj;
    	this.cadastrado = true;
    }
    
    public boolean isCadastrado() {
    	return cadastrado;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
    
    
}
