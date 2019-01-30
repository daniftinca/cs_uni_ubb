package exceptions;

/**
 * Specialized ReaderException that handles Deserializer Exceptions.
 * @author Dan
 *
 */
public class DeserializerException extends ReaderException {

	
	private static final long serialVersionUID = 6546277393945226602L;

	public DeserializerException() {
		// TODO Auto-generated constructor stub
	}

	public DeserializerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeserializerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DeserializerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeserializerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
