package ro.ase.cts.g1092.refactor.phase5;

import ro.ase.cts.g1092.refactor.exceptions.InvalidPriceException;
import ro.ase.cts.g1092.refactor.exceptions.InvalidValueException;
import ro.ase.cts.g1092.refactor.exceptions.InvalidYearsSinceRegistrationException;
import ro.ase.cts.g1092.refactor.phase5.marketing.MarketingStrategyInterface;

public class SalesStrategy {
	
	private MarketingStrategyInterface mkStrategy = null;
	private SalesValidatorsInterface validator = null;
	
	// we ask for the objects
	public SalesStrategy(MarketingStrategyInterface mkStrategy, 
			SalesValidatorsInterface validator) {
		
		// make sure is not null
		if(mkStrategy == null || validator == null) {
			throw new NullPointerException();
		}
		this.mkStrategy = mkStrategy;
		this.validator = validator;
	}
	
	// optional - depends on your design specs
	// allowing the change at runtime of marketing strategy
	public void setMarketingStrategy(MarketingStrategyInterface mkStrategy) {
		if(mkStrategy == null) {
			throw new NullPointerException();
		}
		this.mkStrategy = mkStrategy;
	}
	
	public static float getPriceWithDiscount(
			float initialPrice, float discount, float fidelityDiscount) {
		
		float initialDiscount = initialPrice - (discount * initialPrice);
		return initialDiscount * (1 - fidelityDiscount);	
	}
	
	public float computeFinalPrice( // mixed camel case in java, don't forget
			ProductType productType, float initialPrice, int yearsSinceRegistration) throws InvalidValueException, InvalidYearsSinceRegistrationException, InvalidPriceException
	  {
		validator.validatePrice(initialPrice);
		validator.validateYearsSinceRegistration(yearsSinceRegistration);
		
	    float finalPrice = 0;
	    float fidelityDiscount = 
	    		(productType != ProductType.NEW) ? mkStrategy.getFidelityDiscount(yearsSinceRegistration) : 0;

	    finalPrice = getPriceWithDiscount(initialPrice, productType.getDiscount(), fidelityDiscount);
	    
	    return finalPrice;
	  }
}