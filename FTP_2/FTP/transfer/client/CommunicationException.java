package transfer.client;

public class CommunicationException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Communication failed.";
	
	public CommunicationException() {
		super(MESSAGE);
	}

	public CommunicationException(String message) {
		super(message);
	}

	public CommunicationException(Throwable cause) {
		super(MESSAGE, cause);
	}

	public CommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
