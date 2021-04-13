package ro.ase.csie.cts.dp.decorator;

public class WoundedDecorator extends AbstractDecorator{

	public WoundedDecorator(SuperHeroCharacter decoratedObject) {
		super(decoratedObject);
	}

	
	
	@Override
	public void move() {
//		super.move();
		//dont call the base class, want to give a new implementation
		System.out.println("The hero is barely moving bcs is wounded");
	}
	
	
}
