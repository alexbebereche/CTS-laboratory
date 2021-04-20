package src.ro.ase.csie.cts.dp.flyweight;

import java.util.HashMap;
import java.util.Map;


public class Model3DFactory {
	//hashmap: should be static!!!
	static Map<String, Model3DFlyweightInterface> models = new HashMap<String, Model3DFlyweightInterface>();
	
	//eager instantiation
	static {
		models.put(ModelType.SOLDIER.toString(), new Model3DFlyweight());
		models.put(ModelType.LEVEL_BOSS.toString(), new Model3DFlyweight());
	}
	
	static Model3DFlyweightInterface getModel(ModelType type) {
		return models.get(type.toString());
	}
}
