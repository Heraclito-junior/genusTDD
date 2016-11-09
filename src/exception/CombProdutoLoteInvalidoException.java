package exception;

public class CombProdutoLoteInvalidoException extends RuntimeException {

	public CombProdutoLoteInvalidoException(){}
	
	
	public CombProdutoLoteInvalidoException(String message)
	{
		super(message);
	}
}