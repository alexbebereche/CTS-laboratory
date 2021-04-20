package ro.ase.csie.cts.dp.composite;

public abstract class AbstractNode implements NPCActions{
	//methods specific to the composite nodes:
	
	//abstract class, not interface, so need to say its abstract
	//CRUD operations
	public abstract void addNode(AbstractNode node);
	public abstract void removeNode(AbstractNode node);
	public abstract AbstractNode getNode(int index);
	
	//can also be defined like this; that way, wont need to override in NPCCharacter, much cleaner
	
//	public void addNode(AbstractNode node) {
//		throw new UnsupportedOperationException();
//
//	}
}
