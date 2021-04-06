package ro.ase.csie.cts.g1092.dp.simplefactory;

public class WeaponsFactory {
	
	//what do you want? what weapon do you need?
	public static AbstractWeapon getWeapon(WeaponType type, String desc) { // desc is optional, 99% of cases
		AbstractWeapon weapon = null;
		switch (type) {
		case PISTOL: 
			weapon = new Pistol(desc, 100);
			break;
		case MACHINE_GUN:
			weapon = new MachineGun(desc, 500, 1000);
			break;
		case BAZOOKA:
			weapon = new Bazooka(desc);
			break;
		default:
			throw new UnsupportedOperationException("new type not covered");
		}
		
		return weapon;
	}
}
