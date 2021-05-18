package ro.ase.csie.cts.dp.memento;

public class TestMemento {

	public static void main(String[] args) {

		SuperHero hero = new SuperHero("Superman", 500, "Fly");
		
		HeroRestorePoint initial = hero.saveData();
		
		hero.lifePoints += 500; //change the data
		
		System.out.println("Life points: " + hero.lifePoints);
		hero.restoreData(initial);
		System.out.println("Life points: " + hero.lifePoints);  //recovered the initial state
	}

}
