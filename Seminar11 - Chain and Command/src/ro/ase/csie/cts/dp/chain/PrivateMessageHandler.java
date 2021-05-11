package ro.ase.csie.cts.dp.chain;

public class PrivateMessageHandler extends ChatHandler {

	@Override
	public void processMessage(ChatMessage msg) {
		// need to check the destination
		if (msg.destination.toLowerCase().equals("@everyone")) {
			if (this.next != null) {
				// easy to forget, mistake; will lead to infinite recursion; dont forget NEXT
				this.next.processMessage(msg);
			}
		} else {
			System.out.println("Private msg for " + msg.destination + " : " + msg.text);
		}
	}

}
