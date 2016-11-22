package NovasFuncionalidades;
import java.util.Date;
import java.util.List;

public class Lotes {
	
	
	int idLote;
	int idProduto;
	double quantidadeAtual;
	double quantidadeVendida;
	double quantidadeDesperdicada;
	double precoNaHora;
	
	Date dataInicioLote;
	Date dataFimLote;
	
	
	
	
	
	
	public Lotes(int idLote, int idProduto, double quantidadeAtual, double quantidadeVendida,
			double quantidadeDesperdicada,double preco, Date dataInicioLote, Date dataFimLote) {
		super();
		this.idLote = idLote;
		this.idProduto = idProduto;
		this.quantidadeAtual = quantidadeAtual;
		this.quantidadeVendida = quantidadeVendida;
		this.quantidadeDesperdicada = quantidadeDesperdicada;
		this.precoNaHora=preco;
		this.dataInicioLote = dataInicioLote;
		this.dataFimLote = dataFimLote;
	}
	
	public Lotes(Lotes novoLote) {
		super();
		this.idLote = novoLote.getIdLote();
		this.idProduto = novoLote.getIdProduto();
		this.quantidadeAtual = novoLote.getQuantidadeAtual();
		this.quantidadeVendida = novoLote.getQuantidadeVendida();
		this.quantidadeDesperdicada = novoLote.getQuantidadeDesperdicada();
		this.precoNaHora = novoLote.getPrecoNaHora();
		this.dataInicioLote = novoLote.getDataInicioLote();
		this.dataFimLote = novoLote.getDataFimLote();
	}
	
	
	public Lotes() {
		// TODO Auto-generated constructor stub
	}


	public int getIdLote() {
		return idLote;
	} 
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public double getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(double quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public double getQuantidadeDesperdicada() {
		return quantidadeDesperdicada;
	}
	public void setQuantidadeDesperdicada(double quantidadeDesperdicada) {
		this.quantidadeDesperdicada = quantidadeDesperdicada;
	}
	public Date getDataInicioLote() {
		return dataInicioLote;
	}
	public void setDataInicioLote(Date dataInicioLote) {
		this.dataInicioLote = dataInicioLote;
	}
	public Date getDataFimLote() {
		return dataFimLote;
	}
	public void setDataFimLote(Date dataFimLote) {
		this.dataFimLote = dataFimLote;
	}
	


	public double getQuantidadeAtual() {
		return quantidadeAtual;
	}


	public void setQuantidadeAtual(double quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public double getPrecoNaHora() {
		return precoNaHora;
	}

	public void setPrecoNaHora(double precoNaHora) {
		this.precoNaHora = precoNaHora;
	}
	
}
