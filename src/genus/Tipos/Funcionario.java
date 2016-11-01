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
public class Funcionario {
	
	String F_Nome;
	    String F_Sobrenome;
	    double F_Salario;
	    String F_Telefone;
	    String F_DataNascimento;
	    String F_Endereco;
	    
	    boolean status=true;
	
	
	
    public String getF_Nome() {
        return F_Nome;
    }
    public void setF_Nome(String F_Nome) {
        this.F_Nome = F_Nome;
    }
    public String getF_Sobrenome() {
        return F_Sobrenome;
    }
    public void setF_Sobrenome(String F_Sobrenome) {
        this.F_Sobrenome = F_Sobrenome;
    }
    public double getF_Salario() {
        return F_Salario;
    }
    public void setF_Salario(double F_Salario) {
        this.F_Salario = F_Salario;
    }
    public String getF_Telefone() {
        return F_Telefone;
    }
    public void setF_Telefone(String F_Telefone) {
        this.F_Telefone = F_Telefone;
    }
    public String getF_DataNascimento() {
        return F_DataNascimento;
    }
    public void setF_DataNascimento(String F_DataNascimento) {
        this.F_DataNascimento = F_DataNascimento;
    }
    public String getF_Endereco() {
        return F_Endereco;
    }
    public void setF_Endereco(String F_Endereco) {
        this.F_Endereco = F_Endereco;
    }
   
   
   
    
    
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    
     public Funcionario(String F_Nome, String F_Sobrenome, double F_Salario, String F_Telefone, String F_DataNascimento, String F_Endereco,boolean novoStatus) {
        this.F_Nome = F_Nome;
        this.F_Sobrenome = F_Sobrenome;
        this.F_Salario = F_Salario;
        this.F_Telefone = F_Telefone;
        this.F_DataNascimento = F_DataNascimento;
        this.F_Endereco = F_Endereco;
        status=novoStatus;
    }
    
}
