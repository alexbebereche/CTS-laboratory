package ro.ase.cts.g1092.refactor.phase4;


public enum ProductType {
	// these are constant references to objects
//	NEW, DISCOUNTED, LIMITED_STOCK, LEGACY; // need ; only if adding attr
	NEW(0), DISCOUNTED(0.1f), LIMITED_STOCK(0.25f), LEGACY(0.35f); // need ; only if adding attr
// NEW_TYPE(0.7f);
	
	// imagine this is a class, not strange to see this
	private float discount;
	
	// in enums we have only private constructors
	private ProductType(float discountValue) {
		this.discount = discountValue;
	}
	
	// after defining constr with arg, dont have def constr anymore
	// dont want this
	// when defining a new val, need to handle it...
	// want to force the programmer to write a val
	
	public float getDiscount() {
		return this.discount;
	}
}
