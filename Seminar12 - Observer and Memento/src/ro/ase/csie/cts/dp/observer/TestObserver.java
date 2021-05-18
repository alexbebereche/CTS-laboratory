package ro.ase.csie.cts.dp.observer;

public class TestObserver {

	public static void main(String[] args) {

		NetworkModule networkModule = new NetworkModule();
		
		NetworkEventHandlerInterface autoSave = new AutoSaveModule();
		NetworkEventHandlerInterface notiifications = new UINotificationsModule();
		
		networkModule.networkStatusChanged(NetworkStatus.UP);
		
		networkModule.registerModule(autoSave);
		networkModule.registerModule(notiifications);
		
		networkModule.networkStatusChanged(NetworkStatus.UP);
		
		networkModule.unregisterModule(autoSave);
		
		networkModule.networkStatusChanged(NetworkStatus.DOWN); //unchecked the option in the game, unregistered...
	}

}
