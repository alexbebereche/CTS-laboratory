package src.ro.ase.csie.cts.dp.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Model3DFlyweight implements Model3DFlyweightInterface{

	//shared data
	String modelName;
	List<Integer> points = new ArrayList<>(); 
	// defined as List to handle multiple list types
	//careful to import from java.util
	//generally, better to define as the abstract class, as we did earlier
	
	
	@Override
	public void loadModel(String fileName) {
		
	}

	@Override
	public void display(NPCCoordinates coordinates) {
		
	}
	
}
