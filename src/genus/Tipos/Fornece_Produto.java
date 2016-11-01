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
public class Fornece_Produto {

    public Fornece_Produto(int IDfornecedor, int IDproduto, double preco) {
        this.IDfornecedor = IDfornecedor;
        this.IDproduto = IDproduto;
        this.preco = preco;
    }
    int IDfornecedor;
    int IDproduto;
    double preco;
    
}
