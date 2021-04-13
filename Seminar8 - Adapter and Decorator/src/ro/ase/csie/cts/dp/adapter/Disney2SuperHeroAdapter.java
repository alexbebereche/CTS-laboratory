package ro.ase.csie.cts.dp.adapter;

import ro.ase.csie.cts.dp.adapter.disney.DisneyActions;

public class Disney2SuperHeroAdapter extends SuperHeroCharacter{
//Disney is source, superhero is destination
	
	
	
	DisneyActions disneyCharacter = null; //reference to the existing objects, need also to implement the same 
	//interface as the destination type

	//in interface we dont have name and lifepoints...
	public Disney2SuperHeroAdapter(DisneyActions disneyCharacter) {
		
		super(disneyCharacter.getName(), disneyCharacter.getPower());
		this.disneyCharacter = disneyCharacter; // dont forget to init the reference
	}
	@Override
	public void move() {
		this.disneyCharacter.changeLocation(0, 0);
	}
	
	//disneey characters werent able to do this before
	@Override
	public void crouch() {
		System.out.println(String.format("%s is crouching", disneyCharacter.getName()));
	}
	@Override
	public void takeAHit(int points) {
		this.disneyCharacter.isWounded(points);
	}
	@Override
	public void heal(int points) {
		this.disneyCharacter.isHealing(points);
	}
		
	
}
