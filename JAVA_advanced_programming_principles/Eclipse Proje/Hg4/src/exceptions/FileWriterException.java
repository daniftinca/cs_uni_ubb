package exceptions;
/**
 * Specialized Writer Exception that handles File Writer Exceptions.
 * @author Dan
 *
 */
public class FileWriterException extends WriterException {


	private static final long serialVersionUID = -3034213042594668699L;

	public FileWriterException() {
		// TODO Auto-generated constructor stub
	}

	public FileWriterException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileWriterException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public FileWriterException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileWriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
