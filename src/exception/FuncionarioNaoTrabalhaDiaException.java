package exception;

public class FuncionarioNaoTrabalhaDiaException extends RuntimeException {

	public FuncionarioNaoTrabalhaDiaException(){}
	
	
	public FuncionarioNaoTrabalhaDiaException(String message)
	{
		super(message);
	}
}