package ro.ase.csie.cts.dp.composite;

public class TestComposite {

	public static void main(String[] args) {
		
//		Group group1 = new Group("Red team"); 
		//should handle by abstract ref
		AbstractNode group1 = new Group("Red team");
		group1.addNode(new NPCCharacter("Soldier 1", 100));
		group1.addNode(new NPCCharacter("Soldier 2", 100));

		AbstractNode group2 = new Group("Blue team");
		group2.addNode(new NPCCharacter("Soldier 3", 100));
		group2.addNode(new NPCCharacter("Demolition team", 300));

		AbstractNode levelGroup = new Group("Level2");
		levelGroup.addNode(new NPCCharacter("Level Boss", 500));
		levelGroup.addNode(group1);
		levelGroup.addNode(group2);
		
		levelGroup.attack("Superman");
		levelGroup.retreat();
		levelGroup.getNode(0).move(); //generally, a hashmap should be used
		
		//similar to trees, but have different purposes
		//manage groups of objects and scale that to many levels - composition
		//ds - allow u to search fast
		
		
	}

}
