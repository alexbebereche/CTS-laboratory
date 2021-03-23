package ro.ase.csie.cts.lab5.singleton.enumeration;

public class TestSingletonEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection.INSTANCE.setAttr("127.0.0.1", "localDb");
		DbConnection.INSTANCE.setAttr("10.0.0.1", "prodDb");
		
		DbConnection.INSTANCE.doProcess();
		DbConnection.INSTANCE.doProcess();
		
	}

}
