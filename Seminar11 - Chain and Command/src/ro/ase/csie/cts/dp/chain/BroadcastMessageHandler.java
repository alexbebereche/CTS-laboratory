package ro.ase.csie.cts.dp.chain;

public class BroadcastMessageHandler extends ChatHandler {

	@Override
	public void processMessage(ChatMessage msg) {
		// each handler can decide if it can forward or not, depends on the context
		if (msg.destination.toLowerCase().equals("@everyone")) {
			System.out.println("@everyone: " + msg.text);
		}

		// no rule saying if i process the msg, i should (not)forward it

		// in this case, wont matter, always forward the msg
		if (this.next != null) {
			this.next.processMessage(msg);
		}
	}

}
