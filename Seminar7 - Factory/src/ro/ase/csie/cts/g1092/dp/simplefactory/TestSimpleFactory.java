package ro.ase.csie.cts.g1092.dp.simplefactory;

public class TestSimpleFactory {
	
	public static void main(String[] args) {
		SuperHero superman = new SuperHero("Superman");
		
		//factory can remove this
		superman.setWeapon(new Bazooka("boom"));  // see dotted line in UML
		superman.setWeapon(new MachineGun("MG", 50, 100));
		
		AbstractWeapon bazooka =
				WeaponsFactory.getWeapon(WeaponType.BAZOOKA, "boom");
		superman.setWeapon(bazooka);
		superman.setWeapon(WeaponsFactory.getWeapon(
				WeaponType.MACHINE_GUN, "MG"));
		
		//why is a big difference? simulated, not affected by a change in the class
		//when chaning MG, update the factory, new version, still not affected when using factory
		//dont change the factory method header, but can change something else
		
	}
}
