/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import genus.Tipos.Produto;

/**
 *
 * @author junior
 */
public class VendaModificada {
	
	
	List<Produto> listaDeProdutos=new ArrayList<Produto>();
	List<Double> QuantidadeDeProdutos=new ArrayList<Double>();
	List<Produto> estoque=new ArrayList<Produto>();
	
	



	int IDvenda;
    int IDvendedor;
    int IDcliente = 0;
    double ValorTotal;
    Date dataVenda;
	
	
	
	public VendaModificada() {
		
		
    }

    public VendaModificada(int IDvenda, int IDvendedor) {
    	
    	
    	
    	
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        ValorTotal = 0;
    }

    public VendaModificada(int IDvenda, int IDvendedor, double ValorTotal) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.ValorTotal = ValorTotal;
    }

    public VendaModificada(int IDvenda, int IDvendedor, int IDcliente, double ValorTotal) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.ValorTotal = ValorTotal;
        this.IDcliente = IDcliente;
    }
    
    public VendaModificada(int IDvenda, int IDvendedor, int IDcliente, double ValorTotal,Date novaData) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        
        this.ValorTotal = ValorTotal;
        this.IDcliente = IDcliente;
        this.dataVenda=novaData;
    }
    
    

    public int getIDvenda() {
        return IDvenda;
    }

    public void atualizaValorTotal(double valor){
        valor = Math.round(valor * 100.0) / 100.0;
        ValorTotal += valor;
    }
    
    public double getValorTotal() {
        ValorTotal = Math.round(ValorTotal * 100.0) / 100.0;
        return ValorTotal;
    }
    
   

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
    public List<Double> getQuantidadeDeProdutos() {
		return QuantidadeDeProdutos;
	}

	public void setQuantidadeDeProdutos(List<Double> quantidadeDeProdutos) {
		QuantidadeDeProdutos = quantidadeDeProdutos;
	}
	
	public void adicionarAVenda(Produto produtoParaVenda,double novaQuantidade){
		
		throw new UnsupportedOperationException();
		
		
	}


	public void removerDaVenda(Produto produtoParaTestarAdd, double quantidade) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizarVenda(int idVenda,int vendedor,int  cliente,Date data ) {
		// TODO Auto-generated method stub
		
	}

	public List<Produto> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Produto> estoque) {
		this.estoque = estoque;
	}

	

    
    
}
