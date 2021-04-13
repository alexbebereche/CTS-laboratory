package ro.ase.csie.cts.dp.adapter;

import java.util.ArrayList;

import ro.ase.csie.cts.dp.adapter.disney.DisneyActions;
import ro.ase.csie.cts.dp.adapter.disney.DonaldDuck;

public class TestAdapter {

	public static void main(String[] args) {
		
		//simulate the game by using the existing characters framework
		SuperHeroCharacter fantasyHero = new FantasySuperHero("Blue dragon", 1000, true);
		fantasyHero.move();
		fantasyHero.takeAHit(500);
		fantasyHero.heal(200);
		
		//use the blue dragon as a Disney character - not like this, but
		//use a Disney character as a SuperHeroCharacter 
		
		//adapt our fantasy hero to the new framework
		//always check which is the direction for the adapt 
		
		DisneyActions donald = new DonaldDuck(500);
		donald.changeLocation(100, 600);
		donald.isWounded(100);
		donald.isHealing(90);
		
		ArrayList<SuperHeroCharacter> gameHeroes = new ArrayList<SuperHeroCharacter>();
		gameHeroes.add(fantasyHero);
//		gameHeroes.add(donald);
		
		//cant add donald directly, but can do this
		Disney2SuperHeroAdapter donaldAdapter = new Disney2SuperHeroAdapter(donald);
		
		gameHeroes.add(donaldAdapter);
		
		System.out.println("-------------");
		
		//can use them as superhero character
		for(SuperHeroCharacter hero : gameHeroes) {
			hero.crouch();
			hero.takeAHit(50);
			hero.heal(50);
		}
	}

}
