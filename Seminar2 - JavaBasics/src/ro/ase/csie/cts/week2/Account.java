package ro.ase.csie.cts.week2;

public abstract class Account {
	public abstract double getBalance(); // the compiler needs to know if we want the method abstract or not, then it would need a body
	public abstract void deposit(double amount); // we will stuck the balance as a float...do we want it? better double
	// maybe BTC will be 0.00002, so not float
	// we cover all numeric types
	// if we really want to store anything, then object
	// need to check the type at runtine then
	
	public abstract void transfer(Account destination, double amount);
	public abstract void withdraw(double amount);
}
