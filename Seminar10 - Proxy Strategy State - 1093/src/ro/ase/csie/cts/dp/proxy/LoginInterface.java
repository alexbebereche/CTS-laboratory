package ro.ase.csie.cts.dp.proxy;

public interface LoginInterface {
	
	public boolean login(String username, String pass); //checking credentials
	public boolean checkServerStatus();
	
}
