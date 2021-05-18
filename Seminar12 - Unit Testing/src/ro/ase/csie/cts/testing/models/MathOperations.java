package ro.ase.csie.cts.testing.models;

import ro.ase.csie.cts.testing.exceptions.DivisionByZeroException;

public class MathOperations {

	//one of the worst methods to implement
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static double divide(int a, int b) throws DivisionByZeroException {
		if(b == 0) {
			throw new DivisionByZeroException();
		}
		return a / b; // in java, if divide by 0, not get a runtime exception, get Nan; gonna get a runtime exception when using Nan
	}
}
