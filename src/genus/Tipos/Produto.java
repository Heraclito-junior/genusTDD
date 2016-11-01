/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genus.Tipos;

/**
 *
 * @author junior
 */
public class Produto {

    public Produto() {
		super();
	}
	public Produto(int IDproduto, String nome, double quantidade, double preco, int IDCategoria) {
        this.IDproduto = IDproduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.IDCategoria = IDCategoria;
    }
    int IDproduto;
    String nome;
    double quantidade;
    double preco;
    int IDCategoria;
	public int getIDproduto() {
		return IDproduto;
	}
	public void setIDproduto(int iDproduto) {
		IDproduto = iDproduto;
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
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getIDCategoria() {
		return IDCategoria;
	}
	public void setIDCategoria(int iDCategoria) {
		IDCategoria = iDCategoria;
	}
	
	

}
