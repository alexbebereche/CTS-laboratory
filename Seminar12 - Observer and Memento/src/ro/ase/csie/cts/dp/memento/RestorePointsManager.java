package ro.ase.csie.cts.dp.memento;

import java.util.ArrayList;
import java.util.List;

public class RestorePointsManager {

	List<HeroRestorePoint> restorePoints = new ArrayList<HeroRestorePoint>();
	
	public void addRestorePoint(HeroRestorePoint point) {
		restorePoints.add(point);
	}
	
	//get
	public HeroRestorePoint getRestorePoint(int index) {
		if(index < 0 || index >= restorePoints.size()) {
			throw new UnsupportedOperationException(); //own exception, like wrong index...
		}
		else {
			HeroRestorePoint point = restorePoints.get(index);
			restorePoints.remove(index);
			return point;
		}
	}
}
