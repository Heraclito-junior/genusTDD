package NovasFuncionalidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junior
 */
public class FuncionarioModificado {
	
		public FuncionarioModificado(String f_Nome, String f_Sobrenome,int fnc ,double f_Salario, String f_Telefone,
			String f_DataNascimento, String f_Endereco, String diasTrabalho, boolean status) {
		super();
		F_Nome = f_Nome;
		F_Sobrenome = f_Sobrenome;
		idFunc=fnc;
		F_Salario = f_Salario;
		F_Telefone = f_Telefone;
		F_DataNascimento = f_DataNascimento;
		F_Endereco = f_Endereco;
		DiasTrabalho = diasTrabalho;
		this.status = status;
	}

		String F_Nome;
	    String F_Sobrenome;
	    int idFunc;
	    public int getIdFunc() {
			return idFunc;
		}
		public void setIdFunc(int idFunc) {
			this.idFunc = idFunc;
		}

		double F_Salario;
	    String F_Telefone;
	    String F_DataNascimento;
	    String F_Endereco;
	    String DiasTrabalho;
	    

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
    public String getDiasTrabalho() {
		return DiasTrabalho;
	}
	public void setDiasTrabalho(String diasTrabalho) {
		DiasTrabalho = diasTrabalho;
	}

   
   
   
    
    
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    

    
}
