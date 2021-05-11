package ro.ase.csie.cts.dp.chain;

public class TestChain {

	public static void main(String[] args) {

		//lets define the chain
		//first, we define the handlers, then we will link them together
		
		final int AGE_LIMIT = 7;
		
		//Liskov, handle by generic reference!
		ChatHandler broadcastNode = new BroadcastMessageHandler();
		ChatHandler privateNode = new PrivateMessageHandler();
		ChatHandler filterNode = new EnglishFilter(AGE_LIMIT);
		
		//want to filter all the messages, should be the first node
		filterNode.setNext(privateNode);
		privateNode.setNext(broadcastNode); //no following node; only broadcast has next == null
		
//		privateNode.setNext(null); //print no msg; filter node is the first one
		//order: filter->private->broadcast
		
		//if i change the sol and add new bullets here: dont need to change any of the existing classes, just add a new 
		//subclass of chathandler and link it
		
		//can incapsulate the chain:...
		//its a chain of functions, not a ds
		ChatHandler chatServer = filterNode;
		chatServer.processMessage(new ChatMessage("@everyone", "Hello", 0));
		chatServer.processMessage(new ChatMessage("@everyone", "hit superman. It's a bot", 0)); // check if the filter works with the second param
		chatServer.processMessage(new ChatMessage("@john", "hello! let's join the party", 0));
		
		chatServer.processMessage(new ChatMessage("@john", "hello! will send you an invite", 0));
		
	}

}
