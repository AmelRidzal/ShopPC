package ba.unsa.etf.rpr.exceptions;

public class EmailException extends Exception{

    public EmailException(String msg, Exception reason){
        super(msg, reason);
    }

    public EmailException(String msg){
        super(msg);
    }
}