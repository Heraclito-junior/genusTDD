package NovasFuncionalidades;

public class VendaContemPromocao {
	
	  public VendaContemPromocao(int IDvenda, int IDproduto, double quantidade,double precoNormal,double precoDesconto,int codigoPromocional) {
	        this.IDvenda = IDvenda;
	        this.IDproduto = IDproduto;
	        this.quantidade = quantidade;
	        this.precoNormal=precoNormal;
	        this.precoDesconto=precoDesconto;
	        this.codigoPromocional=codigoPromocional;
	    }
	    int IDvenda;
	    int IDproduto;
	    double quantidade;
	    int codigoPromocional;
	    double precoNormal;
	    double precoDesconto;
	    
	    public double getPrecoNormal() {
			return precoNormal;
		}
		public void setPrecoNormal(double precoNormal) {
			this.precoNormal = precoNormal;
		}
		public double getPrecoDesconto() {
			return precoDesconto;
		}
		public void setPrecoDesconto(double precoDesconto) {
			this.precoDesconto = precoDesconto;
		}
		
	    
		public int getIDvenda() {
			return IDvenda;
		}
		public void setIDvenda(int iDvenda) {
			IDvenda = iDvenda;
		}
		public int getIDproduto() {
			return IDproduto;
		}
		public void setIDproduto(int iDproduto) {
			IDproduto = iDproduto;
		}
		public double getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(double quantidade) {
			this.quantidade = quantidade;
		}
		public int getCodigoPromocional() {
			return codigoPromocional;
		}
		public void setCodigoPromocional(int codigoPromocional) {
			this.codigoPromocional = codigoPromocional;
		}
}
