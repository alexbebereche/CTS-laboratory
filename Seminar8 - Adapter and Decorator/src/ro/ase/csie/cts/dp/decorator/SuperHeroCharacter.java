package ro.ase.csie.cts.dp.decorator;

public abstract class SuperHeroCharacter {
	
	String name;
	int power;
	
	
	
	public SuperHeroCharacter(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}
	
	public abstract void move();
	public abstract void crouch();
	public abstract void takeAHit(int points);
	public abstract void heal(int points);	
}
