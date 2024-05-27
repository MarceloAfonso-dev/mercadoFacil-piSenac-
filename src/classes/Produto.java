package classes;


public class Produto {
	private String idProduto;
    private String nome;
    private String codigoDeBarras;
    private double valor;
    private String categoria;
    private String descricao;
    
    public Produto() { }
    
	public Produto(String idProduto, String nome, String codigoDeBarras, double valor, String categoria,
			String descricao) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.codigoDeBarras = codigoDeBarras;
		this.valor = valor;
		this.categoria = categoria;
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

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", codigoDeBarras=" + codigoDeBarras + ", valor="
				+ valor + ", categoria=" + categoria + ", descricao=" + descricao + "]";
	}
	
    }