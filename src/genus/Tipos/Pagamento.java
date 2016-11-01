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
public class Pagamento {

    public Pagamento(int IDpagamento, double totalPago, String modoPagamento, int IDDdesconto) {
        this.IDpagamento = IDpagamento;
        this.totalPago = totalPago;
        this.modoPagamento = modoPagamento;
        this.IDDdesconto = IDDdesconto;
    }
    int IDpagamento;
    double totalPago;
    String modoPagamento;
    int IDDdesconto;
}
