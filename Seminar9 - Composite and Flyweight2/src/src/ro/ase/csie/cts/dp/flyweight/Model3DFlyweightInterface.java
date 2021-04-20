package src.ro.ase.csie.cts.dp.flyweight;

public interface Model3DFlyweightInterface {

	public void loadModel(String fileName);
	
	//at least 1 method...brings unique data with the shared data
	public void display(NPCCoordinates coordinates);
}
