package ro.ase.csie.cts.week2.interest;

public interface Profitable {
	// we can have only static variables in interfaces
	// need to seal the value, don't want anyone to change it
	// final - it can't be inherited; for a method: can't be overriden
	// final - ct vars, sealed classes, stop overriding
	
	// by default, this static var is final in an interface
	public static final float MAX_INTEREST_PERCENT = 5; // ~ 5%
	public abstract void addInterest(float interestPercent);
	
	
}
