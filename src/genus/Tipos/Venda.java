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
public class Venda {

    public Venda(int IDvenda, int IDvendedor) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        ValorTotal = 0;
    }

    public Venda(int IDvenda, int IDvendedor, int IDPagamento, double ValorTotal) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.IDPagamento = IDPagamento;
        this.ValorTotal = ValorTotal;
    }

    public Venda(int IDvenda, int IDvendedor, int IDcliente, int IDPagamento, double ValorTotal) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.IDPagamento = IDPagamento;
        this.ValorTotal = ValorTotal;
        this.IDcliente = IDcliente;
    }
    
    int IDvenda;
    int IDvendedor;
    int IDcliente = 0;
    int IDPagamento;
    double ValorTotal;

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

    
    
}
