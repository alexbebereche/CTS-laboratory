package ro.ase.csie.cts.dp.observer;

import java.util.ArrayList;
import java.util.List;

//OBSERVABLE
public class NetworkModule {

	List<NetworkEventHandlerInterface> modules = new ArrayList<NetworkEventHandlerInterface>(); // observers

	// when defining a class that handlers a collections, define methods to
	// interract with it

	public void registerModule(NetworkEventHandlerInterface module) {
		modules.add(module);
	}

	// for the observer pattern, need to allow the observer to unregister

	public void unregisterModule(NetworkEventHandlerInterface module) {
		modules.remove(module);
	}
	
	public void networkStatusChanged(NetworkStatus status) { //receive a status
		if(status == NetworkStatus.UP) {
			for(NetworkEventHandlerInterface module : modules) {
				module.notifyNetworkUp();
			}
		}
		if(status == NetworkStatus.DOWN) {
			for(NetworkEventHandlerInterface module : modules) {
				module.notifyNetworkDown();
			}
		}
	}
}
