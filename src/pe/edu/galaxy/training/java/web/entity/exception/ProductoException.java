package pe.edu.galaxy.training.java.web.entity.exception;

public class ProductoException extends Exception{

	private static final long serialVersionUID = 7761094474228364109L;
			
	public ProductoException() {
		
	}

	public ProductoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

	public ProductoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ProductoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


}
