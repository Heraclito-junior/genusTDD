/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

/**
 *
 * @author junior
 */
public class Desconto {

    public Desconto(int IDdesconto,int IDProduto, double porcentagem, String descricao) {
        this.IDdesconto = IDdesconto;
        this.IDProduto=IDProduto;
        this.porcentagem = porcentagem;
        this.descricao = descricao;
    }
    int IDdesconto;
    int IDProduto;
    double porcentagem;
    String descricao;
    
    
	public int getIDdesconto() {
		return IDdesconto;
	}
	public void setIDdesconto(int iDdesconto) {
		IDdesconto = iDdesconto;
	}
	public int getIDProduto() {
		return IDProduto;
	}
	public void setIDProduto(int iDProduto) {
		IDProduto = iDProduto;
	}
	public double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
