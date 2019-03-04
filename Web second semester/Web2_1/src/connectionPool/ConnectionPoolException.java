package connectionPool;

public class ConnectionPoolException extends Exception{
    Exception exception;

    /**
     * get exception
     * @return exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * constructor
     * @param message message of exception
     * @param e exception
     */
    public ConnectionPoolException(String message, Exception e){
        super(message+ " " +e.getMessage());
        exception = e;
    }

    /**
     * constructor
     * @param message message of exception
     */
    public ConnectionPoolException(String message){
        super(message);
    }
}
