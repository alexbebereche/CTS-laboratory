package ro.ase.csie.cts.dp.state.states;

import ro.ase.csie.cts.dp.state.MoveStateInterface;

public class NormalState implements MoveStateInterface{

	@Override
	public void moveAtDifferentLocation() {
		System.out.println("The hero is running(no issues)");
	}
	
	
}
