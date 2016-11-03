package NovasFuncionalidades;

public class VendaContemPromocao {
	
	  public VendaContemPromocao(int IDvenda, int IDproduto, double quantidade,int precoNormal,int precoDesconto,int codigoPromocional) {
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
	    int precoNormal;
	    int precoDesconto;
	    
	    public int getPrecoNormal() {
			return precoNormal;
		}
		public void setPrecoNormal(int precoNormal) {
			this.precoNormal = precoNormal;
		}
		public int getPrecoDesconto() {
			return precoDesconto;
		}
		public void setPrecoDesconto(int precoDesconto) {
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
