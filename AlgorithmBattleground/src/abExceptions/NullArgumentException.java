package abExceptions;

/**
 * An NullArgumentException exception is thrown when a method is invoked and at
 * least one of the passed arguments is null but should never be null
 */
public class NullArgumentException extends Exception {
	public NullArgumentException() {
		super("Null Arguemnt Deteceted");
	}

}
