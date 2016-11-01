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
public class Venda_Contem {

    public Venda_Contem(int IDvenda, int IDproduto, int quantidade) {
        this.IDvenda = IDvenda;
        this.IDproduto = IDproduto;
        this.quantidade = quantidade;
    }
    int IDvenda;
    int IDproduto;
    int quantidade;
}
