package NovasFuncionalidades;

public class VendaContemPromocao {
	
	  public VendaContemPromocao(int IDvenda, int IDproduto, double quantidade,int codigoPromocional) {
	        this.IDvenda = IDvenda;
	        this.IDproduto = IDproduto;
	        this.quantidade = quantidade;
	        this.codigoPromocional=codigoPromocional;
	    }
	    int IDvenda;
	    int IDproduto;
	    double quantidade;
	    int codigoPromocional;
	    
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
