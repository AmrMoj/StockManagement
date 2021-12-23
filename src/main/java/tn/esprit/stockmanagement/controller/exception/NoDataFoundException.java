package tn.esprit.stockmanagement.controller.exception;

/**
 * @author AMR MOUJBANI-PC ON 22/12/2021
 * @project IntelliJ IDEA
 */
public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException() {

        super("No data found !");
    }
}
