package ro.ase.csie.cts.dp.state;

public class TestState {

	public static void main(String[] args) {
		
		SuperHero superman = new SuperHero("Superman", 500);
		
		superman.move(); // move normally
	
		superman.takeAHit(350);
		superman.move(); // moving slowly
		
		superman.takeAHit(110); // critically wounded
		superman.move();
		
		superman.heal(500);
		superman.move(); // will run again
		
	}

}
