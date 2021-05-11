package ro.ase.csie.cts.dp.state.states;

import ro.ase.csie.cts.dp.state.MoveStateInterface;

public class CriticalWoundedState implements MoveStateInterface {

	@Override
	public void moveAtDifferentLocation() {
		System.out.println("the hero cant move (crtically woudned)");
	}
}
