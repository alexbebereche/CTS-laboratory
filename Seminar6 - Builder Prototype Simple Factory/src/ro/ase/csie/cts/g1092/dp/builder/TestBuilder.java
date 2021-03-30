package ro.ase.csie.cts.g1092.dp.builder;

public class TestBuilder {

	public static void main(String[] args) {
		
		//1. create
//		Superhero superhero = new Superhero(); // not ok, create an empty superhero, need to init it
		//2. init
		//TODO: dont forget to initialize the object with values
		
		Weapon pistol = new Weapon("Pistol");
		Superhero superHero = 
				new Superhero("Superman", 100, false, false, pistol, pistol, "He can fly", "");
		
		Superhero superHero2 = 
				new Superhero("Superman", 100, false, false, pistol, null, "", "");
		
		
		//builder version
		//like having a constr that asks me only for name and lifepoints
		Superhero superman = 
				new Superhero.SuperheroBuilder("Superman", 100)
				.setLeftWeapon(pistol)
				.setSuperPower("He can fly")
				.setSuperSuperPower("Laser eyes")
				.build();
		
		// signature of a build implementation: when splitting on multiple lines
		
		Superhero joker = 
				new Superhero.SuperheroBuilder("Joker", 200)
				.isVillain() // dont write false/true, its weird
				.setRightWeapon(pistol)
				.build();	//build is the "be aware" sign here
		
		//at this point, anyone can create objects in a single operation
		//other advantage: no need to make a lot of constructors, they are flexible
		
		Superhero dummyHero = 
				new Superhero.SuperheroBuilder("Dummy", 50).build();
	}

}
