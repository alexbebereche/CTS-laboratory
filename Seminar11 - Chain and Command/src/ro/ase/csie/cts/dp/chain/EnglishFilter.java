package ro.ase.csie.cts.dp.chain;

public class EnglishFilter extends ChatHandler {

	// use a dictionary
	// can be configured from a file, db...etc
	public static String[] forbiddenWords = new String[] { "violent", "hit", "kill" };

	public int ageLimit;

	// this handler has a constr bcs it needs the data
	public EnglishFilter(int ageLimit) {
		super();
		this.ageLimit = ageLimit;
	}

	@Override
	public void processMessage(ChatMessage msg) {
		boolean isSafe = true; // we are optimists

		// now, go through the words
		for (String word : forbiddenWords) {
			if (msg.text.toLowerCase().contains(word)) {
				isSafe = false;
				break;
			}
		}

		if (isSafe) {
			if (this.next != null) {
				// pass the event into the chain
				this.next.processMessage(msg); // same method, for the next node in chain; pass the handler
			}
		}
	}

}
