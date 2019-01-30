package exceptions;
/**
 * Specialized Writer Exception that handles JSON Writer exceptions.
 * @author Dan
 *
 */
public class JSONWriterException extends WriterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8450185952520396600L;

	public JSONWriterException() {
		// TODO Auto-generated constructor stub
	}

	public JSONWriterException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JSONWriterException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public JSONWriterException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JSONWriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
