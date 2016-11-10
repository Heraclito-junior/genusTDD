package NovasFuncionalidades;

import java.util.Date;

public class Faltas {
	
	int idFalta;
	int idFuncionario;
	Date dataFalta;
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public Date getDataFalta() {
		return dataFalta;
	}
	public void setDataFalta(Date dataFalta) {
		this.dataFalta = dataFalta;
	}
	
	public Faltas() {
		super();
	}
	public int getIdFalta() {
		return idFalta;
	}
	public void setIdFalta(int idFalta) {
		this.idFalta = idFalta;
	}
	public Faltas(int idFalta, int idFuncionario, Date dataFalta) {
		super();
		this.idFalta = idFalta;
		this.idFuncionario = idFuncionario;
		this.dataFalta = dataFalta;
	}
}
