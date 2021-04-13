package ro.ase.csie.cts.dp.adapter.disney;

public interface DisneyActions {
	
	//abstract is redundant
	public abstract void changeLocation(int x, int y);
	public abstract void isWounded(int lostLifePoints);
	public abstract void isHealing(int recoveredPoints);

	//they dont have a crouch method
	
	public abstract String getName();
	public abstract int getPower();
	//now, the interface is seeing idc how i store those values, just need them
}
