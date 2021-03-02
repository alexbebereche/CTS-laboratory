package ro.ase.csie.cts.week2.exceptions;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String message) {
		super(message); // can't do much with the class we inherit from, we pass super
		
	}
	
	// need to have a constr, don't have a def one
	public InsufficientFundsException(){
		
	}
}
