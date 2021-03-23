package ro.ase.csie.cts.lab5.singleton.enumeration;

// implement the singleton as an enumeration
// "singleton enum"
public enum DbConnection {
	INSTANCE;
	
	String socket;
	String schema;
	
	public void setAttr(String socket, String schema) {
		this.socket = socket;
		this.schema = schema;
	}
	
	public void doProcess() {
		System.out.println("socket:" + this.socket + " schema: " + schema);
	}
	
	
	
}
