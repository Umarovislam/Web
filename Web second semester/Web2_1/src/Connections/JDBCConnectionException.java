package Connections;

/**
 * JDBC exception
 */
public class JDBCConnectionException extends Exception{
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
    public JDBCConnectionException(String message, Exception e){
        super(message);
        exception = e;
    }

    /**
     * constructor
     * @param message message of exception
     */
    public JDBCConnectionException(String message){
        super(message);
    }
}
