package DAO;

public class DaoException extends Exception{
    Exception exception;

    public Exception getException(){
        return exception;
    }
    public DaoException(String message, Exception e){
        super(message);
        exception = e;
    }
    public DaoException(String message){
        super(message);
    }
}
