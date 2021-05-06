package ro.ase.csie.cts.dp.proxy;

public class LoginWith2FactorAuth implements LoginInterface{

	LoginInterface loginModule = null;

	public LoginWith2FactorAuth(LoginInterface loginModule) {
		super();
		this.loginModule = loginModule;
	}

	//fct specific to this proxy
	public boolean checkGeneratedCode(int code) {
		if(code == 1234) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean login(String username, String pass) {
		//when the credianls are ok, add the extra code (what I add)
		if(this.loginModule.login(username, pass)) {
			System.out.println("Please input the generated code that you have received over sms");
			System.out.println("Check received code");
			
			if(checkGeneratedCode(1234)) {
				System.out.println("Hello: " + username);
				return true;
			}
			else {
				System.out.println("the code is not good");
			}
		}
		
		return false;
	}

	@Override
	public boolean checkServerStatus() {
		//dont know how to do it, but the loginModule knows
		return this.loginModule.checkServerStatus(); //callback
	}

	
	
}
