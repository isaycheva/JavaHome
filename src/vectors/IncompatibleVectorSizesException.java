package vectors;

public class IncompatibleVectorSizesException extends Exception {

    public IncompatibleVectorSizesException() {
        super();
    }

    public IncompatibleVectorSizesException(String message) {
        super(message);
    }

    public IncompatibleVectorSizesException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncompatibleVectorSizesException(Throwable cause) {
        super(cause);
    }
}
