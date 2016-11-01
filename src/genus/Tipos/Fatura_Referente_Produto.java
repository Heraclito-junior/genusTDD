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
public class Fatura_Referente_Produto {

    public Fatura_Referente_Produto(int IDproduto, int IDfatura, Double quantidade, double precoNaHora) {
        this.IDproduto = IDproduto;
        this.IDfatura = IDfatura;
        this.quantidade = quantidade;
        this.precoNaHora = precoNaHora;
    }
    int IDproduto;
    int IDfatura;
    Double quantidade;
    double precoNaHora;
}
