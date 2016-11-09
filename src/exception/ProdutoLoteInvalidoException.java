package exception;



public class ProdutoLoteInvalidoException extends RuntimeException {

		public ProdutoLoteInvalidoException(){}
		
		
		public ProdutoLoteInvalidoException(String message)
		{
			super(message);
		}
}
