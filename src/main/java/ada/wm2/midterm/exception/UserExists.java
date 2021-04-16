package ada.wm2.midterm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.CommunicationException;
@ResponseStatus(value = HttpStatus.FOUND)
public class UserExists extends RuntimeException {
    public UserExists() {
        super();
    }
    public UserExists(String message, Throwable cause) {
        super(message, cause);
    }
    public UserExists(String message) {
        super(message);
    }
    public UserExists(Throwable cause) {
        super(cause);
    }
}
