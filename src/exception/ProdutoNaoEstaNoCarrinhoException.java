package exception;

public class ProdutoNaoEstaNoCarrinhoException extends RuntimeException {

		public ProdutoNaoEstaNoCarrinhoException(){}
		
		
		public ProdutoNaoEstaNoCarrinhoException(String message)
		{
			super(message);
		}
}
