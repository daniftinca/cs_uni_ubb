package exceptions;
/**
 * Spcialized Reader Exception that handles JSON Reader exceptions.
 * @author Dan
 *
 */
public class JSONReaderException extends ReaderException {

	private static final long serialVersionUID = -1777410379866533237L;

	public JSONReaderException() {
		// TODO Auto-generated constructor stub
	}

	public JSONReaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public JSONReaderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JSONReaderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JSONReaderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
