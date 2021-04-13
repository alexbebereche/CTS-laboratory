package ro.ase.csie.cts.dp.decorator;


public class TestDecorator {

	public static void main(String[] args) {
		SuperHeroCharacter fantasyHero = new FantasySuperHero("Blue dragon", 1000, true);
		fantasyHero.move();
		fantasyHero.takeAHit(500);
		
		//the dragon should look and behave like a wounded one
		
		//want to decorate it
		SuperHeroCharacter woundedHero = new WoundedDecorator(fantasyHero);
		
		//how will this change?
		woundedHero.move();
		
		fantasyHero.heal(200);
		
		//add a shield/armor to the dragon
		SuperHeroCharacter heroWithShield = 
				new ShieldDecorator(fantasyHero, 200);
		heroWithShield.takeAHit(500);
		//now, took a hit of only 300, as we have a shield for 200 and took a hit of 500
		
		SuperHeroCharacter woundedHeroWithShield = 
				new ShieldDecorator(woundedHero, 250); // here, pass the previous decorated obj
	
		woundedHeroWithShield.move();
		woundedHeroWithShield.takeAHit(260);
	}

}
