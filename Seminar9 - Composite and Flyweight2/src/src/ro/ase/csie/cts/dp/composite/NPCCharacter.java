package src.ro.ase.csie.cts.dp.composite;

public class NPCCharacter extends AbstractNode{

	//like a normal class, but ignore the extend, it just helps us
	String name;
	int power;
	
	
	public NPCCharacter(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}

	@Override
	public void attack(String playerName) {
		System.out.println(String.format("%s is attacking %s",
				name, playerName));;
	}

	@Override
	public void retreat() {
		System.out.println(String.format("%s is retreating", name)); //name of the npc character
	}

	@Override
	public void move() {
		System.out.println(String.format("%s is moving", name));
	}

	@Override
	public void addNode(AbstractNode node) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void removeNode(AbstractNode node) {
		throw new UnsupportedOperationException();

		
	}

	@Override
	public AbstractNode getNode(int index) {
		throw new UnsupportedOperationException();

	}

}