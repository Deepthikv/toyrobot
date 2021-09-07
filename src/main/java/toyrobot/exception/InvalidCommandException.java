package toyrobot.exception;

/**
 * Invalid command exception is throws if the commands are not properly
 * requested.
 * 
 * @author Deepthi
 *
 */
public class InvalidCommandException extends Exception {	
	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidCommandException(String message) {
		super(message);
	}	

}
