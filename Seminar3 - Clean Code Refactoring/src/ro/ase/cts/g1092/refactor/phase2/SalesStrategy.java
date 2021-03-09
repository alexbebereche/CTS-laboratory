package ro.ase.cts.g1092.refactor.phase2;

import ro.ase.cts.g1092.refactor.exceptions.InvalidValueException;

public class SalesStrategy {
	
	public static final int FIDELITY_YEARS_THRESHOLD = 10;
	public static final float MAX_FIDELITY_DISCOUNT = 0.15f; // java, strong-type language, 0.15 is seen as a double, f should be mentioned
//	public static final float NORMAL_DISCOUNT = 0.1f; // etc...not optimal, enum are classes
	
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
	    float fidelityDiscount = (yearsSinceRegistration > FIDELITY_YEARS_THRESHOLD) ? MAX_FIDELITY_DISCOUNT : (float)yearsSinceRegistration/100; 
	   
	    switch(productType) {
	    case NEW:
	    	finalPrice = initialPrice;
	    	break;
	    	
	    case DISCOUNTED:
	    	finalPrice = (initialPrice - (ProductType.DISCOUNTED.getDiscount() * initialPrice)) - fidelityDiscount * (initialPrice - (ProductType.DISCOUNTED.getDiscount() * initialPrice));
	    	break;
			    
	    case LIMITED_STOCK:
	    	finalPrice = (initialPrice - (ProductType.LIMITED_STOCK.getDiscount() * initialPrice)) - fidelityDiscount * (initialPrice - (ProductType.LIMITED_STOCK.getDiscount() * initialPrice));
	    	break;
		      
	    case LEGACY:
		    finalPrice = (initialPrice - (ProductType.LEGACY.getDiscount() * initialPrice)) - fidelityDiscount * (initialPrice - (ProductType.LEGACY.getDiscount() * initialPrice));
		    break;
		default:
			throw new UnsupportedOperationException("Type not managed");
	    }
	    
	    return finalPrice;
	  }
}