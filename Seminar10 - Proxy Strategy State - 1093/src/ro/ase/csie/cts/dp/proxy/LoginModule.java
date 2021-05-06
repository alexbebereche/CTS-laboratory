package ro.ase.csie.cts.dp.proxy;

public class LoginModule implements LoginInterface{
	//can store data here if i want (not explicitely defined in gof uml)
	
	String serverIP;
	String dbConnection;
	
	
	
	public LoginModule(String serverIP, String dbConnection) {
		super();
		this.serverIP = serverIP;
		this.dbConnection = dbConnection;
	}


	@Override
	public boolean login(String username, String pass) {
		System.out.println("Connecting to the db: " + dbConnection);
		if(username.toLowerCase().equals("admin") && pass.equals("1234admin"))
			return true;
		else
			return false;
	}
	
	
	@Override
	public boolean checkServerStatus() {
		return true;
	}
	
}
