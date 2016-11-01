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
public class Fatura {

    public Fatura(int IDfatura, double valorFatura, String dataFatura, boolean statusFatura, int IDfornecedor) {
        this.IDfatura = IDfatura;
        this.valorFatura = valorFatura;
        this.dataFatura = dataFatura;
        this.statusFatura = statusFatura;
        this.IDfornecedor = IDfornecedor;
    }
    
    public Fatura(int IDfatura){
        this.IDfatura = IDfatura;
    }

    public int getIDfatura() {
        return IDfatura;
    }
    
    int IDfatura;
    double valorFatura;
    String dataFatura;
    boolean statusFatura;
    int IDfornecedor;
}
