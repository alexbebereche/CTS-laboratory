package ro.ase.csie.cts.dp.state;

import ro.ase.csie.cts.dp.state.states.CriticalWoundedState;
import ro.ase.csie.cts.dp.state.states.NormalState;
import ro.ase.csie.cts.dp.state.states.WoundedState;

public class SuperHero {
	
	public static final int CRITICAL_VALUE = 50; //less than that, critically wounded...
	public static final int WOUNDED_VALUE = 200; //above, im normal
	
	//a lot of condition: eg:
	//if critical wounded, will move slower...
	//in time, it may become more complex
	
	String name;
	int lifePoints;
	
	//dont implem all here...
//	MoveStateInterface moveState = null; // or also here: new NormalState();
	MoveStateInterface moveState = new NormalState();
	
	public void move() {
		if(this.moveState != null) {
			this.moveState.moveAtDifferentLocation(); // delegate
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	public SuperHero(String name, int lifePoints) {
		super();
		this.name = name;
		this.lifePoints = lifePoints;
		
		//for state machine, should set the object in an initial state!!!
		this.moveState = new NormalState(); //redundant here for now, better before constr
	}
	
	//now, where is the difference betw state and strategy? the object in the state pattern
	//has the power to change its own state
	
	
	//in gof, setState is suggested, but here its not that important
	//not gonna implement it here, its mandatory to set the state somewhere here:
	
	public void takeAHit(int points) {
		this.lifePoints -= points; // thats what we used to do...
		//we take a hit, the state changes
		
		if(this.lifePoints <= CRITICAL_VALUE) {
			this.moveState = new CriticalWoundedState(); // the object is changing its own strategy...
		}
		else if(this.lifePoints <= WOUNDED_VALUE) {
			this.moveState = new WoundedState();
		}
	}
	
	//opposite fct
	public void heal(int points) {
		this.lifePoints += points;
		
		if(this.lifePoints > WOUNDED_VALUE) {
			this.moveState = new NormalState();
		}
		else if(this.lifePoints > CRITICAL_VALUE) {
			this.moveState = new WoundedState();
		}
		
		//else, already in critical state..
	}
}
