package utils;

/**
 * Basic exception to handle potentially bad monetary transactions more explicitly.
 */
public class InvalidAmountException extends Exception {
    public InvalidAmountException (String msg) {
        super(msg);
    }
}
