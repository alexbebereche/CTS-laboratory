package ro.ase.csie.cts.dp.observer;

public interface NetworkEventHandlerInterface {
	//now,can notify the observable
	
	public void notifyNetworkDown();
	public void notifyNetworkUp();
	
}
