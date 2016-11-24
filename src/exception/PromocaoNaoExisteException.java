package exception;

public class PromocaoNaoExisteException extends RuntimeException{
	
		public PromocaoNaoExisteException(){}
	
	
	public PromocaoNaoExisteException(String message)
	{
		super(message);
	}
}
