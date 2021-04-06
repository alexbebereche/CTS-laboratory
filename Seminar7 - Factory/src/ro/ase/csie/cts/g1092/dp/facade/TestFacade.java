	package ro.ase.csie.cts.g1092.dp.facade;

public class TestFacade {

	public static void main(String[] args) {

		//in order to connect to the game from an external app you need to
		//1. create player profile and login
		
		PlayerProfile profile = new PlayerProfile();
		profile.login();
		profile.getUserSettings();
	
		//2. check the subscription, is it still valid?
		Subscription subscription = new Subscription();
		subscription.checkSubscription();
		
		//use the Facade - simplified way (of doing some sequence of actions that we normally do independently)
		GameAPIFacade.createProfileAndConnect();
		
		//3. get the main character
		SuperHero superHero = new SuperHero("Superman",	new Helmet(), new SuperPower());
		
		//imagine needing to know all of these details...if its common, provide a simplified interface
		//it should hide all these details
		
		//instead of copy-pasting it every time, use a facade
	}

}
