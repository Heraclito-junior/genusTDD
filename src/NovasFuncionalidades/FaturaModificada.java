/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

import java.util.Date;

/**
 *
 * @author junior
 */
public class FaturaModificada {

    public FaturaModificada(int IDfatura, double valorFatura, Date dataFatura, boolean statusFatura, int IDfornecedor) {
        this.IDfatura = IDfatura;
        this.valorFatura = valorFatura;
        this.dataFatura = dataFatura;
        this.statusFatura = statusFatura;
        this.IDfornecedor = IDfornecedor;
    }
    
    public FaturaModificada(int IDfatura){
        this.IDfatura = IDfatura;
    }

    public int getIDfatura() {
        return IDfatura;
    }
    
    int IDfatura;
    double valorFatura;
    Date dataFatura;
    boolean statusFatura;
    int IDfornecedor;
    
	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}

	public Date getDataFatura() {
		return dataFatura;
	}

	public void setDataFatura(Date dataFatura) {
		this.dataFatura = dataFatura;
	}

	public boolean isStatusFatura() {
		return statusFatura;
	}

	public void setStatusFatura(boolean statusFatura) {
		this.statusFatura = statusFatura;
	}

	public int getIDfornecedor() {
		return IDfornecedor;
	}

	public void setIDfornecedor(int iDfornecedor) {
		IDfornecedor = iDfornecedor;
	}

	public void setIDfatura(int iDfatura) {
		IDfatura = iDfatura;
	}
    
}
