package ro.ase.csie.cts.week2;

public abstract class BankAccount extends Account {
	
	protected double balance;
	protected final String iban; // should not be allowed to change IBAN
	
	public BankAccount(double balance, String iban) {
		// shadowing!
		this.balance = balance;
		this.iban = iban;
	}
	// needed the constructor, else the final field would not have been intitialized

	
	// needs the same signature, use @Override to make sure
//	@Override
//	public double getBalance() {
//		return this.balance;
//	}
	
	// faster way: click2 -> source -> override/implement methods
	// alt + shift + s
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
//		return 0;
		
		return this.balance;
	}
	
}

