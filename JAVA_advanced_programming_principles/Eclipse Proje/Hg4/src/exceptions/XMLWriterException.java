package exceptions;
/**
 * Specialized WriterException which handles all XML writing exceptions.
 * @author Dan
 *
 */
public class XMLWriterException extends WriterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8028355850115881918L;

	public XMLWriterException() {
		// TODO Auto-generated constructor stub
	}

	public XMLWriterException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public XMLWriterException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public XMLWriterException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public XMLWriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
