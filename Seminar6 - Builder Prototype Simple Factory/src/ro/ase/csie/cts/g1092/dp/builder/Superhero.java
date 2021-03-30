package ro.ase.csie.cts.g1092.dp.builder;

public class Superhero {
	String name;
	int lifePoints;
	boolean isVillain;
	boolean isCriticalWounded;
	
	Weapon leftHandWeapon;
	Weapon rightHandWeapon;
	
	String superPower;
	String superSuperPower;
	
	//"removed" empty constructor
	private Superhero() {
		
	}

	public Superhero(String name, int lifePoints, boolean isVillain, boolean isCriticalWounded, Weapon leftHandWeapon,
			Weapon rightHandWeapon, String superPower, String superSuperPower) {
		this.name = name;
		this.lifePoints = lifePoints;
		this.isVillain = isVillain;
		this.isCriticalWounded = isCriticalWounded;
		this.leftHandWeapon = leftHandWeapon;
		this.rightHandWeapon = rightHandWeapon;
		this.superPower = superPower;
		this.superSuperPower = superSuperPower;
	}
	
	//class inside another class in java
	public static class SuperheroBuilder{
		Superhero superhero = null;
		
		//attributes that are mandatory
		public SuperheroBuilder(String name, int lifePoints) {
			this.superhero = new Superhero();  //either call very long constr, or stop here and call the default one
			this.superhero.name = name;
			this.superhero.lifePoints = lifePoints;
			
			//other way
//			this.superhero = new Superhero(name, lifePoints, false, false, null, null, "", "");
		}
		
		public SuperheroBuilder isVillain() {
			superhero.isVillain = true;
			return this; // return the reference to the builder
		}
		
		public SuperheroBuilder isWounded() {
			superhero.isCriticalWounded = true;
			return this;
		}
		
		public SuperheroBuilder setLeftWeapon(Weapon weapon) {
			this.superhero.leftHandWeapon = weapon;
			return this;
		}
		
		public SuperheroBuilder setRightWeapon(Weapon weapon) {
			this.superhero.rightHandWeapon = weapon;
			return this;
		}
		
		public SuperheroBuilder setSuperPower(String superPower) {
			this.superhero.superPower = superPower;
			return this;
		}
		
		public SuperheroBuilder setSuperSuperPower(String superSuperPower) {
			this.superhero.superSuperPower = superSuperPower;
			return this;
		}
		
		//like the get method from the singleton
		public Superhero build() {
			return this.superhero;
		}
	}
	
}
