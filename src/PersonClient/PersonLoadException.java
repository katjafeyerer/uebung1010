package PersonClient;

import java.io.FileNotFoundException;

public class PersonLoadException extends Throwable {


    public PersonLoadException() {
    }

    public PersonLoadException(String message) {
        super(message);
    }

    public PersonLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonLoadException(Throwable cause) {
        super(cause);
    }

    public PersonLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
