package exception;

public class QuantidadeInsuficienteException extends RuntimeException {

		public QuantidadeInsuficienteException(){}
		
		
		public QuantidadeInsuficienteException(String message)
		{
			super(message);
		}
}
