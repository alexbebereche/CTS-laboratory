package ro.ase.csie.cts.dp.composite;

import java.util.ArrayList;

public class Group extends AbstractNode{
	//composite class

	String groupName;
	ArrayList<AbstractNode> nodes = new ArrayList<AbstractNode>(); //eager instantiation
	
	
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	@Override
	public void attack(String playerName) {
		for(AbstractNode node : nodes) {
			node.attack(playerName);
		}
	}

	@Override
	public void retreat() {
		for(AbstractNode node : nodes) {
			node.retreat();
		}
		
	}

	@Override
	public void move() {
		//lets say we cant move the entire group together, should move independently, throw an exc
		throw new UnsupportedOperationException();
	}

	@Override
	public void addNode(AbstractNode node) {
		this.nodes.add(node);
	}

	@Override
	public void removeNode(AbstractNode node) {
		this.nodes.remove(node); //lucky arraylist has a remove method, based on index or reference
	}

	@Override
	public AbstractNode getNode(int index) {
		return this.nodes.get(index);
	}
}
