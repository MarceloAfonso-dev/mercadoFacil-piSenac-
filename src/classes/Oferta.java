package classes;
import java.time.LocalDate;

public class Oferta {
    private int idOferta;
    private LocalDate dataCriacao;
    private LocalDate dataFim;
    private double precoAntigo;
    private double valorPromocional;
    private int qtdeMinima;
    private double percentualDesconto;
    private int idProduto;
    
    public Oferta(int idOferta, LocalDate dataCriacao, LocalDate dataFim, double precoAntigo,
                  double valorPromocional, int qtdeMinima, double percentualDesconto, int idProduto) {
        this.idOferta = idOferta;
        this.dataCriacao = dataCriacao;
        this.dataFim = dataFim;
        this.precoAntigo = precoAntigo;
        this.valorPromocional = valorPromocional;
        this.qtdeMinima = qtdeMinima;
        this.percentualDesconto = percentualDesconto;
        this.idProduto = idProduto;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public double getPrecoAntigo() {
        return precoAntigo;
    }

    public double getValorPromocional() {
        return valorPromocional;
    }

    public int getQtdeMinima() {
        return qtdeMinima;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public int getIdProduto() {
        return idProduto;
    }

}
