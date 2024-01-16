package abExceptions;

/**
 * InvalidArgumentException is thrown when a method is invoked and at least one
 * of the passed arguments does not meet the parameter specification of the
 * called method.
 */
public class InvalidArgumentException extends Exception {

	public InvalidArgumentException(String message) {
		super();
	}
}
