package ro.ase.csie.cts.dp.chain;

public abstract class ChatHandler { // similar to a linked list

	//no rules saying i can store attr here, a constr...etc
	//UML schemas are generic, need to adapt them
	
	
	
	ChatHandler next = null;

	// data asociated with the event

	// need a msg, payload
	public abstract void processMessage(ChatMessage msg);

	public void setNext(ChatHandler next) {
		this.next = next;
	}
	
	
	//define the setNext here is best
	
}
