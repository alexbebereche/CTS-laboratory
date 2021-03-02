package ro.ase.csie.cts.week2;

import ro.ase.csie.cts.week2.exceptions.IllegalTransferException;
import ro.ase.csie.cts.week2.exceptions.InsufficientFundsException;

public class CurrentAccount extends BankAccount {

	// else: right click -> source ->override/implement method
	
	public static final double MAX_CREDIT = 5000;
	
	public CurrentAccount(String IBAN) {
		super(CurrentAccount.MAX_CREDIT, IBAN); // calling the BankAccount
	}
	
	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void transfer(Account destination, double amount) throws IllegalTransferException, InsufficientFundsException {
		if(this == destination) {
			throw new IllegalTransferException();
		}
		this.withdraw(amount);
		destination.deposit(amount);
	}

	@Override
	public void withdraw(double amount) throws InsufficientFundsException {
			if(amount > this.balance) {
				throw new InsufficientFundsException("You don't have the amount");
			}else {
				this.balance -= amount;
				
				// managed/unmanaged exception
				// throw one, becomes managed
				
			}
		
	}
	
	// decision in BankAccount, forces us to give iban, so we need the constructor there
	// classic use of OOP
	
}
