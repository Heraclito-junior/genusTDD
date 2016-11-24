package exception;

public class PromocaoNaoExiste extends RuntimeException{
	
		public PromocaoNaoExiste(){}
	
	
	public PromocaoNaoExiste(String message)
	{
		super(message);
	}
}
