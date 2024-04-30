

public class Produto {
	private String idProduto;
    private String nome;
    private int quantidade;
    private double valor;
    private String descricao;
    
    public Produto() { }
    
    public Produto(String idProduto, String nome, int quantidade, double valor, String descricao) {
    	super();
    	this.idProduto = idProduto;
    	this.nome = nome;
    	this.quantidade = quantidade;
    	this.valor = valor;
    	this.descricao = descricao;
    }
    
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "[id Produto = " + idProduto + ", nome = " + nome + ", quantidade = " + quantidade + ", valor = " + valor
				+ ", descricao = " + descricao + "]";
	}
   
	
    }

