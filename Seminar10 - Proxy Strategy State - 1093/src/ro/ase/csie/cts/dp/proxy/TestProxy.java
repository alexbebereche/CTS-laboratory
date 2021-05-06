package ro.ase.csie.cts.dp.proxy;

public class TestProxy {

	public static void main(String[] args) {

		LoginInterface loginModule = new LoginModule("10.0.0.1", "users");
		
		if(loginModule.login("admin", "1234admin")) {
			System.out.println("Hello admin");
		}
		else {
			System.out.println("Wrong credentials");
		}
		
		//init the same reference used before
		loginModule = new LoginWith2FactorAuth(loginModule);
		//extra layer, see any logic didnt change
		//switch to a different track, the client has no idea, still believes he s working with the login module
		
		
		//the attacks on the player's accounts:
		String[] passwords = new String[] {"1234", "123456", "admin", "root", "1234admin"};
		
		for(String pass : passwords) {
			if(loginModule.login("admin", pass)) {
				System.out.println("Found it! Is " + pass);
				break;
			}
		}
	}

}
