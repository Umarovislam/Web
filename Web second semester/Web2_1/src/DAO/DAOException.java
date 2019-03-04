package DAO;

/**
 * dao exception class
 */
public class DAOException extends Exception{
    Exception exception;
    int key;

    /**
     * get exception
     * @return exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * constructor for exception
     * @param message message of exception
     * @param e exception
     */
    public DAOException(String message, Exception e){
        super(message + e.toString());
        exception = e;
    }

    /**
     * constructor
     * @param message of exception
     */
    public DAOException(String message){
        super(message);
    }
}
