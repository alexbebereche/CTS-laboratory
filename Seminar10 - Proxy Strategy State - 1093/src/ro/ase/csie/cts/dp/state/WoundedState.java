package ro.ase.csie.cts.dp.state;

public class WoundedState implements MoveStateInterface{
	
	@Override
	public void moveAtDifferentLocation() {
		System.out.println("The hero is moving slowly");
	}
}
