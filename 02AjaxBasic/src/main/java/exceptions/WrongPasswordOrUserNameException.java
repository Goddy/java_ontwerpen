package exceptions;

/**
 * Created by u0090265 on 4/9/14.
 */
public class WrongPasswordOrUserNameException extends Exception {
    public WrongPasswordOrUserNameException(String message) {
        super(message);
    }
}
