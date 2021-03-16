package ro.ase.cts.g1092.refactor.phase4;

import ro.ase.cts.g1092.refactor.exceptions.InvalidValueException;

public class SalesStrategy {
	
	public static final int FIDELITY_YEARS_THRESHOLD = 10;
	public static final float MAX_FIDELITY_DISCOUNT = 0.15f; // java, strong-type language, 0.15 is seen as a double, f should be mentioned
//	public static final float NORMAL_DISCOUNT = 0.1f; // etc...not optimal, enum are classes
	
	public static float getFidelityDiscount(int yearsSinceRegistration) {
		return (yearsSinceRegistration > FIDELITY_YEARS_THRESHOLD) ? MAX_FIDELITY_DISCOUNT : (float)yearsSinceRegistration/100; 
	}
	
	public static float getPriceWithDiscount(
			float initialPrice, float discount, float fidelityDiscount) {
		
		float initialDiscount = initialPrice - (discount * initialPrice);
		return initialDiscount * (1 - fidelityDiscount);	
	}
	
	public float computeFinalPrice( // mixed camel case in java, don't forget
			ProductType productType, float initialPrice, int yearsSinceRegistration) throws InvalidValueException
	  {
		
		if(initialPrice <= 0 || yearsSinceRegistration < 0) {
			throw new InvalidValueException();
		}
		// dont need else, if exec, progr is term
		
		
		// in some cases, that's good, but now the expression is simple
		
//		if(yearsSinceRegistration < 0) {
//			throw new InvalidValueException();
//		}
		
	    float finalPrice = 0;
//	    float fidelityDiscount = getFidelityDiscount(yearsSinceRegistration);
	    float fidelityDiscount = 
	    		(productType != ProductType.NEW) ? getFidelityDiscount(yearsSinceRegistration) : 0;

	    finalPrice = getPriceWithDiscount(initialPrice, productType.getDiscount(), fidelityDiscount);
	    
	    
	    return finalPrice;
	  }
}