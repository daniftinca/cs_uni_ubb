package exceptions;
/**
 * Specialized Reader Exception that handles File Reader Exceptions.
 * @author Dan
 *
 */
public class FileReaderExcepion extends ReaderException {


	private static final long serialVersionUID = 8543932945513095451L;

	public FileReaderExcepion() {
		// TODO Auto-generated constructor stub
	}

	public FileReaderExcepion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileReaderExcepion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileReaderExcepion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileReaderExcepion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
