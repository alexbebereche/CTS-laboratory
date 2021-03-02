package ro.ase.csie.cts.week2;

public abstract class BankAccount extends Account {
	
	protected double balance;
	protected final String iban; // should not be allowed to change IBAN
	
	public BankAccount(double balance, String iban) {
		// shadowing!
		this.balance = balance;
		this.iban = iban;
	}
}
