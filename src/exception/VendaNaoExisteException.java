package exception;

public class VendaNaoExisteException extends RuntimeException {

		public VendaNaoExisteException(){}
		
		
		public VendaNaoExisteException(String message)
		{
			super(message);
		}
}
