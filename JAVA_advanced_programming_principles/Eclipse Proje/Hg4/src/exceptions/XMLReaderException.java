package exceptions;
/**
 * Specialized ReaderException which handles all XML reading exceptions.
 * @author Dan
 *
 */
public class XMLReaderException extends ReaderException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2246927000040154636L;

	public XMLReaderException() {
		// TODO Auto-generated constructor stub
	}

	public XMLReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public XMLReaderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public XMLReaderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public XMLReaderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
